

typedef long unsigned int size_t;

#define NULL ((char *)0)

#define SEEK_SET 0
#define SEEK_CUR 1
#define SEEK_END 2

typedef int FILE;

extern void (*FlushCache)(int);

//extern struct symbol_t * (*find_symbol)(const char *);

extern FILE* (*rw_open)(const char*, const char*);
extern size_t (*rw_read)(FILE *, void *, size_t);
extern int (*rw_seek)(FILE *, long int, int);
extern int (*rw_close)(FILE *);
extern int (*printf)(const char *, ...);

extern void* (*malloc)(size_t);
extern void (*free)(void*);
extern void* (*memset)(void *, int, size_t);
extern void* (*memcpy)(void *, const void *, size_t);
extern int (*memcmp)(const void *, const void *, size_t);

extern size_t (*strlen)(const char *);
extern int (*strcmp)(const char *, const char *);
extern char* (*strcpy)(char *, const char *);
extern char* (*strcat)(char *, const char *);
