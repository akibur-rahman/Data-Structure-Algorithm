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
    }
}