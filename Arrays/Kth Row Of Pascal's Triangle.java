public class Solution {
    public ArrayList<Integer> getRow(int A) {

        ArrayList<Integer> ans = new ArrayList<Integer>();

        if (A == 0) {
            ans.add(1);
            return ans;
        } else if (A == 1) {
            ans.add(1);
            ans.add(1);
            return ans;
        }

        int arr[][] = new int[A + 1][A + 1];

        for (int i = 0; i < A + 1; ++i) {
            for (int j = 0; j < A + 1; ++j) {
                arr[i][j] = 1;
            }
        }

        for (int i = 2; i < A + 1; ++i) {
            for (int j = 1; j < i; ++j) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

        for (int i = 0; i < A + 1; ++i) {
            ans.add(arr[A][i]);
        }
        return ans;
    }
}
