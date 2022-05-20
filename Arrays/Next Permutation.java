public class Solution {
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {

        ArrayList<Integer> answer = new ArrayList<Integer>();
        int N = A.size();

        int breakIndex = -1;

        for (int i = A.size() - 2; i >= 0; --i) {
            if (A.get(i) < A.get(i + 1)) {
                breakIndex = i;
                break;
            }
        }

        if (breakIndex == -1) {
            // next greater permutation doesn't exist
            Collections.reverse(A);
            return A;
        }

        // replace breakIndex with rightmost first greater element
        for (int i = A.size() - 1; i >= 0; --i) {
            if (A.get(i) > A.get(breakIndex)) {
                int temp = A.get(i);
                A.set(i, A.get(breakIndex));
                A.set(breakIndex, temp);
                break;
            }
        }

        for (int i = breakIndex + 1, j = A.size() - 1; i < j; ++i, --j) {
            int temp = A.get(i);
            A.set(i, A.get(j));
            A.set(j, temp);
        }

        return A;

    }
}
