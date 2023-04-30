/*
    Plugin-SDK (Grand Theft Auto) source file
    Authors: GTA Community. See more here
    https://github.com/DK22Pac/plugin-sdk
    Do not delete this comment block. Respect others' work!
*/
#include <lc_stdio.h>
#include <lc_math.h>
#include <injector.h>
#include <erl.h>

char * erl_id = "v_gps";
char * erl_dependancies[] = {
    "libc",
    "injector",
    //"rwcore",
    //"cfont",
    0
};

enum eVehicleType {
    VEHICLE_AUTOMOBILE,
    VEHICLE_MTRUCK,
    VEHICLE_QUAD,
    VEHICLE_HELI,
    VEHICLE_PLANE,
    VEHICLE_BOAT,
    VEHICLE_TRAIN,
    VEHICLE_FHELI,
    VEHICLE_FPLANE,
    VEHICLE_BIKE,
    VEHICLE_BMX,
    VEHICLE_TRAILER
};

typedef float RwReal;
typedef unsigned int RwUInt32;
typedef int RwInt32;

float* RecipNearClip = (float*)0x66BCEC;
float* NearScreenZ = (float*)0x66BCF0;

#define RWRGBALONG(r,g,b,a) ((RwUInt32) (((a) << 24) | ((r) << 16) | ((g) << 8) | (b)))

typedef struct RwSky2DVertexFields RwSky2DVertexFields;

typedef struct
{
    float a;
    float b;
    float g;
    float r;
} RwRGBAReal;

typedef struct
{
    float x;
    float y;
} CVector2D;

typedef struct
{
    float x;
    float y;
    float z;
} CVector;


struct RwSky2DVertexFields
{
    CVector2D      scrVertex;              /**< Object space vertex */
    RwReal         camVertex_z;            /**< Camera space z (for fog table) */
    RwReal         u;                      /**< Texture coordinate */
    RwReal         v;                      /**< Texture coordinate */
    RwReal         recipZ;                 /**< Recipz */
    RwReal         pad1;                   /**< Padding (fog table) */
    RwRGBAReal     color;                  /**< Color */
    CVector        objNormal;              /**< We allocate this, even though
                                            * we don't use it - we may want
                                            * to later.
                                            */
    RwReal         pad2;                   /**< Alignment padding */
};

typedef union RwSky2DVertexAlignmentOverlay RwSky2DVertexAlignmentOverlay;

union RwSky2DVertexAlignmentOverlay
{
    RwSky2DVertexFields els;                            /**< Internal use */
    __uint128_t qWords[4];                                /**< Internal use */
};

typedef struct RwSky2DVertex RwSky2DVertex;

struct RwSky2DVertex
{
    RwSky2DVertexAlignmentOverlay u;                    /**< Internal use */
};

typedef RwSky2DVertex  RwIm2DVertex;

typedef struct
{
    short m_nAreaId;
    short m_nNodeId;
} CNodeAddress;

typedef struct
{
    unsigned char r;
    unsigned char g;
    unsigned char b;
    unsigned char a;
} CRGBA;

CRGBA (*new_CRGBA)(CRGBA*, unsigned char, unsigned char, unsigned char, unsigned char) = (CRGBA (*)(CRGBA*, unsigned char, unsigned char, unsigned char, unsigned char))0x02A53C0;

enum eFontAlignment {
    ALIGN_CENTER,
    ALIGN_LEFT,
    ALIGN_RIGHT
};

enum eFontStyle {
    FONT_GOTHIC,
    FONT_SUBTITLES,
    FONT_MENU,
    FONT_PRICEDOWN
};

#define MAX_NODE_POINTS 2000
#define GPS_LINE_WIDTH  2.5f
#define GPS_LINE_R  180
#define GPS_LINE_G  24
#define GPS_LINE_B  24
#define GPS_LINE_A  255
#define MAX_TARGET_DISTANCE 20.0f

