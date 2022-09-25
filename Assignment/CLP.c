#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct student
{
    int id;
    char name[25];
    float presentation_mark;
    float ct1_marks;
    float ct2_marks;
    float ct3_marks;
    float midterm_marks;
    float final_marks;
    int total_class_count;
    int total_absent;
    float best_2_ct_avg;
    struct student *next;
} student;

student *head, *temp, *prev, *cur;

float calculate_best_2_ct_avarage(float a, float b, float c)
{

    float max1, max2;

    // find best mark
    if (a >= b && a >= c)
        max1 = a;
    if (b >= a && b >= c)
        max1 = b;
    if (c >= a && c >= b)
        max1 = c;
    // find second best mark
    if (a > b && a > c)
    {
        if (b > c)
            max2 = b;
        else
            max2 = c;
    }
    else if (b > c && b > a)
    {
        if (c > a)
            max2 = c;
        else
            max2 = a;
    }
    else if (a > b)
        max2 = a;
    else
        max2 = b;

    float avg = (max1 + max2) / 2;
    return avg;
}

void create_list()
{
    head = NULL;
    temp = head;
    int number_of_students, node_count = 1;
    printf("\nEnter the number of students:");
    scanf("%d", &number_of_students);
    while (node_count <= number_of_students)
    {
        student *newStudent = (student *)malloc(sizeof(student));
        printf("\nEnter Student's id:");
        scanf("%d", &newStudent->id);
        printf("\nEnter Student's Name:");
        scanf("%s", newStudent->name);
        printf("\nEnter Student's Presentation Mark:");
        scanf("%f", &newStudent->presentation_mark);
        printf("\nEnter Student's CT-01 Marks:");
        scanf("%f", &newStudent->ct1_marks);
        printf("\nEnter Student's CT-02 Marks:");
        scanf("%f", &newStudent->ct2_marks);
        printf("\nEnter Student's CT-03 Marks:");
        scanf("%f", &newStudent->ct3_marks);
        printf("\nEnter Student's MidTerm Marks:");
        scanf("%f", &newStudent->midterm_marks);
        printf("\nEnter Student's Final Marks:");
        scanf("%f", &newStudent->final_marks);
        printf("\nEnter Total Class Count:");
        scanf("%d", &newStudent->total_class_count);
        printf("\nTotal Absent:");
        scanf("%d", &newStudent->total_absent);
        newStudent->best_2_ct_avg = calculate_best_2_ct_avarage(newStudent->ct1_marks, newStudent->ct2_marks, newStudent->ct3_marks);
        if (head == NULL)
        {
            head = newStudent;
            head->next = NULL;
            prev = head;
        }
        else
        {
            newStudent->next = NULL;
            prev->next = newStudent;
            prev = prev->next;
        }
        node_count++;
    }
}

int main()
{
    create_list();
    return 0;
}
