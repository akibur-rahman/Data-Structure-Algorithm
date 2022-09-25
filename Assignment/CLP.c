#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct student
{
    int id;
    char name[25];
    float presentation_mark;
    float assignment_marks;
    float ct1_marks;
    float ct2_marks;
    float ct3_marks;
    float midterm_marks;
    float final_marks;
    int total_class_count;
    int total_absent;
    float best_2_ct_avg;
    float gpa;
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

float calculate_gpa(float presentation_marks, float midterm_marks, float final_marks, float ct_marks, float assignment_marks)
{
    float total_marks = presentation_marks + midterm_marks + final_marks + ct_marks + assignment_marks, gpa;
    if (total_marks >= 80)
    {
        gpa = 4.00;
        return gpa;
    }
    else if (total_marks >= 75)
    {
        gpa = 3.75;
        return gpa;
    }
    else if (total_marks >= 70)
    {
        gpa = 3.50;
        return gpa;
    }
    else if (total_marks >= 65)
    {
        gpa = 3.25;
        return gpa;
    }
    else if (total_marks >= 60)
    {
        gpa = 3.00;
        return gpa;
    }
    else if (total_marks >= 55)
    {
        gpa = 2.75;
        return gpa;
    }
    else if (total_marks >= 50)
    {
        gpa = 2.50;
        return gpa;
    }
    else if (total_marks >= 45)
    {
        gpa = 2.25;
        return gpa;
    }
    else if (total_marks >= 44)
    {
        gpa = 2.00;
        return gpa;
    }
    else
    {
        gpa = 0.00;
        return gpa;
    }
}

void create_list()
{
    head = NULL;
    temp = head;
    int number_of_students, node_count = 1;
    printf("\nEnter The Number Of Students:");
    scanf("%d", &number_of_students);
    while (node_count <= number_of_students)
    {
        printf("\n\n*********Student %d Details*********\n", node_count);
        student *newStudent = (student *)malloc(sizeof(student));
        printf("\nEnter Student's id:");
        scanf("%d", &newStudent->id);
        printf("\nEnter Student's Name:");
        scanf("%s", newStudent->name);
        printf("\nEnter Student's Presentation Mark:");
        scanf("%f", &newStudent->presentation_mark);
        printf("\nEnter Student's Assignment Mark:");
        scanf("%f", &newStudent->assignment_marks);
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
        newStudent->gpa = calculate_gpa(newStudent->presentation_mark, newStudent->midterm_marks, newStudent->final_marks, newStudent->best_2_ct_avg, newStudent->assignment_marks);
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

void display_student_details()
{
    temp = head;
    int student_count = 1;
    while (temp != NULL)
    {
        printf("\n\n*********Student %d Details*********\n", student_count);
        printf("\nStudent ID: %d", temp->id);
        printf("\nStudent Name: %s", temp->name);
        printf("\nPresentation Marks: %.2f", temp->presentation_mark);
        printf("\nAssignment Marks: %.2f", temp->assignment_marks);
        printf("\nCT-01 Marks: %.2f", temp->ct1_marks);
        printf("\nCT-02 Marks: %.2f", temp->ct2_marks);
        printf("\nCT-03 Marks: %.2f", temp->ct3_marks);
        printf("\nAvarage Best 2 CT Marks: %.2f", temp->best_2_ct_avg);
        printf("\nMid Term Marks: %.2f", temp->midterm_marks);
        printf("\nFinal Exam Marks: %.2f", temp->final_marks);
        printf("\nTotal Present: %d Days", temp->total_class_count - temp->total_absent);
        printf("\nStuden's GPA: %.2f", temp->gpa);
        student_count++;
        temp = temp->next;
    }
    printf("\n");
}

void print_gpa()
{
    temp = head;
    printf("\n\nGPA List: ");
    while (temp != NULL)
    {
        printf("\n%s's GPA is: %.2f", temp->name, temp->gpa);
        temp = temp->next;
    }
    printf("\n");
}

void fail_students()
{
    temp = head;
    while (temp != NULL)
    {
        float total_present = temp->total_class_count - temp->total_absent;
        float percentage = (total_present / temp->total_class_count) * 100;
        if (percentage < 40)
        {
            temp->final_marks = -1;
            temp->gpa = 0.00;
        }
        temp = temp->next;
    }
}

int main()
{
    create_list();
    fail_students();
    print_gpa();
    display_student_details();
    return 0;
}