#define LOWORD(a) ((unsigned short)(a))
#define HIWORD(a) ((unsigned short)(((unsigned int)(a) >> 16) & 0xFFFF))

static void Setup2dVertex(RwIm2DVertex *vertex, float x, float y) {
    vertex->u.els.scrVertex.x = x;
    vertex->u.els.scrVertex.y = y;
    vertex->u.els.v = 0.0f;
    vertex->u.els.u = 0.0f;
    vertex->u.els.camVertex_z = *NearScreenZ + 0.0001f;
    vertex->u.els.recipZ = *RecipNearClip;
    vertex->u.els.color.r = 168.0f;
    vertex->u.els.color.g = 0.0f;
    vertex->u.els.color.b = 140.0f;
    vertex->u.els.color.a = 255.0f;
}

unsigned int (*FindPlayerPed)(int playerIndex) = (unsigned int (*)(int))0x264040;

void (*CFont_SetOrientation)(unsigned char) = (void (*)(unsigned char))0x2A8C50;
void (*CFont_SetColor)(CRGBA*) = (void (*)())0x2A8900;
void (*CFont_SetBackground)(unsigned char, unsigned char) = (void (*)(unsigned char, unsigned char))0x002A8BE0;
void (*CFont_SetWrapx)(float) = (void (*)(float))0x002A8A60;
void (*CFont_SetScale)(float, float) = (void (*)(float, float))0x002A8800;
void (*CFont_SetFontStyle)(unsigned char) = (void (*)(unsigned char))0x002A89F0;
void (*CFont_SetProportional)(unsigned char) = (void (*)(unsigned char))0x002A8BD0;
void (*CFont_SetDropShadowPosition)(char) = (void (*)(char))0x002A8B90;
void (*CFont_SetDropColor)(CRGBA*) = (void (*)())0x002A8AA0;
void (*CFont_PrintString)(float, float, const char*) = (void (*)(float, float, const char*))0x2A6E20;

void (*CRadar_TransformRadarPointToScreenSpace)(CVector2D*, CVector2D*) = (void (*)(CVector2D*, CVector2D*))0x0026AE00;

int (*sprintf)(char *str, const char *format, ...) = (int (*)(char *, const char *, ...))0x00550F10;

void (*CHud_Draw)() = (void (*)())0x2AFFA0;

void (*CHud_DrawGangOverlay)(int) = (void (*)(int))0x0026E830;
float (*CWorld_FindGroundZForCoord)(float, float) = (float (*)(float, float))0x002869C0;

static int gpsShown;
static float gpsDistance;
static CNodeAddress resultNodes[MAX_NODE_POINTS];
static CVector2D nodePoints[MAX_NODE_POINTS];
static RwIm2DVertex lineVerts[MAX_NODE_POINTS * 4];

typedef struct {
    unsigned int   m_nColour; // see eBlipColour
    unsigned int   m_nEntityHandle;
    CVector        m_vecPos;
    unsigned short m_nCounter;
    float          m_fSphereRadius;
    unsigned short m_nBlipSize;
    unsigned int  *m_pEntryExit;
    unsigned char  m_nRadarSprite; // see eRadarSprite
    unsigned char  m_bBright : 1; // It makes use of bright colors. Always set.
    unsigned char  m_bInUse : 1; // It is available.
    unsigned char  m_bShortRange : 1; // It doesn't show permanently on the radar.
    unsigned char  m_bFriendly : 1; // It is affected by BLIP_COLOUR_THREAT.   
    unsigned char  m_bBlipRemain : 1; // It has the priority over the entity (it will still appear after the entity's deletion).
    unsigned char  m_bBlipFade : 1; // Possibly a leftover. Always unset (unused).
    unsigned char  m_nCoordBlipAppearance : 2; // see eBlipAppearance
    unsigned char  m_nBlipDisplay : 2; // see eBlipDisplay
    unsigned char  m_nBlipType : 4; // see eBlipType
} tRadarTrace;

