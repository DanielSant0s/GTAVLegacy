#include <lc_string.h>
#include <injector.h>
#include <erl.h>

char * erl_id = "v_aim";
char * erl_dependancies[] = {
    "libc",
    "injector",
    //"rwcore",
    //"cfont",
    0
};

typedef struct {
    float x;
    float y;
    float z;

} CVector;

enum eWeaponType
{
	WEAPON_UNARMED = 0x0,
	WEAPON_BRASSKNUCKLE = 0x1,
	WEAPON_GOLFCLUB = 0x2,
	WEAPON_NIGHTSTICK = 0x3,
	WEAPON_KNIFE = 0x4,
	WEAPON_BASEBALLBAT = 0x5,
	WEAPON_SHOVEL = 0x6,
	WEAPON_POOLCUE = 0x7,
	WEAPON_KATANA = 0x8,
	WEAPON_CHAINSAW = 0x9,
	WEAPON_DILDO1 = 0xA,
	WEAPON_DILDO2 = 0xB,
	WEAPON_VIBE1 = 0xC,
	WEAPON_VIBE2 = 0xD,
	WEAPON_FLOWERS = 0xE,
	WEAPON_CANE = 0xF,
	WEAPON_GRENADE = 0x10,
	WEAPON_TEARGAS = 0x11,
	WEAPON_MOLOTOV = 0x12,
	WEAPON_ROCKET = 0x13,
	WEAPON_ROCKET_HS = 0x14,
	WEAPON_FREEFALL_BOMB = 0x15,
	WEAPON_PISTOL = 0x16,
	WEAPON_PISTOL_SILENCED = 0x17,
	WEAPON_DESERT_EAGLE = 0x18,
	WEAPON_SHOTGUN = 0x19,
	WEAPON_SAWNOFF = 0x1A,
	WEAPON_SPAS12 = 0x1B,
	WEAPON_MICRO_UZI = 0x1C,
	WEAPON_MP5 = 0x1D,
	WEAPON_AK47 = 0x1E,
	WEAPON_M4 = 0x1F,
	WEAPON_TEC9 = 0x20,
	WEAPON_COUNTRYRIFLE = 0x21,
	WEAPON_SNIPERRIFLE = 0x22,
	WEAPON_RLAUNCHER = 0x23,
	WEAPON_RLAUNCHER_HS = 0x24,
	WEAPON_FTHROWER = 0x25,
	WEAPON_MINIGUN = 0x26,
	WEAPON_SATCHEL_CHARGE = 0x27,
	WEAPON_DETONATOR = 0x28,
	WEAPON_SPRAYCAN = 0x29,
	WEAPON_EXTINGUISHER = 0x2A,
	WEAPON_CAMERA = 0x2B,
	WEAPON_NIGHTVISION = 0x2C,
	WEAPON_INFRARED = 0x2D,
	WEAPON_PARACHUTE = 0x2E,
	WEAPON_UNUSED = 0x2F,
	WEAPON_ARMOUR = 0x30,
	WEAPON_FLARE = 0x3A
};

uint32_t* TheCamera = (uint32_t*)0x6FE530;

uint32_t (*FindPlayerPed)(int playerIndex) = (uint32_t (*)(int))0x264040;

enum eWeaponAimOffset {
    AIM_OFFSET_WEAPON_DEFAULT,
    AIM_OFFSET_WEAPON_COLT45,
    AIM_OFFSET_WEAPON_SILENCED,
    AIM_OFFSET_WEAPON_DESERTEAGLE,
    AIM_OFFSET_WEAPON_CHROMEGUN,
    AIM_OFFSET_WEAPON_SAWNOFF,
    AIM_OFFSET_WEAPON_SHOTGSPA,
    AIM_OFFSET_WEAPON_MICROUZI,
    AIM_OFFSET_WEAPON_MP5,
    AIM_OFFSET_WEAPON_TEC9,
    AIM_OFFSET_WEAPON_AK47,
    AIM_OFFSET_WEAPON_M4,
    AIM_OFFSET_WEAPON_CUNTGUN,
    AIM_OFFSET_WEAPON_ROCKETLA,
    AIM_OFFSET_WEAPON_HEATSEEK,
    AIM_OFFSET_WEAPON_FLAME
};

typedef struct {
    float f0, f1, f2, f3, f4, f5, f6;
} tAimingCamData;

static tAimingCamData gData[4];
static CVector gOffsets[16];

void (*Process_AimWeapon)(uint32_t this, CVector *a2, float a3, float a4, float a5) = (void (*)(uint32_t, CVector *, float, float, float))0x204CE0;

void (*CMatrix_Attach)(CVector *, uint32_t, CVector*) = (void (*)(CVector *, uint32_t, CVector*))0x110310;
void (*sub_25F980)(CVector *, uint32_t, CVector*) = (void (*)(CVector *, uint32_t, CVector*))0x25F980;

CVector TransformFromObjectSpace(uint32_t entity, CVector offset) {
    CVector ret;

    if ( *(uint32_t *)(entity + 20) ) {
        CMatrix_Attach(&ret, *(uint32_t *)(entity + 20), &offset);
    } else {
        sub_25F980(&ret, (float *)(entity + 4), &offset);
    }

    return ret;
}

