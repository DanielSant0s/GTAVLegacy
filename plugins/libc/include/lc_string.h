#include <lc_stdint.h>

void* (*memset)(void *, int, uint32_t);
void* (*memcpy)(void *, const void *, uint32_t);
int (*memcmp)(const void *, const void *, uint32_t);
uint32_t (*strlen)(const char *);
int (*strcmp)(const char *, const char *);
char* (*strcpy)(char *, const char *);
char* (*strcat)(char *, const char *);
char* (*strncpy)(char *, const char *, uint32_t);
