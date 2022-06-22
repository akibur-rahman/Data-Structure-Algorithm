#include <stdio.h>
#define SZ 10

void InsertionSort(int arr[], int n)
{
    int i, j;
    for (i = 1; i < n; i++) // starts from index 1 because first one (arr[0]) is assumed to be sorted
    {
        int temp = arr[i]; // first element of unsorted part is put in a temp variable
        j = i - 1;

        while (j >= 0 && arr[j] > temp)
        {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = temp;
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
    int arr[SZ] = {6, 5, 3, 7, 8, 34, 5, 68, 4, 89};
    InsertionSort(arr, SZ);
    printArray(arr, SZ);
}