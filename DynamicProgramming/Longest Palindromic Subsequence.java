package DynamicProgramming;

import java.util.*;

class Solution {

    public int LCS(String A, String B) {
        int[][] dp = new int[A.length() + 1][B.length() + 1];

        for (int i = 0; i < A.length() + 1; ++i) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < B.length() + 1; ++i) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < A.length() + 1; ++i) {
            for (int j = 1; j < B.length() + 1; ++j) {
                char a = A.charAt(i - 1);
                char b = B.charAt(j - 1);

                // Case 1 : characters match
                if (a == b)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[A.length()][B.length()];
    }

    public int solve(String A) {
        StringBuilder str = new StringBuilder(A);
        String reversed = (String) str.reverse().toString();

        int answer = LCS(A, reversed);
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
        Object answer = solution.solve("abaav");
        System.out.println(answer.toString());
    }
}