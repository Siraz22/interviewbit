public class Solution {

    // "There is nowhere for you to hide
    // The hunter's moon is shining"
    // - AURORA, Running with the Wolves

    public int maxSubArray(final List<Integer> A) {

        int max = Integer.MIN_VALUE;
        int currSum = 0;

        int newStartIndex = 0;
        int startIndex = 0;
        int endIndex = -1;

        for (int i = 0; i < A.size(); ++i) {
            currSum += A.get(i);

            if (currSum > max) {
                max = currSum;

                startIndex = newStartIndex;
                endIndex = i;
            }

            if (currSum < 0) {
                currSum = 0;

                newStartIndex = i + 1;
            }
        }

        // System.out.println("left is "+start +", right is "+end);
        // return max;

        int answer = 0;
        for (int i = startIndex; i <= endIndex; ++i) {
            answer += A.get(i);
        }
        return answer;
    }
}
