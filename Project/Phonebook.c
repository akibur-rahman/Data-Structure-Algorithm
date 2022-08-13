#include <stdio.h>

typedef struct node
{
    char name[20];
    char number[10];

} node;

void selectionmenu()
{
    int choice;
    printf("Enter Your Choice:");
    scanf("%d", &choice);

    switch (choice)
    {
    case 1:
        break;

    default:
        break;
    }
}

void main()
{
    selectionmenu();
}