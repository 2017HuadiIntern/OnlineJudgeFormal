#include<stdio.h>
int main(int arg_count, char **args)
{
   printf("%s",*(args+1));
	return 0;
}
