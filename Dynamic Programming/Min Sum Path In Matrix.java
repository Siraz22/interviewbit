import java.util.*;

public class Solution {

    // "He holds the gun against my head
    // I close my eyes and bang I am dead"
    // - Aurora, Murder Song, Nobel Peace Prize Concert

    public int recursion(ArrayList<ArrayList<Integer>> matrix, int[][] dp, int row, int col) {
        // base condition

        // System.out.println("row="+row+", col="+col);

        if (row == matrix.size() - 1 && col == matrix.get(0).size() - 1)
            return matrix.get(row).get(col);

        // base condition 2 : only one direction left
        if (row == matrix.size() - 1)
            return dp[row][col] = matrix.get(row).get(col) + recursion(matrix, dp, row, col + 1);
        if (col == matrix.get(0).size() - 1)
            return dp[row][col] = matrix.get(row).get(col) + recursion(matrix, dp, row + 1, col);

        if (dp[row][col] != -1)
            return dp[row][col];

        return dp[row][col] = matrix.get(row).get(col) + Math.min(recursion(matrix, dp, row + 1, col),
                recursion(matrix, dp, row, col + 1));
    }

    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int[][] dp = new int[A.size()][A.get(0).size()];
        for (int i = 0; i < A.size(); ++i) {
            for (int j = 0; j < A.get(0).size(); ++j) {
                dp[i][j] = -1;
            }
        }
        int answer = recursion(A, dp, 0, 0);
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

        int matrix[][] = {
                { 1, 3, 2 },
                { 4, 3, 1 },
                { 5, 6, 1 } };

        ArrayList<ArrayList<Integer>> matrixList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < matrix.length; ++i) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < matrix[i].length; ++j) {
                temp.add(matrix[i][j]);
            }
            matrixList.add(temp);
        }

        Object answer = solution.minPathSum(matrixList);
        System.out.println(answer.toString());
    }
}