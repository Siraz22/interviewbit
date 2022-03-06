import java.util.*;

class Solution {

    public int recursion(String A, String B, int n, int m, int[][] dp) {

        // Base condition 1
        if (n <= 0 && m != 0)
            return m;
        else if (m <= 0 && n != 0)
            return n;

        // Base condition 2
        if (n <= 0 || m <= 0)
            return 0;

        if (dp[n][m] != -1)
            return dp[n][m];

        char a = A.charAt(n - 1);
        char b = B.charAt(m - 1);

        if (a == b)
            return recursion(A, B, n - 1, m - 1, dp);
        else {
            int insert = 1 + recursion(A, B, n, m - 1, dp);
            int replace = 1 + recursion(A, B, n - 1, m - 1, dp);
            int delete = 1 + recursion(A, B, n - 1, m, dp);
            return dp[n][m] = Math.min(replace, Math.min(insert, delete));
        }
    }

    public int minDistance(String A, String B) {
        int[][] dp = new int[A.length() + 1][B.length() + 1];

        for (int i = 0; i < A.length() + 1; ++i) {
            for (int j = 0; j < B.length() + 1; ++j) {
                dp[i][j] = -1;
            }
        }

        int answer = recursion(A, B, A.length(), B.length(), dp);
        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String arrStr = "1,2,3,4";
        String[] arr = arrStr.split(",");
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; ++i) {
            arrList.add(Integer.parseInt(arr[i]));
        }
        Object answer = solution.minDistance("black", "bale");
        System.out.println(answer.toString());
    }
}