unsigned int* FrontEndMenuManager_m_nTargetBlipIndex = (unsigned int*)0x6FF970;
tRadarTrace* CRadar_ms_RadarTrace = (tRadarTrace*)0x701F00;

void (*CRadar_ClearBlip)(int) = (void (*)(int))0x26B9A0;

void (*FindPlayerCoors)(CVector *outPoint, int playerIndex) = (void (*)(CVector *, int))0x263C90;

int (*printf)(const char *, ...) = (int (*)(const char *, ...))0x54F7D0;

float DistanceBetweenPoints(CVector* v1, CVector* v2) {
    return sqrtf((v2->x - v1->x) * (v2->x - v1->x) + (v2->y - v1->y) * (v2->y - v1->y));
}

void (*PreRenderWater)() = (void (*)())0x182130;

void autoDisableTarget() {
    CVector player_coords;

    PreRenderWater();

    FindPlayerCoors(&player_coords, 0);

    if (*FrontEndMenuManager_m_nTargetBlipIndex
        && CRadar_ms_RadarTrace[LOWORD(*FrontEndMenuManager_m_nTargetBlipIndex)].m_nCounter == HIWORD(*FrontEndMenuManager_m_nTargetBlipIndex)
        && CRadar_ms_RadarTrace[LOWORD(*FrontEndMenuManager_m_nTargetBlipIndex)].m_nBlipDisplay
        && FindPlayerPed(-1)
        && DistanceBetweenPoints(&player_coords, &CRadar_ms_RadarTrace[LOWORD(*FrontEndMenuManager_m_nTargetBlipIndex)].m_vecPos) < MAX_TARGET_DISTANCE)
    {
        CRadar_ClearBlip(*FrontEndMenuManager_m_nTargetBlipIndex);
        *FrontEndMenuManager_m_nTargetBlipIndex = 0;
    }
}

int (*CPathFind_DoPathSearch)(unsigned int*, unsigned char, CVector, CNodeAddress, CVector, CNodeAddress*, short *, int, float *, float, CNodeAddress*, float, int, CNodeAddress, int, int) = (int (*)(unsigned int, unsigned char, CVector, CNodeAddress, CVector, CNodeAddress*, short *, int, float *, float, CNodeAddress*, float, int, CNodeAddress, int, int))0x1E5930;

unsigned int* ThePaths = (unsigned int*)0x006A6180;

unsigned int FrontEndMenuManager = 0x6FF940;

unsigned int CPathFind_FindNodePointer(void *this, CNodeAddress a2)
{
    return *((unsigned int *)this + a2.m_nAreaId + 513) + 28 * a2.m_nNodeId;
}

CVector CPathNode_GetCoors(unsigned int this)
{
    CVector out;

    out.x = (float)*(short *)(this + 8) * 0.125f;
    out.y = (float)*(short *)(this + 10) * 0.125f;
    out.z = (float)*(short *)(this + 12) * 0.125f;
    return out;
}


#define RWFORCEENUMSIZEINT ((RwInt32)((~((RwUInt32)0))>>1))

