public class Solution {

    // "You don't look different
    // But you have changed"
    // - I'm looking through you, The Beatles

    public int solve(ArrayList<ArrayList<Integer>> A) {

        boolean[][] blue_visited = new boolean[A.size()][A.get(0).size()];
        boolean[][] red_visited = new boolean[A.size()][A.get(0).size()];

        // traverse topmost and bottomost matrix
        for (int i = 0; i < A.get(0).size(); ++i) {
            graph_dfs(0, i, A, blue_visited);
            graph_dfs(A.size() - 1, i, A, red_visited);
        }

        // leftmost and rightmost
        for (int i = 0; i < A.size(); ++i) {
            graph_dfs(i, 0, A, blue_visited);
            graph_dfs(i, A.get(0).size() - 1, A, red_visited);
        }

        int commonCount = 0;
        for (int i = 0; i < A.size(); ++i) {
            for (int j = 0; j < A.get(0).size(); ++j) {
                if (red_visited[i][j] == true && blue_visited[i][j] == true) {
                    commonCount += 1;
                }
            }
        }

        return commonCount;

    }

    public void graph_dfs(int row, int col, ArrayList<ArrayList<Integer>> A, boolean[][] visited) {
        // Base condition - index out of range
        if (row < 0 || row >= A.size() || col >= A.get(0).size() || col < 0)
            return;
        // Base condition - already visited
        if (visited[row][col] == true)
            return;

        // System.out.println(row+","+col);

        visited[row][col] = true;
        int originNum = A.get(row).get(col);
        // flow water outwards ie, up, down, left and right
        if (row - 1 >= 0 && A.get(row - 1).get(col) >= originNum)
            graph_dfs(row - 1, col, A, visited);
        if (row + 1 < A.size() && A.get(row + 1).get(col) >= originNum)
            graph_dfs(row + 1, col, A, visited);
        if (col - 1 >= 0 && A.get(row).get(col - 1) >= originNum)
            graph_dfs(row, col - 1, A, visited);
        if (col + 1 < A.get(0).size() && A.get(row).get(col + 1) >= originNum)
            graph_dfs(row, col + 1, A, visited);

        return;
    }
}
