public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int start = 0;

        for (int i = 0; i < A.size(); ++i) {
            if (A.get(i) != 0) {
                int temp = A.get(start);
                A.set(start, A.get(i));
                A.set(i, temp);
                start++;
            }
        }

        return A;
    }
}