enum RwPrimitiveType
{
    rwPRIMTYPENAPRIMTYPE = 0,   /**<Invalid primative type */
    rwPRIMTYPELINELIST = 1,     /**<Unconnected line segments, each line is specified by
                                 * both its start and end index, independently of other lines
                                 * (for example, 3 segments specified as 0-1, 2-3, 4-5) */
    rwPRIMTYPEPOLYLINE = 2,     /**<Connected line segments, each line's start index
                                 * (except the first) is specified by the index of the end of
                                 * the previous segment (for example, 3 segments specified as
                                 * 0-1, 1-2, 2-3) */
    rwPRIMTYPETRILIST = 3,      /**<Unconnected triangles: each triangle is specified by
                                 * three indices, independently of other triangles (for example,
                                 * 3 triangles specified as 0-1-2, 3-4-5, 6-7-8) */
    rwPRIMTYPETRISTRIP = 4,     /**<Connected triangles sharing an edge with, at most, one
                                 * other forming a series (for example, 3 triangles specified
                                 * as 0-2-1, 1-2-3-, 2-4-3) */
    rwPRIMTYPETRIFAN = 5 ,      /**<Connected triangles sharing an edge with, at most,
                                 * two others forming a fan (for example, 3 triangles specified
                                 * as 0-2-1, 0-3-2, 0-4-3) */
    rwPRIMTYPEPOINTLIST = 6,    /**<Points 1, 2, 3, etc. This is not
                                 * supported by the default RenderWare
                                 * immediate or retained-mode pipelines
                                 * (except on PlayStation 2), it is intended
                                 * for use by user-created pipelines */
    rwPRIMITIVETYPEFORCEENUMSIZEINT = RWFORCEENUMSIZEINT
};

enum RwRenderState
{
    rwRENDERSTATENARENDERSTATE = 0,

