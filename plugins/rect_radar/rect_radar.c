#include <lc_stdint.h>
#include <injector.h>
#include <erl.h>

char * erl_id = "rect_radar";
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

int sub_10001600(float *a1, float *a2, float *a3, float *a4)
{
    int result; // al
    float v5; // st6
    float v6; // st6
    float v7; // st6
    float v8; // st5
    float v9; // st6
    float v10; // st5
    float v11; // st3
    float v12; // st4
    float v13; // st6
    float v14; // st7
    int v15; // bl
    float v16; // st5
    float v17; // st4
    float v18; // st5
    float v19; // st3
    float v20; // st7
    float v21; // st5
    float v22; // st6
    float v23; // st5
    float v24; // rt0
    float v25; // [esp+4h] [ebp-1Ch]
    float v26; // [esp+8h] [ebp-18h]
    float v27; // [esp+Ch] [ebp-14h]
    float v28; // [esp+Ch] [ebp-14h]
    float v29; // [esp+Ch] [ebp-14h]
    float v30; // [esp+10h] [ebp-10h]
    float v31; // [esp+10h] [ebp-10h]
    float v32; // [esp+14h] [ebp-Ch]
    float v33; // [esp+14h] [ebp-Ch]
    float v34; // [esp+14h] [ebp-Ch]
    float v35; // [esp+18h] [ebp-8h]
    float v36; // [esp+18h] [ebp-8h]
    float v37; // [esp+18h] [ebp-8h]
    float v38; // [esp+18h] [ebp-8h]
    float v39; // [esp+18h] [ebp-8h]
    float v40; // [esp+18h] [ebp-8h]
    float v41; // [esp+18h] [ebp-8h]
    float v42; // [esp+18h] [ebp-8h]
    float v43; // [esp+1Ch] [ebp-4h]
    float v44; // [esp+1Ch] [ebp-4h]
    float v45; // [esp+1Ch] [ebp-4h]
    float v46; // [esp+1Ch] [ebp-4h]

    if ( 0.0f == a2[1] )
    {
        a1[1] = 0.0f;
        if ( 0.0f == *a2 )
        {
            *a1 = 0.0f;
            result = 0;
            *a3 = 0.0f;
            *a4 = 0.0f;
            return result;
        }
        if ( *a2 <= 0.0f )
        {
            v7 = -1.0f;
            *a1 = -1.0f;
            v6 = v7 - *a2;
        }
        else
        {
            v5 = 1.0f;
            *a1 = 1.0f;
            v6 = *a2 - v5;
        }
        v27 = v6;
        v35 = fabsf(v27);
        *a3 = v35;
        v36 = fabsf(*a2);
        *a4 = v36;
        return v27 >= 0.0f;
    }
    if ( a2[1] <= 0.0f )
    {
        v26 = -1.0f;
        v9 = -1.0f;
        v8 = -1.0f - a2[1];
    }
    else
    {
        v26 = 1.0f;
        v8 = a2[1] - 1.0f;
        v9 = 1.0f;
    }
    v30 = v8;
    if ( 0.0f == *a2 )
    {
        *a1 = 0.0f;
        a1[1] = v9;
        v37 = fabsf(v30);
        *a3 = v37;
        v38 = fabsf(a2[1]);
        *a4 = v38;
        if ( v30 < 0.0f )
            return 0;
        result = 1;
    }
    else
    {
        v10 = v30;
        v43 = 1.0f * v30;
        v11 = v43;
        v44 = 1.0f + v43;
        v39 = fabsf(*a2);
        if ( v44 <= (float)v39 )
        {
            if ( *a2 <= 0.0f )
            {
                v25 = -1.0f;
                v18 = -1.0f;
                v17 = -1.0f - *a2;
            }
            else
            {
                v25 = 1.0f;
                v17 = *a2 - 1.0f;
                v18 = 1.0f;
            }
            v29 = v17;
            v45 = 1.0f * v29;
            v19 = v45;
            v46 = 1.0f + v45;
            v32 = fabsf(a2[1]);
            if ( v46 <= (float)v32 )
            {
                *a1 = v25;
                a1[1] = v26;
                v21 = v30;
                v20 = v29;
            }
            else
            {
                v20 = v29;
                v31 = a2[1] / v46 * v19;
                *a1 = v18;
                v21 = v31;
                a1[1] = a2[1] - v31;
            }
            v22 = v21;
            if ( v20 < 0.0f )
            {
                v23 = -1.0f;
                v15 = 0;
            }
            else
            {
                v23 = v39;
                v15 = 1;
            }
            v42 = v23;
            v41 = v20 / v42;
            v24 = v22;
            v13 = v20;
            v14 = v24;
        }
        else
        {
            v28 = *a2 / v44 * v11;
            *a1 = *a2 - v28;
            v12 = v9;
            v13 = v28;
            a1[1] = v12;
            v14 = v30;
            if ( v10 < 0.0f )
            {
                v15 = 0;
                v16 = v10 / -1.0f;
            }
            else
            {
                v15 = 1;
                v40 = fabsf(a2[1]);
                v16 = v10 / v40;
            }
            v41 = v16;
        }
        v33 = v14 * v14 + v13 * v13;
        v34 = sqrtf(v33);
        result = v15;
        *a3 = v34;
        *a4 = v34 * v41;
    }
    return result;
}

