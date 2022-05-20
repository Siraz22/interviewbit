public class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < A; ++i) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < A; ++j) {
                row.add(0);
            }
            ans.add(row);
        }

        int top = 0;
        int bottom = A - 1;
        int left = 0;
        int right = A - 1;

        int direction = 1;
        int count = 1;

        while (top <= bottom && left <= right) {

            if (direction == 1) {
                int iter = left;
                while (iter <= right) {
                    ans.get(top).set(iter, count);
                    iter++;
                    count++;
                }
                top++;
                direction = 2;
            } else if (direction == 2) {
                int iter = top;
                while (iter <= bottom) {
                    ans.get(iter).set(right, count);
                    iter++;
                    count++;
                }
                right--;
                direction = 3;
            } else if (direction == 3) {
                int iter = right;
                while (iter >= left) {
                    ans.get(bottom).set(iter, count);
                    iter--;
                    count++;
                }
                bottom--;
                direction = 4;
            } else if (direction == 4) {
                int iter = bottom;
                while (iter >= top) {
                    ans.get(iter).set(left, count);
                    iter--;
                    count++;
                }
                left++;
                direction = 1;
            }
        }

        // int a = 2;
        // System.out.println("Wait");
        return ans;
    }
}
