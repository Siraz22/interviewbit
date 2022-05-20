public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {

        // Transpose -> Mirror on diagonal
        for (int i = 0; i < a.size(); ++i) {
            for (int j = 0; j < a.size(); ++j) {

                // if j is strictly greater than i
                if (j > i) {
                    int temp = a.get(i).get(j);
                    a.get(i).set(j, a.get(j).get(i));
                    a.get(j).set(i, temp);
                }
            }
        }

        // Reversing every row
        for (int i = 0; i < a.size(); ++i) {

            // only swap till midway
            int start = 0;
            int end = a.size() - 1;

            while (start <= end) {

                int temp = a.get(i).get(start);
                a.get(i).set(start, a.get(i).get(end));
                a.get(i).set(end, temp);

                start++;
                end--;
            }

        }

    }
}