static void MyProcess_AimWeapon(uint32_t cam, CVector *vec, float arg3, float arg4, float arg5) {
    uint32_t playa = FindPlayerPed(-1);
    uint8_t active_weapon;
    CVector obj_space;

    if (playa && !(*(uint8_t *)(playa + 0x4A5) & 1)) {
        int aimTypeId = -1;

        active_weapon = *(uint8_t *)(playa + 0x758);
        switch (*(uint32_t *)(playa + 0x1C * active_weapon + 0x5E0)) {
            case WEAPON_PISTOL:
                aimTypeId = AIM_OFFSET_WEAPON_COLT45;
                break;
            case WEAPON_PISTOL_SILENCED:
                aimTypeId = AIM_OFFSET_WEAPON_SILENCED;
                break;
            case WEAPON_DESERT_EAGLE:
                aimTypeId = AIM_OFFSET_WEAPON_DESERTEAGLE;
                break;
            case WEAPON_SHOTGUN:
                aimTypeId = AIM_OFFSET_WEAPON_CHROMEGUN;
                break;
            case WEAPON_SAWNOFF:
                aimTypeId = AIM_OFFSET_WEAPON_SAWNOFF;
                break;
            case WEAPON_SPAS12:
                aimTypeId = AIM_OFFSET_WEAPON_SHOTGSPA;
                break;
            case WEAPON_MICRO_UZI:
                aimTypeId = AIM_OFFSET_WEAPON_MICROUZI;
                break;
            case WEAPON_MP5:
                aimTypeId = AIM_OFFSET_WEAPON_MP5;
                break;
            case WEAPON_TEC9:
                aimTypeId = AIM_OFFSET_WEAPON_TEC9;
                break;
            case WEAPON_AK47:
                aimTypeId = AIM_OFFSET_WEAPON_AK47;
                break;
            case WEAPON_M4:
                aimTypeId = AIM_OFFSET_WEAPON_M4;
                break;
            case WEAPON_COUNTRYRIFLE:
                aimTypeId = AIM_OFFSET_WEAPON_CUNTGUN;
                break;
            case WEAPON_ROCKET:
                aimTypeId = AIM_OFFSET_WEAPON_ROCKETLA;
                break;
            case WEAPON_ROCKET_HS:
                aimTypeId = AIM_OFFSET_WEAPON_HEATSEEK;
                break;
            case WEAPON_FTHROWER:
                aimTypeId = AIM_OFFSET_WEAPON_FLAME;
                break;
        }
        if (aimTypeId != -1) {
            CVector offset = gOffsets[aimTypeId];
            obj_space = TransformFromObjectSpace(playa, offset);
            Process_AimWeapon(cam, &obj_space, arg3, arg4, arg5);
        }
        else
            Process_AimWeapon(cam, vec, arg3, arg4, arg5);
    }
    else
        Process_AimWeapon(cam, vec, arg3, arg4, arg5);
}

int _start()
{  
    *(float *)0x66521C = 20.0f; // AIMWEAPON_RIFLE1_ZOOM
    *(float *)0x665218 = 20.0f; // AIMWEAPON_RIFLE2_ZOOM
    *(uint32_t *)0x204E44 = 0x3C0241a0; // AIMWEAPON_DEFAULT_ZOOM = 20.0f
    *(float *)0x665214 = 0.17453f; // AIMWEAPON_DRIVE_CLOSE_ENOUGH
    *(float *)0x665210 = 0.25f; // AIMWEAPON_DRIVE_SENS_MULT
    *(float *)0x66520C = 0.1f; // AIMWEAPON_FREETARGET_SENS
    *(float *)0x665204 = 0.007f; // AIMWEAPON_STICK_SENS
/*
    // GUN_DATA
    gData[0].f0 = 0.6f;
    gData[0].f1 = 0.5f;
    gData[0].f2 = 1.0f;
    gData[0].f3 = -0.12f;
    gData[0].f4 = 0.02f;
    gData[0].f5 = 0.7854f;
    gData[0].f6 = 1.5533f;

    // BIKE_DATA
    gData[1].f0 = 3.5f;
    gData[1].f1 = 0.7f;
    gData[1].f2 = 1.0f;
    gData[1].f3 = -0.16f;
    gData[1].f4 = 0.2f;
    gData[1].f5 = 0.61087f;
    gData[1].f6 = 1.2217f;

    // VEHICLE_DATA
    gData[2].f0 = 6.0f;
    gData[2].f1 = 0.7f;
    gData[2].f2 = 1.0f;
    gData[2].f3 = -0.16f;
    gData[2].f4 = 0.4f;
    gData[2].f5 = 0.61087f;
    gData[2].f6 = 1.2217f;

    // MELEE_DATA
    gData[3].f0 = 2.5f;
    gData[3].f1 = 0.7f;
    gData[3].f2 = 1.0f;
    gData[3].f3 = -0.12f;
    gData[3].f4 = 0.15f;
    gData[3].f5 = 0.7854f;
    gData[3].f6 = 1.79412f;

    memcpy((void *)0x665220, gData, 112);
*/
    gOffsets[0].x = 0.0f;
    gOffsets[0].y = 0.0f;
    gOffsets[0].z = 0.0f;

    gOffsets[1].x = 0.22f;
    gOffsets[1].y = 0.0f;
    gOffsets[1].z = 0.0f;

    gOffsets[2].x = 0.22f;
    gOffsets[2].y = 0.1f;
    gOffsets[2].z = 0.0f;

    RedirectCall(0x202AB8, MyProcess_AimWeapon);
    return 0;
}
