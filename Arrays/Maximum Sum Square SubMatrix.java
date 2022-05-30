public class Solution {

    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int[][] helper = new int[A.size()][A.get(0).size()];

        helper[0][0] = A.get(0).get(0);

        for (int i = 1; i < A.size(); ++i) {
            helper[0][i] = A.get(0).get(i) + helper[0][i - 1];
        }

        for (int i = 1; i < A.get(0).size(); ++i) {
            helper[i][0] = A.get(i).get(0) + helper[i - 1][0];
        }

        for (int i = 1; i < A.size(); ++i) {
            for (int j = 1; j < A.get(0).size(); ++j) {
                helper[i][j] = helper[i - 1][j] + helper[i][j - 1] - helper[i - 1][j - 1] + A.get(i).get(j);
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = B - 1; i < A.size(); ++i) {
            for (int j = B - 1; j < A.get(0).size(); ++j) {
                int leftSubtractIndex = (j - B < 0) ? 0 : helper[i][j - B];
                int upperSubtractIndex = (i - B < 0) ? 0 : helper[i - B][j];
                int adderDiagonal = (i - B < 0 || j - B < 0) ? 0 : helper[i - B][j - B];
                int subMatrixSum = helper[i][j] - leftSubtractIndex - upperSubtractIndex + adderDiagonal;
                // System.out.println("submatrix sum is "+ subMatrixSum);
                max = Math.max(subMatrixSum, max);
            }
        }

        return max;
    }
}
