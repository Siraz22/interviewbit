public class Solution {
    public int firstMissingPositive(ArrayList<Integer> A) {

        for (int i = 0; i < A.size(); ++i) {

            int number = A.get(i);
            int expectedIndex = number - 1;

            // System.out.println(i);
            while (A.get(i) <= A.size() && A.get(i) > 0 && A.get(expectedIndex) != number) {

                // System.out.println(i+"=>"+A.toString());
                int swapIndex = number - 1;

                // check if the index to be swapped with already has a correct element, ie, to
                // handle
                // duplicate values in the ArrayList
                if (A.get(swapIndex) == number) {
                    break;
                } else {
                    // swap
                    int temp = A.get(swapIndex);
                    A.set(swapIndex, number);
                    A.set(i, temp);
                }

                // IMPORTANT : since number & expectedIndex depends on i, update it
                // as anything inside while loop would be using old value of number,
                // but after swap, the number at the same ith place changes
                number = A.get(i);
                expectedIndex = number - 1;

            }
        }

        // System.out.println(A.toString());

        for (int i = 0; i < A.size(); ++i) {
            if (i + 1 != A.get(i))
                return i + 1;
        }

        // iterated the whole array, didn't find any wrong index
        return A.size() + 1;
    }
}
