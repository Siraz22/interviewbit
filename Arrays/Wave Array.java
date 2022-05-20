public class Solution {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        ArrayList<Integer> answer = new ArrayList<Integer>(A);
        Collections.sort(answer);

        for (int i = 0; i < A.size(); i += 2) {
            if (i + 1 < A.size()) {
                int temp = answer.get(i);
                answer.set(i, answer.get(i + 1));
                answer.set(i + 1, temp);
            }

            // System.out.println("i="+i+","+answer.toString());
        }

        return answer;
    }
}
