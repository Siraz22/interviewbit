public class Solution {
    public int solve(int A, int B) {

        int upperRight = Math.min(8 - A, 8 - B);
        int upperLeft = Math.min(A - 1, 8 - B);
        int lowerRight = Math.min(8 - A, B - 1);
        int lowerLeft = Math.min(A - 1, B - 1);

        return upperLeft + upperRight + lowerLeft + lowerRight;
    }
}
