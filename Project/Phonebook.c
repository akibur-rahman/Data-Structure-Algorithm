#include <stdio.h>

typedef struct node
{
    char name[20];
    char number[10];
    struct node *next;

} node;

node *head, *temp, *prev, *next;

void printlist()
{
    temp = head;
    while (temp != NULL)
    {
        printf("%s\t%d", temp->name, temp->number);
        temp = temp->next;
    }
}

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