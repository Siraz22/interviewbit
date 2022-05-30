public class Solution {
    public ArrayList<Integer> addArrays(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.reverse(A);
        Collections.reverse(B);

        ArrayList<Integer> answer = new ArrayList<Integer>();

        int carry = 0;

        for (int i = Math.min(A.size(), B.size()) - 1; i < Math.max(A.size(), B.size()); ++i) {
            if (A.size() < B.size()) {
                // fill trailiing zeroes
                A.add(0);
            } else {
                B.add(0);
            }
        }

        for (int i = 0; i < A.size(); ++i) {
            int sum = A.get(i) + B.get(i) + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            answer.add(remainder);
        }

        if (carry == 1) {
            answer.add(carry);
        }

        // remove trailiing zeroes
        while (answer.get(answer.size() - 1) == 0) {
            answer.remove(answer.size() - 1);
        }

        Collections.reverse(answer);

        return answer;
    }
}
