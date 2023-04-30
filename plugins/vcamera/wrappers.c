#include "wrappers.h"

//struct symbol_t * (*find_symbol)(const char *) = (struct symbol_t * (*)(const char *))0x35E160;

void (*FlushCache)(int) = (void (*)(int))0x0053BA20;

FILE* (*rw_open)(const char*, const char*) = (FILE* (*)(const char*, const char*))0x00233210;
size_t (*rw_read)(FILE *, void *, size_t) = (size_t (*)(FILE *, void *, size_t))0x00233250;
int (*rw_seek)(FILE *, long int, int) = (int (*)(FILE *, long int, int))0x002332B0;
int (*rw_close)(FILE *) = (int (*)(FILE *))0x00233370;

int (*printf)(const char *, ...) = (int (*)(const char *, ...))0x0054F7D0;

void* (*malloc)(size_t) = (void* (*)(size_t))0x00337010;
void (*free)(void*) = (void (*)(void*))0x0054D838;
void* (*memset)(void *, int, size_t) = (void* (*)(void *, int, size_t))0x0054E568;
void* (*memcpy)(void *, const void *, size_t) = (void* (*)(void *, const void *, size_t))0x0054E3B0;
int (*memcmp)(const void *, const void *, size_t) = (int (*)(const void *, const void *, size_t))0x0054E318;

size_t (*strlen)(const char *) = (size_t (*)(const char *))0x005517B8;
int (*strcmp)(const char *, const char *) = (int (*)(const char *, const char *))0x00551558;
char* (*strcpy)(char *, const char *) = (char* (*)(char *, const char *))0x005516A0;
char* (*strcat)(char *, const char *) = (char* (*)(char *, const char *))0x00551298;

