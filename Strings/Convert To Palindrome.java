public class Solution {

    public int isPalindrome(String A, int pos) {
        String newString = A.substring(0, pos) + A.substring(pos + 1, A.length());
        for (int front = 0, back = newString.length() - 1; front <= back; ++front, --back) {
            if (newString.charAt(front) != newString.charAt(back)) {
                return 0;
            }
        }
        return 1;
    }

    public int solve(String A) {
        int front = 0;
        int back = A.length() - 1;
        int count = 0;

        while (front <= back) {
            char frontChar = A.charAt(front);
            char backChar = A.charAt(back);

            if (frontChar == backChar) {
                front++;
                back--;
            } else {
                if (count > 0)
                    return 0;
                count++;

                if (isPalindrome(A, front) == 1)
                    front++;
                else if (isPalindrome(A, back) == 1)
                    back--;
                else
                    return 0;
            }
        }

        return 1;
    }
}
