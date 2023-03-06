#include <stdio.h>
#define size 10

void printArray(int arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
}

void main()
{
    int position, arr[size] = {1, 3, 2, 5, 7, 8, 3, 2, 8, 4};
    printArray(arr, size);
    printf("\nEnter Position:");
    scanf("%d", &position);
    for (int i = position - 1; i < size - 1; i++)
    {
        arr[i] = arr[i + 1];
    }
    printArray(arr, size);
}