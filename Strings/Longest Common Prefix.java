public class Solution {
    public String longestCommonPrefix(ArrayList<String> A) {
        String answer = "";
        int minStringLength = Integer.MAX_VALUE;

        for (int i = 0; i < A.size(); ++i) {
            minStringLength = Math.min(minStringLength, A.get(i).length());
        }

        for (int charIter = 0; charIter < minStringLength; ++charIter) {

            char currentChar = A.get(0).charAt(charIter);

            for (int i = 1; i < A.size(); ++i) {
                if (currentChar != A.get(i).charAt(charIter))
                    return answer;
            }

            // loop completed
            answer += currentChar;
        }

        return answer;
    }
}
