public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest(final List<Integer> A, int B) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.size(); ++i) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }

        int low = min;
        int high = max;
        while (low <= high) {

            int lessThan = 0;
            int equalTo = 0;

            int mid = (high - low) / 2 + low;
            for (int i = 0; i < A.size(); ++i) {
                if (A.get(i) < mid) {
                    lessThan++;
                } else if (A.get(i) == mid) {
                    equalTo++;
                }
            }

            if (lessThan < B && B <= lessThan + equalTo)
                return mid;
            else if (lessThan < B)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return 0;
    }
}
