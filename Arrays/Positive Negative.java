public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int positive = 0;
        int negative = 0;
        for (int i = 0; i < A.size(); ++i) {
            if (A.get(i) > 0)
                positive++;
            else if (A.get(i) < 0)
                negative++;
        }

        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(positive);
        answer.add(negative);

        return answer;
    }
}
