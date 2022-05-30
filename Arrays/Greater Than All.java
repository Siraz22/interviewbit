public class Solution {
    public int solve(ArrayList<Integer> A) {
        int maxSoFar = Integer.MIN_VALUE;
        int answer = 0;

        for (int i = 0; i < A.size(); ++i) {
            if (A.get(i) > maxSoFar)
                answer++;
            maxSoFar = Math.max(A.get(i), maxSoFar);
        }

        return answer;
    }
}
