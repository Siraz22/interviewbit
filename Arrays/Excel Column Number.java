public class Solution {
    public int titleToNumber(String A) {
        int answer = 0;

        for (int i = A.length() - 1, placePower = 0; i >= 0; --i, ++placePower) {
            Character ch = A.charAt(i);
            answer += Math.pow(26, placePower) * (ch - 64);
        }

        return answer;
    }
}