    rwRENDERSTATETEXTURERASTER,
        /**<Raster used for texturing (normally used in immediate mode). 
         *  The value is a pointer to an \ref RwRaster.
         * Default: NULL.
         */
    rwRENDERSTATETEXTUREADDRESS,
        /**<\ref RwTextureAddressMode: wrap, clamp, mirror or border.
         * Default: rwTEXTUREADDRESSWRAP.
         */
    rwRENDERSTATETEXTUREADDRESSU,
        /**<\ref RwTextureAddressMode in u only.
         * Default: rwTEXTUREADDRESSWRAP.
         */
    rwRENDERSTATETEXTUREADDRESSV,
        /**<\ref RwTextureAddressMode in v only.
         * Default: rwTEXTUREADDRESSWRAP.
         */
    rwRENDERSTATETEXTUREPERSPECTIVE,
        /**<Perspective correction on/off (always enabled on many platforms).
         */
    rwRENDERSTATEZTESTENABLE,
        /**<Z-buffer test on/off.
         * Default: TRUE.
         */
    rwRENDERSTATESHADEMODE,
        /**<\ref RwShadeMode: flat or gouraud shading.
         * Default: rwSHADEMODEGOURAUD.
         */
    rwRENDERSTATEZWRITEENABLE,
        /**<Z-buffer write on/off.
         * Default: TRUE.
         */
    rwRENDERSTATETEXTUREFILTER,
        /**<\ref RwTextureFilterMode: point sample, bilinear, trilinear, etc.
         * Default: rwFILTERLINEAR.
         */
    rwRENDERSTATESRCBLEND,
        /**<\ref RwBlendFunction used to modulate the source pixel color
         *  when blending to the frame buffer.
         * Default: rwBLENDSRCALPHA.
         */
    rwRENDERSTATEDESTBLEND,
        /**<\ref RwBlendFunction used to modulate the destination pixel
         *  color in the frame buffer when blending. The resulting pixel
         *  color is given by the formula 
         *  (SRCBLEND * srcColor + DESTBLEND * destColor) for each RGB
         *  component. For a particular platform, not all combinations
         *  of blend function are allowed (see platform specific
         *  restrictions).
         * Default: rwBLENDINVSRCALPHA.
         */
    rwRENDERSTATEVERTEXALPHAENABLE,
        /**<Alpha blending on/off (always enabled on some platforms). 
         *  This is normally used in immediate mode to enable alpha blending 
         *  when vertex colors or texture rasters have transparency. Retained
         *  mode pipelines will usually set this state based on material colors 
         *  and textures.
         * Default: FALSE.
         */
    rwRENDERSTATEBORDERCOLOR,
        /**<Border color for \ref RwTextureAddressMode 
         *  \ref rwTEXTUREADDRESSBORDER. The value should be a packed 
         *  RwUInt32 in a platform specific format. The macro 
         *  RWRGBALONG(r, g, b, a) may be used to construct this using 
         *  8-bit color components.
         * Default: RWRGBALONG(0, 0, 0, 0).
         */
    rwRENDERSTATEFOGENABLE,
        /**<Fogging on/off (all polygons will be fogged).  
         * Default: FALSE.
         */
    rwRENDERSTATEFOGCOLOR,
        /**<Color used for fogging. The value should be a packed RwUInt32 
         *  in a platform specific format. The macro RWRGBALONG(r, g, b, a)
         *  may be used to construct this using 8-bit color components. 
         * Default: RWRGBALONG(0, 0, 0, 0).
         */
    rwRENDERSTATEFOGTYPE,
        /**<\ref RwFogType, the type of fogging to use. 
         * Default: rwFOGTYPELINEAR.
         */
    rwRENDERSTATEFOGDENSITY,
        /**<Fog density for \ref RwFogType of 
         *  \ref rwFOGTYPEEXPONENTIAL or \ref rwFOGTYPEEXPONENTIAL2. 
         *  The value should be a pointer to an RwReal in the 
         *  range 0 to 1.  
         * Default: 1.
         */
    rwRENDERSTATECULLMODE = 20,
        /**<\ref RwCullMode, for selecting front/back face culling, or
         *  no culling.
         * Default: rwCULLMODECULLBACK.
         */
    rwRENDERSTATESTENCILENABLE,
        /**<Stenciling on/off.
         *  <i> Supported on Xbox, D3D8, D3D9, and OpenGL only. </i>
         * Default: FALSE.
         */
    rwRENDERSTATESTENCILFAIL,
        /**<\ref RwStencilOperation used when the stencil test passes.
         *  <i> Supported on Xbox, D3D8, D3D9, and OpenGL only. </i>
         * Default: rwSTENCILOPERATIONKEEP.
         */
    rwRENDERSTATESTENCILZFAIL,
        /**<\ref RwStencilOperation used when the stencil test passes and 
         *  the depth test (z-test) fails. 
         *  <i> Supported on Xbox, D3D8, D3D9, and OpenGL only. </i>
         * Default: rwSTENCILOPERATIONKEEP.
         */
    rwRENDERSTATESTENCILPASS,
        /**<\ref RwStencilOperation used when both the stencil and the depth 
         *  (z) tests pass. 
         *  <i> Supported on Xbox, D3D8, D3D9, and OpenGL only. </i>
         * Default: rwSTENCILOPERATIONKEEP.
         */
    rwRENDERSTATESTENCILFUNCTION,
        /**<\ref RwStencilFunction for the stencil test. 
         *  <i> Supported on Xbox, D3D8, D3D9, and OpenGL only. </i>
         * Default: rwSTENCILFUNCTIONALWAYS.
         */
    rwRENDERSTATESTENCILFUNCTIONREF,
        /**<Integer reference value for the stencil test. 
         *  <i> Supported on Xbox, D3D8, D3D9, and OpenGL only. </i>
         * Default: 0.
         */
    rwRENDERSTATESTENCILFUNCTIONMASK,
        /**<Mask applied to the reference value and each stencil buffer 
         *  entry to determine the significant bits for the stencil test. 
         *  <i> Supported on Xbox, D3D8, D3D9, and OpenGL only. </i>
         * Default: 0xffffffff.
         */
    rwRENDERSTATESTENCILFUNCTIONWRITEMASK,
        /**<Write mask applied to values written into the stencil buffer. 
         *  <i> Supported on Xbox, D3D8, D3D9, and OpenGL only. </i>
         * Default: 0xffffffff.
         */
    rwRENDERSTATEALPHATESTFUNCTION,
        /**<\ref RwAlphaTestFunction for the alpha test. When a pixel fails,
         * neither the frame buffer nor the Z-buffer are updated.
         * Default: rwALPHATESTFUNCTIONGREATER (GameCube, Xbox, D3D8, D3D9
         * and OpenGL). The default PS2 behaviour is to always update the
         * frame buffer and update the Z-buffer only if a greater than or
         * equal test passes.
         */
    rwRENDERSTATEALPHATESTFUNCTIONREF,
        /**<Integer reference value for the alpha test. 
         *  <i> Range is 0 to 255, mapped to the platform's actual range </i>
         * Default: 128 (PS2) 0 (GameCube, Xbox, D3D8, D3D9 and OpenGL).
         */

