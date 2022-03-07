import java.util.*;

class Solution {

    // "You can cry
    // Drinking your eyes
    // Do you miss the sadness when it's gone?
    // And you let the river run wild"
    // - Aurora, The River

    int modifiedLCS(String A) {
        int[][] dp = new int[A.length() + 1][A.length() + 1];
        for (int i = 0; i < A.length(); ++i) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < A.length(); ++i) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < A.length() + 1; ++i) {
            for (int j = 1; j < A.length() + 1; ++j) {
                char a = A.charAt(i - 1);
                char b = A.charAt(j - 1);

                if (a == b && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[A.length()][A.length()];
    }

    public int anytwo(String A) {
        int repeatingLCS = modifiedLCS(A);
        // System.out.println(repeatingLCS + " is length");
        return repeatingLCS >= 2 ? 1 : 0;
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
        Object answer = solution.anytwo("abab");
        System.out.println(answer.toString());
    }
}