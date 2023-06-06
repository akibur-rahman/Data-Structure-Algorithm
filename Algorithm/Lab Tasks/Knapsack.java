public class Knapsack {

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String args[]) {
        int p[] = new int[] { 0, 1, 2, 5, 6 };
        int wt[] = new int[] { 0, 2, 3, 4, 5 };
        int m = 8;
        int n = 4;
        int k[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= m; w++) {
                if (i == 0 || w == 0) {
                    k[i][w] = 0;
                } else if (wt[i] <= w) {
                    k[i][w] = max(p[i] + k[i - 1][w - wt[i]], k[i - 1][w]);
                } else {
                    k[i][w] = k[i - 1][w];
                }
            }

        }
        System.out.println(k[n][m]);

    }
}