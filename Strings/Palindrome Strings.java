public class Solution {
    public int isPalindrome(String A) {

        for (int front = 0, back = A.length() - 1; front <= back;) {

            char frontChar = Character.toLowerCase(A.charAt(front));
            char backChar = Character.toLowerCase(A.charAt(back));

            if (!Character.isLetterOrDigit(frontChar)) {
                front++;
                continue;
            }
            if (!Character.isLetterOrDigit(backChar)) {
                back--;
                continue;
            }

            if (frontChar != backChar)
                return 0;
            front++;
            back--;

        }
        return 1;
    }
}
