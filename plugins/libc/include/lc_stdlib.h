#include <lc_stdint.h>

void* (*malloc)(uint32_t);
void (*free)(void*);
