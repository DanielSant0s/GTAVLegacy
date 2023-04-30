#include <lc_stdio.h>

int (*printf)(const char *, ...) = (int (*)(const char *, ...))0x54F7D0;
int (*sprintf)(char *str, const char *format, ...) = (int (*)(char *, const char *, ...))0x00550F10;
