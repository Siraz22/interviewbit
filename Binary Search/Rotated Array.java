public class Solution {
    // DO NOT MODIFY THE LIST
    public int findMin(final List<Integer> A) {
        int low = 0;
        int high = A.size() - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Case 1 : no modification
            if (A.get(low) <= A.get(mid) && A.get(mid) <= A.get(high)) {

                return A.get(low);
            } else {
                // there has been some modification. check prev and next value
                int prev = (mid + A.size() - 1) % A.size();
                int next = (mid + 1) % A.size();

                // subcase 1 : 4 5 '1' 2 3 -> mid is answer
                if (A.get(prev) >= A.get(mid) && A.get(mid) <= A.get(next)) {
                    index = mid;
                    return A.get(mid);
                }

                // subcase 2 : 3 4 '5' 1 2 -> move right
                if (A.get(high) <= A.get(mid)) {
                    // System.out.println("right");
                    low = mid + 1;
                } else {
                    // System.out.println("left");
                    high = mid - 1;
                }
            }
        }
        return A.get(index);
    }
}
