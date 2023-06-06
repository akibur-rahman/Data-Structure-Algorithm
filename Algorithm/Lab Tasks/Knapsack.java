public class Knapsack {

    static int max(int a, int b) {
        if (a > b) {
            return a;
        } else
            return b;
    }

    public static void main(String args[]) {
        int p[] = new int[] { 0, 1, 2, 5, 6 };// stores profit
        int wt[] = new int[] { 0, 2, 3, 4, 5 }; // stores weight
        int m = 8; // capacity of knapsack
        int n = 4; // number of items
        int k[][] = new int[n + 1][m + 1]; // stores the result

        for (int i = 0; i <= n; i++) { // loop for items
            for (int w = 0; w <= m; w++) { // loop for capacity
                if (i == 0 || w == 0) { // if no item or no capacity
                    k[i][w] = 0; // profit is 0, for both row 0 and column 0
                } else if (wt[i] <= w) { // if weight of item is less than capacity
                    k[i][w] = max(p[i] + k[i - 1][w - wt[i]], k[i - 1][w]); // max of profit of current item + profit of
                                                                            // previous item and profit of previous item
                } else { // if weight of item is more than capacity
                    k[i][w] = k[i - 1][w]; // profit of previous item
                }
            }

        }
        System.out.println(k[n][m]);

    }
}