    rwRENDERSTATEFORCEENUMSIZEINT = RWFORCEENUMSIZEINT
};

#define GS_SCISSOR_1    0x40

#   define MAKE128(RES, MSB, LSB) \
    __asm volatile ( "pcpyld %0, %1, %2" : "=r" (RES) : "r" (MSB), "r" (LSB))

#define _rwDMAPktPtr (*(__uint128_t**)0x66C170)

int (*_rwDMAOpenGIFPkt)(RwUInt32, RwUInt32) = (int (*)(RwUInt32, RwUInt32))0x34E378;
int (*_rwDMAOpenVIFPkt)(RwUInt32, RwUInt32) = (int (*)(RwUInt32, RwUInt32))0x34E878;

#define RWDMA_FIXUP     0x80000000

#define GIF_TAG(NLOOP,EOP,PRE,PRIM,FLG,NREG) \
                ((unsigned long long int)(NLOOP)	<< 0)	| \
                ((unsigned long long int)(EOP)	<< 15)	| \
                ((unsigned long long int)(PRE)	<< 46)	| \
                ((unsigned long long int)(PRIM)	<< 47)	| \
                ((unsigned long long int)(FLG)	<< 58)	| \
                ((unsigned long long int)(NREG)	<< 60);

#define GIF_AD 0x0E

#define ADDTOPKT(_a, _b) { __uint128_t _c; MAKE128(_c, _a, _b); *_rwDMAPktPtr++ = _c; }

unsigned int* current_buf = (unsigned int*)0x66C1B4;

void set_scissor(int x, int width, int y, int height){
    unsigned long long int tmp;

    _rwDMAOpenVIFPkt(RWDMA_FIXUP, 2);

    tmp = GIF_TAG(1,1,0,0,0,1);
    ADDTOPKT(GIF_AD, tmp);

    tmp = (x & 0x7ffl) | ((x+width) << 16) | ((y & 0x7ffl) <<32) | (((long)(y+height)) << 48);
    ADDTOPKT(GS_SCISSOR_1, tmp);
}

void (*CRadar_LimitRadarPoint)(CVector2D*) = (void (*)(CVector2D*))0x0026ABA0;
void (*CRadar_LimitToMap)(float *, float *) = (void (*)(float *, float *))0x0026AC30;
void (*CRadar_TransformRealWorldPointToRadarSpace)(CVector2D*, CVector2D*) = (void (*)(CVector2D*, CVector2D*))0x26AEC0;
void (*RwIm2DRenderPrimitive)(RwInt32, RwIm2DVertex*, RwInt32) = (void (*)(RwInt32, RwIm2DVertex*, RwInt32))0x3669E8;
int (*RwRenderStateSet)(RwInt32, void*) = (int (*)(RwInt32, void*))0x34FD68;
float (*sinf)(float) = (float (*)(float))0x53B178;
float (*cosf)(float) = (float (*)(float))0x53AE48;
float (*atan2f)(float,float) = (float (*)(float,float))0x53B338;

