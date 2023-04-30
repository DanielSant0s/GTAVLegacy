#include <lc_stdint.h>
#include <injector.h>
#include <erl.h>

char * erl_id = "draw_rotate";
char * erl_dependancies[] = {
    "injector",
    //"rwcore",
    //"cfont",
    0
};

typedef struct
{
  uint8_t red;
  uint8_t green;
  uint8_t blue;
  uint8_t alpha;
} RwRGBA;

void (*CSprite2d_Draw)(uint32_t, float, float, float, float, float, float, float, float, RwRGBA*) = (void (*)(uint32_t, float, float, float, float, float, float, float, float, RwRGBA*))0x2B09D0;

void hooked_draw_rotated(uint32_t texture, float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4, RwRGBA* color)
{
    x1 *= 0.85f;
    x2 *= 0.85f;
    x3 *= 0.85f;
    x4 *= 0.85f;

    x1 += 48.0f;
    x2 += 48.0f;
    x3 += 48.0f;
    x4 += 48.0f;

    // desenhar o retângulo com as coordenadas corrigidas
    CSprite2d_Draw(texture, x1, y1, x2, y2, x3, y3, x4, y4, color);
}

int _start()
{
    RedirectCall(0x1F8A58, hooked_draw_rotated);
    return 0;
}
