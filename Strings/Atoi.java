public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int atoi(final String A) {

        String processed = A;
        // preprocessing : remove trailing white spaces
        while (processed.charAt(0) == ' ') {
            processed = processed.substring(1, processed.length());
        }

        // System.out.println(processed);

        int signPresent = 1;
        String number = "";

        for (int i = 0; i < processed.length(); ++i) {
            if (i == 0 && (processed.charAt(0) == '+' || processed.charAt(0) == '-')) {
                signPresent = processed.charAt(0) == '+' ? 1 : -1;
                number += processed.charAt(i);
                continue;
            }

            char ch = processed.charAt(i);
            if (ch >= '0' && ch <= '9') {
                number += ch;
            } else {
                // current character is not a number
                break;
            }
        }

        // System.out.println("number is "+number);
        int answer = 0;

        try {
            answer = Integer.parseInt(number);
        } catch (Exception e) {
            if (number.equals(""))
                return 0;
            else if (number.equals("-") || number.equals("+"))
                return 0;
            else
                return signPresent == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return answer;

    }
}
