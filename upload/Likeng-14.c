#include<stdio.h>
/* the tail flag of a string */
const char _string_tail = '\0';
/* ASCII code of '0' */
const char _ascii_code_0 = '0';
unsigned int getIntegerFromChar(char *arg)
{
	int index = 0;
	unsigned int result = 0;
	while(*(arg + index) != _string_tail)
	{
		result *= 10;
		result += (*(arg + index) - _ascii_code_0);
		++index;
	}
	return result;
}
int main(int arg_count, char **args)
{
    char * a_str = *(args+1);
    char * b_str = *(args+2);
    unsigned int a = getIntegerFromChar(a_str);
    unsigned int b = getIntegerFromChar(b_str);
    printf("%d",a*b);
	return 0;
}