void processGPS(int b) {
    CVector player_coords;
    CNodeAddress dummy;
    short i;
    
    CHud_DrawGangOverlay(b);

    gpsShown = 0;
    unsigned int playa = FindPlayerPed(0);

    if (playa
        && *(unsigned int *)(playa + 1484)
        && (*(unsigned char *)(playa + 0x4A5) & 1)
        && *(unsigned int *)(*(unsigned int *)(playa + 1484) + 0x5D0) != VEHICLE_PLANE
        && *(unsigned int *)(*(unsigned int *)(playa + 1484) + 0x5D0) != VEHICLE_HELI
        && *(unsigned int *)(*(unsigned int *)(playa + 1484) + 0x5D0) != VEHICLE_BMX
        && *FrontEndMenuManager_m_nTargetBlipIndex
        && CRadar_ms_RadarTrace[LOWORD(*FrontEndMenuManager_m_nTargetBlipIndex)].m_nCounter == HIWORD(*FrontEndMenuManager_m_nTargetBlipIndex)
        && CRadar_ms_RadarTrace[LOWORD(*FrontEndMenuManager_m_nTargetBlipIndex)].m_nBlipDisplay)
    {
        CVector destPosn = CRadar_ms_RadarTrace[LOWORD(*FrontEndMenuManager_m_nTargetBlipIndex)].m_vecPos;
        destPosn.z = CWorld_FindGroundZForCoord(destPosn.x, destPosn.y);
        
        short nodesCount = 0;

        FindPlayerCoors(&player_coords, 0);
        
        CPathFind_DoPathSearch(ThePaths, 0, player_coords, dummy, destPosn, resultNodes, &nodesCount, MAX_NODE_POINTS, &gpsDistance,
            999999.0f, 0, 999999.0f, 0, dummy, 0, *(unsigned int *)(*(unsigned int *)(playa + 1484) + 0x5D0) == VEHICLE_BOAT);
        
        if (nodesCount > 0) {
            for (i = 0; i < nodesCount; i++) {
                CVector nodePosn = CPathNode_GetCoors(CPathFind_FindNodePointer(ThePaths, resultNodes[i])); // ThePaths.GetPathNode(resultNodes[i])->GetNodeCoors();
                CVector2D tmpPoint, nodePosn2D;
                nodePosn2D.x = nodePosn.x;
                nodePosn2D.y = nodePosn.y;

                CRadar_TransformRealWorldPointToRadarSpace(&tmpPoint, &nodePosn2D);

                if (!*(unsigned char*)(FrontEndMenuManager + 101))
                    CRadar_TransformRadarPointToScreenSpace(&nodePoints[i], &tmpPoint);
                else {
                    CRadar_LimitRadarPoint(&tmpPoint);
                    CRadar_TransformRadarPointToScreenSpace(&nodePoints[i], &tmpPoint);
                    CRadar_LimitToMap(&nodePoints[i].x, &nodePoints[i].y);
                }
            }

            if (!*(unsigned char*)(FrontEndMenuManager + 101))
            {
                CVector2D posn1, posn2, start, end;

                start.x = -1.0f;
                start.y = -1.0f;

                end.x = 1.0f;
                end.y = 1.0f;

                CRadar_TransformRadarPointToScreenSpace(&posn1, &start);
                CRadar_TransformRadarPointToScreenSpace(&posn2, &end);
                set_scissor((int)(posn1.x + 2.0f), (int)(posn2.x - posn1.x - 2.0f), (int)(posn2.y + 2.0f), (int)(posn1.y - posn2.y - 2.0f));
            }

            RwRenderStateSet(rwRENDERSTATETEXTURERASTER, 0);
            unsigned int vertIndex = 0;

            for (i = 0; i < (nodesCount - 1); i++) {
                CVector2D point[4], shift[2];
                CVector2D dir;
                dir.x = nodePoints[i + 1].x - nodePoints[i].x;
                dir.y = nodePoints[i + 1].y - nodePoints[i].y;
                float angle = atan2f(dir.y, dir.x);
                if (!*(unsigned char*)(FrontEndMenuManager + 101)) {
                    shift[0].x = cosf(angle - 1.5707963f) * GPS_LINE_WIDTH;
                    shift[0].y = sinf(angle - 1.5707963f) * GPS_LINE_WIDTH;
                    shift[1].x = cosf(angle + 1.5707963f) * GPS_LINE_WIDTH;
                    shift[1].y = sinf(angle + 1.5707963f) * GPS_LINE_WIDTH;
                } else {
                    float mp = *(float*)(FrontEndMenuManager + 112) - 140.0f;
                    if (mp < 140.0f)
                        mp = 140.0f;
                    else if (mp > 960.0f)
                        mp = 960.0f;
                    mp = mp / 960.0f + 0.4f;
                    shift[0].x = cosf(angle - 1.5707963f) * GPS_LINE_WIDTH * mp;
                    shift[0].y = sinf(angle - 1.5707963f) * GPS_LINE_WIDTH * mp;
                    shift[1].x = cosf(angle + 1.5707963f) * GPS_LINE_WIDTH * mp;
                    shift[1].y = sinf(angle + 1.5707963f) * GPS_LINE_WIDTH * mp;
                }
                Setup2dVertex(&lineVerts[vertIndex + 0], nodePoints[i].x + shift[0].x, nodePoints[i].y + shift[0].y);
                Setup2dVertex(&lineVerts[vertIndex + 1], nodePoints[i + 1].x + shift[0].x, nodePoints[i + 1].y + shift[0].y);
                Setup2dVertex(&lineVerts[vertIndex + 2], nodePoints[i].x + shift[1].x, nodePoints[i].y + shift[1].y);
                Setup2dVertex(&lineVerts[vertIndex + 3], nodePoints[i + 1].x + shift[1].x, nodePoints[i + 1].y + shift[1].y);

                vertIndex += 4;
            }
        
            RwIm2DRenderPrimitive(rwPRIMTYPETRISTRIP, lineVerts, 4 * (nodesCount - 1));

            
            if (!*(unsigned char*)(FrontEndMenuManager + 101))
            {
                set_scissor(0, 639, 0, 447);
            }
            
            CVector tmp = CPathNode_GetCoors(CPathFind_FindNodePointer(ThePaths, resultNodes[0]));
            gpsDistance += DistanceBetweenPoints(&player_coords, &tmp);
            gpsShown = 1;
        }

    }

}

