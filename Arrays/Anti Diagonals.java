public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();

        // upper col
        for (int col = 0; col < A.get(0).size(); ++col) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int movingRow = 0; // go in ++
            int movingCol = col; // go in --
            while (movingCol >= 0 && movingRow < A.get(0).size()) {
                int val = A.get(movingRow).get(movingCol);
                temp.add(val);
                movingCol--;
                movingRow++;
            }
            answer.add(temp);
        }

        // end row
        for (int row = 1; row < A.size(); ++row) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int movingRow = row; // goes in ++;
            int movingCol = A.size() - 1; // goes in --
            while (movingCol >= 0 && movingRow < A.get(0).size()) {
                int val = A.get(movingRow).get(movingCol);
                temp.add(val);
                movingCol--;
                movingRow++;
            }
            answer.add(temp);
        }

        return answer;
    }
}
