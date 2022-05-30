public class Solution {
    public int firstMissingPositive(ArrayList<Integer> A) {

        for (int i = 0; i < A.size(); ++i) {
            int num = A.get(i);
            int expectedIndex = num - 1;

            // out of bounds for our algorithm
            if (A.get(i) <= 0 || A.get(i) > A.size())
                continue;

            if (A.get(expectedIndex) == num) {
                continue; // case of duplicate, hence leave
            } else {
                while (A.get(i) > 0 && A.get(i) <= A.size() && A.get(i) != (int) A.get(A.get(i) - 1)) {
                    // keep swapping
                    int num1 = A.get(i), num2 = A.get(A.get(i) - 1);
                    A.set(i, num2);
                    A.set(num1 - 1, num1);
                }
            }
        }

        for (int i = 0; i < A.size(); ++i) {
            if (A.get(i) != i + 1)
                return i + 1;
        }
        return A.size() + 1;
    }
}