static CRGBA font_color;
static CRGBA font_shadow;

void drawGPSDistance() {
    CHud_Draw();

    if (gpsShown) {
        CFont_SetOrientation(ALIGN_LEFT);
        CFont_SetColor(&font_color);
        CFont_SetBackground(0, 0);
        CFont_SetWrapx(70.0f);
        CFont_SetScale(0.3111112f, 0.8f);
        CFont_SetFontStyle(FONT_SUBTITLES);
        CFont_SetProportional(1);
        CFont_SetDropShadowPosition(0);
        CFont_SetDropColor(&font_shadow);
        CVector2D radarBottom, tmp;
        tmp.x = -1.0f;
        tmp.y = -1.0f;
        CRadar_TransformRadarPointToScreenSpace(&radarBottom, &tmp);
        char text[16];
        if (gpsDistance > 1000.0f)
            sprintf(text, "%.2fkm", gpsDistance / 1000.0f);
        else
            sprintf(text, "%dm", (int)gpsDistance);
        CFont_PrintString(radarBottom.x + 4.0f, radarBottom.y - 18.0f, text);
    }
}

int _start()
{  
    new_CRGBA(&font_color, 255, 255, 255, 255);
    new_CRGBA(&font_shadow, 0, 0, 0, 0);
    RedirectCall(0x26F2F4, processGPS);
    RedirectCall(0x239090, processGPS);
    RedirectCall(0x2437E8, autoDisableTarget);
    RedirectCall(0x2471E4, drawGPSDistance);
    return 0;
}
