public class Solution {

    public int binarySearchDesc(ArrayList<Integer> A, int low, int high, int toFind) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == toFind)
                return mid;
            else if (A.get(mid) < toFind) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchAscending(ArrayList<Integer> A, int low, int high, int toFind) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == toFind)
                return mid;
            else if (A.get(mid) < toFind) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int solve(ArrayList<Integer> A, int B) {
        int low = 0;
        int high = A.size() - 1;

        int separatorIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int next = (mid + 1) % A.size();
            int prev = (mid + A.size() - 1) % A.size();

            // case 1 : 4 5 '7' 2 1
            if (A.get(prev) <= A.get(mid) && A.get(mid) >= A.get(next)) {
                separatorIndex = mid;
                break;
            }
            // case 2 : 3 4 '5' 6 2
            else if (A.get(prev) <= A.get(mid) && A.get(mid) <= A.get(next)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // System.out.println("separator "+separatorIndex);

        int answer = binarySearchAscending(A, 0, separatorIndex, B);
        if (answer == -1)
            answer = binarySearchDesc(A, separatorIndex + 1, A.size() - 1, B);
        return answer;

    }
}
