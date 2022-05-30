public class Solution {
    public int solve(int A, int B, int C) {
        int headStartIndex = C - 1;
        int reqIndex = (headStartIndex + A) % B;
        return reqIndex;
    }
}
