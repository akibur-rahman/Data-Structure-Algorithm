#include <stdio.h>

void BubbleSort(int arr[], int n)
{
    int i, j, flag;
    for (i = 0; i < n; i++)
    {
        flag = 0;
        for (j = 0; j < n - i - 1; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                flag = 1;
            }
        }
        if (flag == 0)
        {
            return;
        }
    }
}

void printArray(int arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
}

int main()
{
    int arr[10] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, n = 10;
    BubbleSort(arr, n);
    printArray(arr, n);
    return 0;
}