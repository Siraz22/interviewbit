public class Solution {
    public int solve(ArrayList<Integer> A, int B) {

        // "I can't recall last time
        // I opened my eyes to see the world as beautiful"
        // - AURORA, Warrior

        int sizeOfSubArr = A.size() - B;
        int sum = 0;
        int total = 0;

        for (int i = 0; i < sizeOfSubArr; ++i) {
            sum += A.get(i);
        }

        total = sum;
        int minSubarr = sum;

        for (int i = sizeOfSubArr, frontIter = 0; i < A.size(); ++i, ++frontIter) {

            sum -= A.get(frontIter); // starts from 0 then 1,2,3... so on
            sum += A.get(i);
            total += A.get(i);

            if (sum < minSubarr) {
                minSubarr = sum;
            }
        }

        return total - minSubarr;
    }
}
