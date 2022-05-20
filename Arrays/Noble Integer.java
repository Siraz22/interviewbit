public class Solution {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);

        // [1,2,3,3]
        // [2,5,6]

        for (int i = 1; i < A.size(); ++i) {
            if (A.get(i - 1) == A.get(i))
                continue; // skip duplicates
            else {
                // prev number is different than current
                if (A.get(i - 1) == A.size() - i) {
                    return 1;
                }
            }
        }

        // Corner case : when last number is 0, there are 0 numbers greater than it.
        if (A.get(A.size() - 1) == 0)
            return 1;

        return -1;
    }
}
