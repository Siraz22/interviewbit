public class Solution {

    // "Insanity is doing the exact over and over again expecting things to change."
    // - Far Cry 3

    public int solve(int N, ArrayList<Integer> A) {
        int total = 0;

        for (int i = 0; i < A.size(); ++i) {
            total += A.get(i);
        }

        if (total % 3 != 0)
            return 0;

        int onethirdcount = 0;
        int answer = 0;
        int cummulativeSum = 0;

        for (int i = 0; i < A.size(); ++i) {
            cummulativeSum += A.get(i);

            // we have this statement of if first to avoid the corner case when total = 0
            if (cummulativeSum == (total * (2.0 / 3)) && i >= 1 && i <= A.size() - 2) {
                answer += onethirdcount;
            }

            if (cummulativeSum == total / 3) {
                onethirdcount += 1;
            }

        }

        return answer;

    }
}
