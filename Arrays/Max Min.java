public class Solution {
    public int solve(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); ++i) {
            int num = A.get(i);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return min + max;
    }
}
