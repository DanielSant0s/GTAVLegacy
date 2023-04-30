#include <injector.h>

void RedirectCall(unsigned int* call_addr, unsigned int addr){
    *call_addr = 0x0C000000+(addr/4);
}

void writeMemory(unsigned int* Address, unsigned char size, unsigned int value)
{
	unsigned int align_diff;
	unsigned int aligned_addr = 0;
	unsigned int temp[2];
	unsigned char uint8_ts[8];

	align_diff = (unsigned int)Address % 4;

	switch(size){
	default:
		if(align_diff > 0){
			aligned_addr = (unsigned int)Address;
			aligned_addr = ((unsigned int)aligned_addr - align_diff);
			temp[0] = *(unsigned int*)(aligned_addr);

			uint8_ts[0] = temp[0] & 0xFF; uint8_ts[1] = (temp[0] >> 8) & 0xFF; uint8_ts[2] = (temp[0] >> 16) & 0xFF; uint8_ts[3] = (temp[0] >> 24) & 0xFF;

			uint8_ts[align_diff] = (unsigned char)value;

			*(unsigned int*)aligned_addr =  uint8_ts[0] | (uint8_ts[1] << 8) | (uint8_ts[2] << 16) | (uint8_ts[3] << 24);
		} else {
			*(unsigned char*)Address = (unsigned char)value;
		}

		break;

	case 2:
		if(align_diff > 0){
			aligned_addr = (unsigned int)Address;
			aligned_addr = ((unsigned int)aligned_addr - align_diff);
			temp[0] = *(unsigned int*)(aligned_addr);
			temp[1] = *(unsigned int*)(aligned_addr+4);

			uint8_ts[0] = temp[0] & 0xFF; 
            uint8_ts[1] = (temp[0] >> 8) & 0xFF; 
            uint8_ts[2] = (temp[0] >> 16) & 0xFF; 
            uint8_ts[3] = (temp[0] >> 24) & 0xFF;

			if(align_diff > 2) {
                uint8_ts[4] = temp[1] & 0xFF; 
                uint8_ts[5] = (temp[1] >> 8) & 0xFF; 
                uint8_ts[6] = (temp[2] >> 16) & 0xFF; 
                uint8_ts[7] = (temp[1] >> 24) & 0xFF;
            }

			uint8_ts[align_diff] = (unsigned short)value & 0xFF; 
            uint8_ts[align_diff+1] = ((unsigned short)value >> 8) & 0xFF;

			*(unsigned int*)aligned_addr =  uint8_ts[0] | (uint8_ts[1] << 8) | (uint8_ts[2] << 16) | (uint8_ts[3] << 24);
			if(align_diff > 2) *(unsigned int*)(aligned_addr+4) =  uint8_ts[4] | (uint8_ts[5] << 8) | (uint8_ts[6] << 16) | (uint8_ts[7] << 24);

		} else {
			*(unsigned short*)Address = (unsigned short)value;
		}
		
		break;

	case 4:
		*Address = value;
		break;
	}
}

unsigned int readMemory(unsigned int* Address, unsigned char size)
{
	unsigned int align_diff;
	unsigned int aligned_addr = 0;
    unsigned int result = 0;

	align_diff = (unsigned int)Address % 4;

	switch(size){
	case 1:
		if(align_diff > 0){
			aligned_addr = ((unsigned int)aligned_addr - align_diff);
			result = (unsigned char)(*(unsigned int*)(aligned_addr) >> (8*align_diff));
		} else {
			result = *(unsigned char*)Address;
		}
		break;
	case 2:
		if(align_diff > 0){
			aligned_addr = ((unsigned int)aligned_addr - align_diff);
			result = (unsigned short)(*(unsigned int*)(aligned_addr) >> (8*align_diff));
			result += (unsigned short)(*(unsigned int*)(aligned_addr+4) << (8*(4-align_diff)));
		} else {
			result = *(unsigned short*)Address;
		}

		break;
	case 4:
		result = *Address;
		break;
	}

	return result;
}
