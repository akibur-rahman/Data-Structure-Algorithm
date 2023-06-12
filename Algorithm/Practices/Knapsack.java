package Algorithm.Practices;

//implement the 0-1 knapsack problem with dummy data and print out the result

public class Knapsack {
    public static void main(String[] args) {
        int[] weight = { 1, 2, 4, 2, 5 };
        int[] value = { 5, 3, 5, 3, 2 };
        int[][] dp = new int[weight.length + 1][11];
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j >= weight[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[weight.length][10]);
    }

}
