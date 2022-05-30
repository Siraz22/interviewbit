public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int greater = 0;
        int lesser = 0;

        for (int i = 0; i < A.size(); ++i) {
            if (A.get(i) > C)
                greater++;
        }

        for (int i = 0; i < B.size(); ++i) {
            if (B.get(i) < C)
                lesser++;
        }

        return Math.max(lesser, greater);
    }
}
