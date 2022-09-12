#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct node
{
    char name[30];
    char number[20];
    struct node *next;

} node;

node *head, *temp, *prev, *next, *cur;

void read_data()
{
    head = NULL, prev = NULL;
    FILE *fp = fopen("data.txt", "r");
    if (fp == NULL)
    {
        printf("Unable to Read data from file. Make sure data.txt is in the same directory\a\n");
        exit(1);
    }
    char line[50];
    char *sp;
    while (fgets(line, 50, fp) != NULL)
    {
        temp = (node *)malloc(sizeof(node));
        sp = strtok(line, ",");
        strcpy(temp->name, sp);
        sp = strtok(NULL, ",");
        strcpy(temp->number, sp);
        temp->next == NULL;
        if (head == NULL)
        {
            temp->next = NULL;
            head = temp;
            prev = head;
        }
        else
        {
            prev->next = temp;
            temp->next = NULL;
            prev = prev->next;
        }
    }

    fclose(fp);
}

void print_list()
{
    temp = head;
    while (temp != NULL)
    {
        printf("%s\t\t%s\n", temp->name, temp->number);
        temp = temp->next;
    }
}

void write_data()
{
    FILE *fp = fopen("data.txt", "w");
    for (cur = head; cur; cur = cur->next)
    {
        fprintf(fp, "%s,%s", cur->name, cur->number);
    }
    fprintf(fp, "\n");
    fclose(fp);
}

void insert_data()
{
    temp = head;
    while (temp->next != NULL)
    {
        temp = temp->next;
    }
    node *newNode = (node *)malloc(sizeof(node));
    printf("\nEnter Name:");
    gets(newNode->name);
    printf("\nEnter Number:");
    gets(newNode->number);
    newNode->next = temp->next;
    temp->next = newNode;
    write_data();
    printf("\nPerson's Details Added Successfully\n");
}

void search_list()
{
    char contactName[30];
    printf("\nEnter Name:");
    gets(contactName);
    temp = head;
    while (temp != NULL)
    {
        if (strcmp(temp->name, contactName) == 0)
        {
            printf("\nContact Name : %s\n", temp->name);
            printf("Contact Number : %s\n", temp->number);
        }
        temp = temp->next;
    }
}

void delete_data()
{
    char contactName[30];
    printf("\nEnter Name:");
    gets(contactName);
    int count = 0;
    prev = NULL;
    temp = head;
    if (temp == NULL)
    {
        printf("No data to delete!!");
        return;
    }
    else
    {
        while (temp != NULL)
        {

            if (strcmp(temp->name, contactName) == 0)
            {
                if (prev == NULL)
                {
                    cur = temp;
                    head = head->next;
                    free(cur);
                    temp = head;
                    prev = NULL;
                }
                else
                {
                    prev->next = temp->next;
                    cur = temp;
                    free(cur);
                    temp = prev->next;
                }
                count++;
            }
            else
            {
                prev = temp;
                temp = temp->next;
            }
        }
        if (count == 0)
        {
            printf("\nPerson Doesn't Exist\n");
            return;
        }
        else
        {
            write_data();
            printf("\nPerson Deleted Form Phonebook\n");
        }
    }
}

void selection_menu()
{
    int choice;
    printf("\n1.View All Contacts\n2.Add New Contact\n3.Delete Contact\n4.View Contact Details\n5.Sort Contacts\n0.Exit\n");
    printf("Enter Your Choice:");
    scanf("%d", &choice);
    switch (choice)
    {
    case 0:
        exit(0);
        break;
    case 1:
        print_list();
        break;
    case 2:
        insert_data();
        break;
    case 3:
        delete_data();
        break;
    case 4:
        search_list();
        break;
    default:
        printf("\n**************Invalid Input**************n\a");
        break;
    }
}

void main()
{
    read_data();
    /*
    print_list();
    printf("----------Insert Data----------");
    insert_data();
    printf("----------Delete Data----------");
    delete_data();
    printf("----------Search Data----------");
    search_list();
    */
    while (1)
    {
        selection_menu();
    }
}