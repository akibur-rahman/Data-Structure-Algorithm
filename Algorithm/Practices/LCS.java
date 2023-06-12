package Algorithm.Practices;

//implement the longest common subsequence problem with dummy data and print out the result

public class LCS {
    public static void main(String[] args) {
        String s1 = "abcbdab";
        String s2 = "bdcaba";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j <= s2.length(); j++) {
                char c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
    }
}
