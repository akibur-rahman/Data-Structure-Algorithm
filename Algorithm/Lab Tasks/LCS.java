<<<<<<< HEAD
import java.util.Scanner;

public class LCS {

    static int max(int a, int b) { // max fucntion
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int m = s1.length(); // length of string
        int n = s2.length(); // length of string

        char x[] = s1.toCharArray();
        char y[] = s2.toCharArray();

        int lcs[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) { // initialization
            lcs[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            lcs[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) { // if match
                    lcs[i][j] = 1 + lcs[i - 1][j - 1]; // add 1 to previous
                } else { // if not match
                    lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1]); // take max of previous
                }
            }
        }

        System.out.println("the length is : " + lcs[m][n]); // print length
=======
public class LCS {
    static void lcs(String S1, String S2, int m, int n) {
        int[][] LCS_table = new int[m + 1][n + 1];

        // Building the mtrix in bottom-up way
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    LCS_table[i][j] = 0;
                else if (S1.charAt(i - 1) == S2.charAt(j - 1))
                    LCS_table[i][j] = LCS_table[i - 1][j - 1] + 1;
                else
                    LCS_table[i][j] = Math.max(LCS_table[i - 1][j], LCS_table[i][j - 1]);
            }
        }

        int index = LCS_table[m][n];
        int temp = index;

        char[] lcs = new char[index + 1];
        lcs[index] = '\0';

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                lcs[index - 1] = S1.charAt(i - 1);

                i--;
                j--;
                index--;
            }

            else if (LCS_table[i - 1][j] > LCS_table[i][j - 1])
                i--;
            else
                j--;
        }

        // Printing the sub sequences
        System.out.print("S1 : " + S1 + "\nS2 : " + S2 + "\nLCS: ");
        for (int k = 0; k <= temp; k++)
            System.out.print(lcs[k]);
        System.out.println("");
    }

    public static void main(String[] args) {
        String S1 = "ACADB";
        String S2 = "CBDA";
        int m = S1.length();
        int n = S2.length();
        lcs(S1, S2, m, n);
>>>>>>> 00ddb15e5ecab28260dbdb1b72fbe95aee615884
    }
}