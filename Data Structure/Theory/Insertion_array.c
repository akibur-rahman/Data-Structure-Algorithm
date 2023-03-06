#include <stdio.h>

void main()
{
    int size, pos, value, i, arr[100];
    printf("How many elements in the array:");
    scanf("%d", &size);
    printf("\n%d elements are:", size);
    for (i = 0; i < size; i++)
    {
        scanf("%d", &arr[i]);
    }
    printf("\nEnter Position:");
    scanf("%d", &pos);
    printf("\nEnter Value:");
    scanf("%d", &value);
    for (i = size - 1; i > pos - 1; i--)
    {
        arr[i + 1] = arr[i];
    }
    arr[pos - 1] = value;
    for (i = 0; i <= size; i++)
    {
        printf("%d ", arr[i]);
    }
}