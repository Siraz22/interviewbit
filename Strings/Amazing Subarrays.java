public class Solution {
    public int solve(String A) {
        int count = 0;

        for (int i = 0; i < A.length(); ++i) {
            char ch = Character.toLowerCase(A.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count += (A.length() - i) % 10003;
            }
        }

        return count % 10003;
    }
}
