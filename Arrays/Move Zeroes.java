public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int startPos = 0;

        for (int i = 0; i < A.size(); ++i) {
            if (A.get(i) != 0) {
                int temp = A.get(startPos);
                A.set(startPos, A.get(i));
                A.set(i, temp);
                startPos++;
            }
        }

        return A;
    }
}
