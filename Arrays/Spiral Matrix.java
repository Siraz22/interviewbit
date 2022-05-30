public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, int rows, int cols) {

        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < rows; ++i) {
            ArrayList<Integer> temp = new ArrayList<Integer>(Collections.nCopies(cols, -1));
            answer.add(temp);
        }

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        int direction = 1;
        int iter = 0;

        while (top <= bottom && left <= right) {

            // left to right on top layer
            if (direction == 1 && iter < A.size()) {
                for (int i = left; i <= right; ++i) {
                    int val = A.get(iter);
                    iter++;
                    answer.get(top).set(i, val);
                }
                direction = 2;
                top++;
            }

            // top to bottom on right layer
            if (direction == 2 && iter < A.size()) {
                for (int i = top; i <= bottom; ++i) {
                    int val = A.get(iter);
                    iter++;
                    answer.get(i).set(right, val);
                }
                direction = 3;
                right--;
            }

            // right to left on bottom layer
            if (direction == 3 && iter < A.size()) {
                for (int i = right; i >= left; --i) {
                    int val = A.get(iter);
                    iter++;
                    answer.get(bottom).set(i, val);
                }
                direction = 4;
                bottom--;
            }

            // bottom to top on left layer
            if (direction == 4 && iter < A.size()) {
                for (int i = bottom; i >= top; --i) {
                    int val = A.get(iter);
                    iter++;
                    answer.get(i).set(left, val);
                }
                direction = 1;
                left++;
            }

        }

        return answer;
    }
}
