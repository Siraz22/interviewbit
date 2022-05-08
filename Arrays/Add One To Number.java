public class Solution {

    // "And I feel the light for the very first time
    // Not anybody knows that I am lucky to be alive"
    // - AURORA, Lucky

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        ArrayList<Integer> reverse = new ArrayList<Integer>();
        for (int i = A.size() - 1; i >= 0; --i) {
            reverse.add(A.get(i));
        }

        // 1,2,3 -> 3,2,1
        // 0,1,2,3 -> 3,2,1,0

        int carry = 1; // because we have to add one at the start
        int remainder = 0;
        for (int i = 0; i < reverse.size(); ++i) {

            int sum = reverse.get(i) + carry;
            carry = (sum) / 10;
            remainder = sum % 10;

            reverse.set(i, remainder);
        }

        // addition is over, check if carry is still 1
        if (carry == 1) {
            reverse.add(1);
        }

        // removing trailing zeros from reverse ArrayList
        while (reverse.get(reverse.size() - 1) == 0) {
            reverse.remove(reverse.size() - 1);
        }

        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int i = reverse.size() - 1; i >= 0; --i) {
            answer.add(reverse.get(i));
        }

        return answer;

    }

}
