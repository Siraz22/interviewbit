public class Solution {
    public ArrayList<Integer> flip(String A) {

        int tempSum = 0;

        ArrayList<Integer> aux = new ArrayList<Integer>();
        for (int i = 0; i < A.length(); ++i) {
            int num = A.charAt(i);
            if (num == '0') {
                aux.add(1);
                tempSum -= 1;
            } else {
                aux.add(-1);
                tempSum += 1;
            }
        }

        // corner case 1 : all numbers are 1
        if (tempSum == A.length())
            return new ArrayList<Integer>();
        if (tempSum == -A.length()) {
            ArrayList<Integer> sol = new ArrayList<Integer>();
            sol.add(1);
            sol.add(A.length());
            return sol;
        }

        int currSum = 0;
        int max = Integer.MIN_VALUE;

        int newStartIndex = 0;
        int startIndex = 0;
        int endIndex = -1;

        for (int i = 0; i < A.length(); ++i) {

            currSum += aux.get(i);

            if (currSum > max) {
                startIndex = newStartIndex;
                endIndex = i;

                max = currSum;
            }

            if (currSum < 0) {
                newStartIndex = i + 1; // ignore the current number

                currSum = 0;
            }

        }

        // System.out.println(startIndex+","+endIndex);

        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(startIndex + 1);
        answer.add(endIndex + 1);
        return answer;

    }
}
