#include <lc_stdint.h>
#include <injector.h>
#include <erl.h>

char * erl_id = "vcamera";
char * erl_dependancies[] = {
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

uint32_t* TheCamera = (uint32_t*)0x6FE530;

void (*Camera_FollowPed)(uint32_t this, CVector *a2, float a3, float a4, float a5, char a6) = (void (*)(uint32_t, CVector *, int, int, int, char))0x207ED0;

void (*Normalise)(CVector* this) = (void (*)(CVector *))0x110390;

void (*CrossProduct)(CVector *out, CVector *a, CVector *b) = (void (*)(CVector *, CVector *, CVector *))0x110060;

void (*FindPlayerCoors)(CVector *outPoint, int playerIndex) = (void (*)(CVector *, int))0x263C90;

float dotProduct(CVector* v1, CVector* v2) {
    return v1->x*v2->x+v1->y*v2->y+v1->x*v2->y;
}

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

uint32_t (*FindPlayerPed)(int playerIndex) = (uint32_t (*)(int))0x264040;

void VCamera(uint32_t this, CVector *a2, float a3, float a4, float a5, char a6) {
    CVector out, obj_space;
    uint32_t playa = FindPlayerPed(-1);

    out.x = 0.3f;
    out.y = 0.0f;
    out.z = 0.0f;

    obj_space = TransformFromObjectSpace(playa, out);
    Camera_FollowPed(this, &obj_space, a3, a4, a5, a6);
}

int _start()
{  
    RedirectCall(0x202A10, VCamera);
    return 0;
}
