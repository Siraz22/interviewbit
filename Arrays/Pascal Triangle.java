public class Solution {
    public ArrayList<ArrayList<Integer>> solve(int A) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        int row = 1;
        for (int i = 0; i < A; ++i) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < row; ++j) {
                temp.add(1);
            }
            row++;
            ans.add(temp);
        }

        if (A == 1 || A == 2) {
            return ans;
        }

        for (int i = 2; i < ans.size(); ++i) {
            for (int j = 1; j < i; ++j) {
                int sum = ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
                ans.get(i).set(j, sum);
            }
        }
        return ans;
    }
}
