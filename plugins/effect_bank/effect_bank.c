#include <lc_stdint.h>
#include <injector.h>
#include <erl.h>

char * erl_id = "effect_bank";
char * erl_dependancies[] = {
    "injector",
    //"rwcore",
    //"cfont",
    0
};


typedef struct {
    uint8_t r;
    uint8_t g;
    uint8_t b;
    uint8_t a;
} RwRGBA;

uint16_t* CHud_m_ItemToFlash = (uint16_t*)0x66BBFC;


uint8_t* MaxHealth = (uint8_t*)0x70974B;
uint32_t* CWorld_PlayerInFocus = (uint32_t*)0x7095D0;
uint32_t* CTimer_m_FrameCounter = (uint32_t*)0x66BA38;

RwRGBA (*CRGBA_CRGBA)(RwRGBA*, unsigned char, unsigned char, unsigned char, unsigned char) = (RwRGBA (*)(RwRGBA*, unsigned char, unsigned char, unsigned char, unsigned char))0x02A53C0;

float (*CStats_GetFatAndMuscleModifier)(unsigned int) = (float (*)(unsigned int))0x2D8C20;
void (*CSprite2d_DrawBarChart)(float, float, unsigned short, unsigned char, float, signed char, unsigned char, unsigned char, RwRGBA*, RwRGBA*) = (void (*)(float, float, unsigned short, unsigned char, float, signed char, unsigned char, unsigned char, RwRGBA*, RwRGBA*))0x2B0B00;

static int (*printf)(const char *, ...) = (int (*)(const char *, ...))0x0054F7D0;


void CHud_PrintHealthForPlayer(int playerID, float posX, float posY)
{
    float width;
    float fPercentage;
    float fPercentagea;
    RwRGBA v10;
    RwRGBA color;

    if (*CHud_m_ItemToFlash != 4)
    {
        fPercentage = 100.0f * 109.0f;
        width = fPercentage / CStats_GetFatAndMuscleModifier(10);
        fPercentagea = (*(float*)(CWorld_PlayerInFocus[111 * playerID] + 1408));
        CRGBA_CRGBA(&v10, 0, 0, 0, 255);

        if (*(float*)(CWorld_PlayerInFocus[111 * playerID] + 1408) >= 30.0f) {
            CRGBA_CRGBA(&color, 0x3e, 0x9b, 0x01, 255);
        } else {
            if ((*CTimer_m_FrameCounter & 8) != 0) {
                CRGBA_CRGBA(&color, 255, 0, 0, 255);
            } else {
                CRGBA_CRGBA(&color, 128, 0, 0, 255);
            }
            
        }

        CSprite2d_DrawBarChart(40.0f, 420.0f, width, 9.0f, fPercentagea, 0, 0, 1, &color, &v10);
    }
}


typedef struct {
    float x;
    float y;
    float z;

} CVector;

void (*Camera_FollowCar)(uint32_t this, CVector *a2, float a3, float a4, float a5, char a6) = (void (*)(uint32_t, CVector *, int, int, int, char))0x209C90;
void (*sub_25F980)(CVector *, uint32_t, CVector*) = (void (*)(CVector *, uint32_t, CVector*))0x25F980;

void VCarCamera(uint32_t this, CVector *a2, float a3, float a4, float a5, char a6) {
    CVector out, obj_space, ret;
    out.x = 0.0f;
    out.y = 0.0f;
    out.z = -0.3f;

    sub_25F980(&ret, a2, &out);
    Camera_FollowCar(this, &ret, a3, a4, a5, a6);
}


int _start()
{
    *(uint32_t*)0x5157AC = 0; // Disable motion blur
    *(uint32_t*)0x5157C0 = 0; // Disable motion blur

    *(uint32_t*)0x14EB50 = 0; // No Wheel Turn Back
    *(uint32_t*)0x14ECF0 = 0; // No Wheel Turn Back
    *(uint32_t*)0x14ED84 = 0; // No Wheel Turn Back

    *(uint32_t*)0x262804 = 0; // No flip explosions - player
    *(uint32_t*)0x146790 = 0; // No flip explosions - ped

    *(uint8_t*)0x6FF98F = 1; // Widescreen by default

    RedirectCall(0x2AB4B0, CHud_PrintHealthForPlayer);
    RedirectCall(0x2AB4F8, CHud_PrintHealthForPlayer);
    
    RedirectCall(0x2029EC, VCarCamera);
    RedirectCall(0x210FE8, VCarCamera);
    RedirectCall(0x211080, VCarCamera);
    RedirectCall(0x59BD40, VCarCamera);

    return 0;
}
