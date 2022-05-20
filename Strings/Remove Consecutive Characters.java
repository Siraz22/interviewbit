public class Solution {
    public String solve(String A, int B) {
        String answer = "";
        int charCount = 1;

        for (int i = 0; i < A.length(); ++i) {

            // count through duplicates to reach the rightmost place - from noble integer
            // question
            if (i < A.length() - 1 && A.charAt(i) == A.charAt(i + 1)) {
                charCount += 1;
                continue;
            }

            if (charCount == B) {
                charCount = 1;
                continue;
            } else {
                for (int j = 0; j < charCount; ++j) {
                    answer += A.charAt(i);
                }
            }
            charCount = 1;
        }

        return answer;
    }
}
