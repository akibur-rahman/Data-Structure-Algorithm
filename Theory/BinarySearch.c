// This Algorithm needs a sorted array to work.

#include <stdio.h>
#define SZ 10

void main()
{
    int array[SZ] = {2, 4, 6, 8, 9, 12, 36, 54, 65, 78}, n, i;
    printf("Enter the element you want:");
    scanf("%d", &n);
    int low = 0, high = SZ - 1;
    while (low <= high)
    {
        int mid = (low + high) / 2;

        if (array[mid] == n)
            printf("%d is %dth element\n", n, mid + 1);

        if (array[mid] < n)
            low = mid + 1;

        else
            high = mid - 1; 
    }
}