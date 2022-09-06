#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
    int data;
    struct node *next;
} node;

node *head, *temp, *prev;

void create_list()
{
    head = NULL;
    temp = head;
    int size, node_count = 1, data;
    printf("\nEnter the size of the linked list:");
    scanf("%d", &size);
    printf("\nPlease Enter data in sorted order");
    while (node_count <= size)
    {
        node *newNode = (node *)malloc(sizeof(node));
        printf("\nEnter data:");
        scanf("%d", &data);
        if (head == NULL)
        {
            newNode->data = data;
            head = newNode;
            head->next = NULL;
            prev = head;
        }
        else
        {
            newNode->data = data;
            newNode->next = NULL;
            prev->next = newNode;
            prev = prev->next;
        }
        node_count++;
    }
}

void print_list()
{
    temp = head;
    printf("\nList is: ");
    while (temp != NULL)
    {
        printf("%d\t", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

void insert_in_sorted_list()
{
    node *newNode = (node *)malloc(sizeof(node));
    printf("\nEnter the data you want to insert: ");
    scanf("%d", &newNode->data);
    if (head == NULL || (head)->data >= newNode->data)
    {
        newNode->next = head;
        head = newNode;
        return;
    }

    temp = head;
    while (temp->next != NULL && temp->next->data < newNode->data)
    {
        temp = temp->next;
    }

    newNode->next = temp->next;
    temp->next = newNode;
}

void main()
{
    create_list();
    print_list();
    insert_in_sorted_list();
    print_list();
}