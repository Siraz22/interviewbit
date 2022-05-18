public class Solution {

    public int binarySearch(ArrayList<Integer> A, int toFind) {
        int low = 0;
        int high = A.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == toFind)
                return 1;
            else if (A.get(mid) < toFind)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return 0;
    }

    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int toFind) {
        int rowLow = 0;
        int rowHigh = A.size() - 1;
        int answer = 0;

        int n = A.size();
        int m = A.get(0).size();

        while (rowLow <= rowHigh) {
            int mid = rowLow + (rowHigh - rowLow) / 2;
            if (A.get(mid).get(0) <= toFind && toFind <= A.get(mid).get(m - 1)) {
                // search this row
                answer = binarySearch(A.get(mid), toFind);
                if (answer == 1)
                    return 1;
                else
                    rowLow += 1;
            } else if (A.get(mid).get(0) < toFind)
                rowLow = mid + 1;
            else
                rowHigh = mid - 1;
        }

        return 0;
    }
}
