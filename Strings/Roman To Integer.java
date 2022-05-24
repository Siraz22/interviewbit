public class Solution {

    public int findIndex(String[] roman, String toFind) {
        for (int i = 0; i < roman.length; ++i) {
            if (toFind.equals(roman[i]))
                return i;
        }
        return -1;
    }

    public int romanToInt(String A) {
        int[] numbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int answer = 0;

        for (int i = A.length() - 1; i >= 0; --i) {

            // System.out.println("Loop "+i);
            char ch = A.charAt(i);

            // sample - for IX, 'I' is at higer index than 'X'
            if (i > 0 && findIndex(roman, A.substring(i - 1, i)) > findIndex(roman, A.substring(i, i + 1))) {
                // System.out.println("Looking for "+A.substring(i-1,i+1));
                int index = findIndex(roman, A.substring(i - 1, i + 1));
                answer += numbers[index];
                i -= 1; // one more iteration down as 2 characters have been processed
            } else {
                // System.out.println("Looking for "+A.substring(i,i+1));
                int index = findIndex(roman, A.substring(i, i + 1));
                answer += numbers[index];
            }
        }

        return answer;
    }
}