unsigned int FrontEndMenuManager = 0x6FF940;

float hooked_limit_radar_point(float *a1)
{
    float result; // st7
    float v2; // st7
    int v3; // ecx
    float v4; // [esp+10h] [ebp-10h] BYREF
    float v5; // [esp+14h] [ebp-Ch] BYREF
    int v6[2]; // [esp+18h] [ebp-8h] BYREF

    if ( *(unsigned char*)(FrontEndMenuManager + 101) )
    {
        v5 = a1[1] * a1[1] + *a1 * *a1;
        v5 = sqrtf(v5);
        result = v5;
    } else {
        if ( sub_10001600((float *)v6, a1, &v4, &v5) )
        {
            v2 = v4 + 1.0f;
            v3 = v6[1];
            *a1 = *(float *)v6;
            *((uint32_t *)a1 + 1) = v3;
            v4 = v2;
        }
        else
        {
            v4 = (v5 - v4) / v5;
        }
        result = v4;
    }
    return result;
}

int _start()
{
    RedirectCall(0x238974, hooked_limit_radar_point);
    RedirectCall(0x23BE14, hooked_limit_radar_point);
    RedirectCall(0x23BECC, hooked_limit_radar_point);
    RedirectCall(0x23BF18, hooked_limit_radar_point);
    RedirectCall(0x23BF80, hooked_limit_radar_point);
    RedirectCall(0x23BFE4, hooked_limit_radar_point);
    RedirectCall(0x23C048, hooked_limit_radar_point);
    RedirectCall(0x23C134, hooked_limit_radar_point);
    RedirectCall(0x23C400, hooked_limit_radar_point);
    RedirectCall(0x23C44C, hooked_limit_radar_point);
    RedirectCall(0x23C5B0, hooked_limit_radar_point);
    RedirectCall(0x23C5FC, hooked_limit_radar_point);
    RedirectCall(0x23C76C, hooked_limit_radar_point);
    RedirectCall(0x23C7B4, hooked_limit_radar_point);
    RedirectCall(0x23C914, hooked_limit_radar_point);
    RedirectCall(0x23C95C, hooked_limit_radar_point);
    RedirectCall(0x268164, hooked_limit_radar_point);
    RedirectCall(0x2681C4, hooked_limit_radar_point);
    RedirectCall(0x268488, hooked_limit_radar_point);
    RedirectCall(0x268534, hooked_limit_radar_point);
    RedirectCall(0x268818, hooked_limit_radar_point);
    RedirectCall(0x268FB8, hooked_limit_radar_point);
    RedirectCall(0x269118, hooked_limit_radar_point);
    RedirectCall(0x2696D0, hooked_limit_radar_point);
    RedirectCall(0x26A5D0, hooked_limit_radar_point);

    *(uint32_t*)(0x26F0AC) = 0;

    return 0;
}
