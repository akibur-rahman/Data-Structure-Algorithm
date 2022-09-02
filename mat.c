#include <stdio.h>

int main()

{

    int i, j, k, size, X[10];

    float Y[20][20], Z, sum = 0.0;

    printf("\n");

    printf("Enter the size of matrix: ");

    scanf("%d", &size);

    printf("\n\n");

    printf("Enter(row-wise)elements for augmented matrix:");

    printf("\n");

    for (i = 1; i <= size; i++)

    {

        for (j = 1; j <= (size + 1); j++)

        {

            scanf("%f", &Y[i][j]);
        }
    }

    printf("\n");

    printf("Inputed matrix is: \n");

    for (i = 1; i <= size; i++)

    {

        for (j = 1; j <= size + 1; j++)

        {

            printf("%.2f", Y[i][j]);

            printf("\t");
        }

        printf("\n");
    }

    for (j = 1; j <= size; j++)

    {

        for (i = 1; i <= size; i++)

        {

            if (i > j)

            {

                Z = Y[i][j] / Y[j][j];

                for (k = 1; k <= size + 1; k++)

                {

                    Y[i][k] = Y[i][k] - Z * Y[j][k];
                }
            }
        }
    }

    X[size] = Y[size][size + 1] / Y[size][size];

    for (i = size - 1; i >= 1; i--)

    {

        sum = 0.0;

        for (j = i + 1; j <= size; j++)

        {

            sum = sum + Y[i][j] * X[j];
        }

        X[i] = (Y[i][size + 1] - sum) / Y[i][i];
    }

    printf("\n");

    printf("\nThe solution is: \n");

    printf("\nNumber Of Child= %d ", X[1]);

    printf("\nNumber Of Adult= %d", X[2]);

    printf("\n\n");
}
