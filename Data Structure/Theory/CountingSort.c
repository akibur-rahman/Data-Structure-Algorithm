#include <stdio.h>

void CountingSort(int arr[], int size)
{
    int max = arr[0], output[size];
    for (int i = 1; i < size; i++)
    {
        if (arr[i] > max)
        {
            max = arr[i];
        }
    }

    int count[10];

    for (int i = 0; i <= max; i++)
    {
        count[i] = 0;
    }

    for (int i = 0; i < size; i++)
    {
        count[arr[i]]++;
    }

    for (int i = 1; i <= max; i++)
    {
        count[i] += count[i - 1];
    }

    for (int i = 0; i < size; i++)
    {
        output[--count[arr[i]]] = arr[i];
    }
    for (int i = 0; i < size; i++)
    {
        arr[i] = output[i];
    }
}

void printArray(int arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
}

void main()
{
    int arr[10] = {3, 0, 5, 3, 2, 1, 3, 4, 5, 0};
    int n = sizeof(arr) / sizeof(int);
    CountingSort(arr, n);
    printArray(arr, n);
}