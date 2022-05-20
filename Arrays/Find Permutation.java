public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findPerm(final String A, int B) {

        // Pattern seen
        // I I D D I D 'D' - last letter follows the previous letter
        // 1 2 7 6 3 5 4

        String query = A + A.charAt(A.length() - 1);
        int front = 1;
        int back = B;
        ArrayList<Integer> answer = new ArrayList<Integer>();

        for (int i = 0; i < query.length(); ++i) {
            char ch = query.charAt(i);
            if (ch == 'I') {
                answer.add(front);
                front++;
            } else {
                answer.add(back);
                back--;
            }
        }

        return answer;

    }
}
