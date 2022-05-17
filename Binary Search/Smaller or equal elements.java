public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int low = 0;
        int high = A.size() - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == B) {
                index = mid;
                low = mid + 1;
            } else if (A.get(mid) < B) {
                low = mid + 1;
                index = mid;
            } else {
                high = mid - 1;
            }
        }

        return index + 1;
    }
}
