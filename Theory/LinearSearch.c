#include <stdio.h>
#define SZ 11

void main()
{
    int arr[SZ] = {8, 12, 5, 56, 35, 353, 565, 52, 42, 55, 686}, n;
    printf("Enter the element you want:");
    scanf("%d", &n);
    for (int i = 0; i < SZ; i++)
    {
        if (arr[i] == n)
        {
            printf("%d is the %dth element", n, i + 1);
            break;
        }
    }
}