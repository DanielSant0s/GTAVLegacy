// Taken from the debug ps2_screenshot source

#define GIF_AD    0x0e

#define GIFTAG(NLOOP,EOP,PRE,PRIM,FLG,NREG) \
    ((uint64_t)(NLOOP) << 0)   | \
    ((uint64_t)(EOP)   << 15)  | \
    ((uint64_t)(PRE)   << 46)  | \
    ((uint64_t)(PRIM)  << 47)  | \
    ((uint64_t)(FLG)   << 58)  | \
    ((uint64_t)(NREG)  << 60)

#define GSBITBLTBUF_SET(sbp, sbw, spsm, dbp, dbw, dpsm) \
  ((uint64_t)(sbp)         | ((uint64_t)(sbw) << 16) | \
  ((uint64_t)(spsm) << 24) | ((uint64_t)(dbp) << 32) | \
  ((uint64_t)(dbw) << 48)  | ((uint64_t)(dpsm) << 56))

#define GSTRXREG_SET(rrw, rrh) \
  ((uint64_t)(rrw) | ((uint64_t)(rrh) << 32))

#define GSTRXPOS_SET(ssax, ssay, dsax, dsay, dir) \
  ((uint64_t)(ssax)        | ((uint64_t)(ssay) << 16) | \
  ((uint64_t)(dsax) << 32) | ((uint64_t)(dsay) << 48) | \
  ((uint64_t)(dir) << 59))

#define GSTRXDIR_SET(xdr) ((uint64_t)(xdr))

#define GSBITBLTBUF         0x50
#define GSFINISH            0x61
#define GSTRXPOS            0x51
#define GSTRXREG            0x52
#define GSTRXDIR            0x53

#define GSPSMCT32           0
#define GSPSMCT24           1
#define GSPSMCT16           2

#define D1_CHCR             ((volatile unsigned int *)(0x10009000))
#define D1_MADR             ((volatile unsigned int *)(0x10009010))
#define D1_QWC              ((volatile unsigned int *)(0x10009020))
#define D1_TADR             ((volatile unsigned int *)(0x10009030))
#define D1_ASR0             ((volatile unsigned int *)(0x10009040))
#define D1_ASR1             ((volatile unsigned int *)(0x10009050))

#define CSR_FINISH          (1 << 1)
#define GS_CSR              ((volatile uint64_t *)(0x12001000))
#define GS_BUSDIR           ((volatile uint64_t *)(0x12001040))

#define VIF1_STAT           ((volatile uint32_t *)(0x10003c00))
#define VIF1_STAT_FDR       (1<< 23)
#define VIF1_MSKPATH3(mask) ((uint32_t)(mask) | ((uint32_t)0x06 << 24))
#define VIF1_NOP            0
#define VIF1_FLUSHA         (((uint32_t)0x13 << 24))
#define VIF1_DIRECT(count)  ((uint32_t)(count) | ((uint32_t)(0x50) << 24))
#define VIF1_FIFO           ((volatile u128 *)(0x10005000))
