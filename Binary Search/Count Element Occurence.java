public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY

    public int binarySearch(List<Integer> A, int B, int start, int end, boolean searchLeft) {

        int high = end;
        int low = start;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // case1 : found
            if (A.get(mid) == B) {
                index = mid;
                if (searchLeft) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (A.get(mid) < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }

    public int findCount(final List<Integer> A, int B) {
        int leftIndex = binarySearch(A, B, 0, A.size() - 1, true);

        if (leftIndex == -1)
            return 0;

        int rightIndex = binarySearch(A, B, 0, A.size() - 1, false);
        return rightIndex - leftIndex + 1;
    }
}
