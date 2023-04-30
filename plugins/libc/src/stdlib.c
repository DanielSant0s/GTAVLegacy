#include <lc_stdlib.h>

void* (*malloc)(uint32_t)  = (void* (*)(uint32_t))0x001005E0;
void (*free)(void*)  = (void (*)(void*))0x00100780;
