public class Solution {

    public int smallerThanBinarySearch(ArrayList<Integer> A, int toFind) {

        int low = 0;
        int high = A.size() - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == toFind) {
                high = mid - 1;
            }
            if (A.get(mid) < toFind) {
                index = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index + 1; // as index gives count, it has to be 1-based indexing
    }

    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int answer = -1;

        int n = A.size();
        int m = A.get(0).size();

        int medianPos = n * m / 2;

        while (low <= high) {
            int count = 0;
            int mid = low + (high - low) / 2;

            // System.out.println("main : "+mid);

            for (int i = 0; i < A.size(); ++i) {
                // O(n*logm)

                count += smallerThanBinarySearch(A.get(i), mid);
                // System.out.println("count is "+count);
            }

            if (count <= medianPos) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }
}
