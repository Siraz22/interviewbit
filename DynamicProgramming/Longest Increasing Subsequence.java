import java.util.*;

class Solution {

    // "I used to rule the world
    // Seas would rise when I gave the word
    // Now in the morning, I sleep alone
    // Sweep the streets I used to own"
    // - Viva La Vida, Coldplay

    public int lis(final List<Integer> A) {
        int[] dp = new int[A.size()];

        for (int i = 0; i < A.size(); ++i) {
            dp[i] = 1;
        }

        for (int i = 1; i < A.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (A.get(i) > A.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = -1;
        for (int i = 0; i < dp.length; ++i) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String arrStr = "1,2,2";
        String[] arr = arrStr.split(",");
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; ++i) {
            arrList.add(Integer.parseInt(arr[i]));
        }
        Object answer = solution.lis(arrList);
        System.out.println(answer.toString());
    }
}