public class Solution {
    public String countAndSay(int A) {
        String number = "1";
        String temp = "";

        for (int i = 1; i < A; ++i) {

            int count = 1;

            for (int j = 0; j < number.length(); ++j) {

                // count duplicates - trick from noble integer question
                if (j < number.length() - 1 && number.charAt(j) == number.charAt(j + 1)) {
                    count += 1;
                    continue;
                }

                // next char will be different from current one
                char currentNumber = number.charAt(j);
                temp += count;
                temp += currentNumber;
                count = 1; // reset count for next char
            }
            number = temp;
            temp = "";
        }
        return number;
    }
}
