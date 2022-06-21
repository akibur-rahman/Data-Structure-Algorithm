#include <stdio.h>
#define SZ 10

void main()
{
    int arr[SZ] = {8, 23, 45, 4, 34, 56, 6, 46, 7, 2}, i, j, temp, flag;

    for (i = 0; i < SZ - 1; i++)
    {
        flag = 0;
        for (j = 0; j < SZ - i - 1; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                flag = 1;
            }
        }
        if (flag == 0)
        {
            break;
        }
    }

    for (i = 0; i < SZ; i++)
    {
        printf("%d ", arr[i]);
    }
}