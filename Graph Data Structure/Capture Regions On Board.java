import java.util.*;

public class Solution {

    // "You say you don't know
    // You won't know until you begin"
    // - Eddie Van Halen (1955-2020), Jump

    public void traverseGraph(int x, int y, HashMap<String, Integer> visited,
            ArrayList<ArrayList<Character>> matrix) {

        // base condition, check if coordinate are okay
        if (!(x >= 0 && x <= matrix.size() - 1 && y >= 0 && y <= matrix.get(0).size() - 1)) {
            // out of bounds coordinate
            return;
        }

        // base condition 2 : it is X and not O
        if (matrix.get(x).get(y) == 'X') {
            return;
        }

        String coordinate = x + "," + y;
        if (visited.containsKey(coordinate))
            return;

        if (matrix.get(x).get(y) == 'O') {
            // this O is not surrounded by X on all sides
            matrix.get(x).set(y, 'A');
        }

        // add current coordinate to visited
        visited.put(coordinate, 1);

        // go up, right, down and left
        traverseGraph(x, y + 1, visited, matrix);
        traverseGraph(x + 1, y, visited, matrix);
        traverseGraph(x, y - 1, visited, matrix);
        traverseGraph(x - 1, y, visited, matrix);

        return;
    }

    public void solve(ArrayList<ArrayList<Character>> matrix) {

        Queue<ArrayList<Integer>> queue = new LinkedList<ArrayList<Integer>>();
        HashMap<String, Integer> visited = new HashMap<String, Integer>();

        // going around boundary
        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = 0; j < matrix.get(0).size(); ++j) {

                if (i == 0 || i == matrix.size() - 1) {
                    if (matrix.get(i).get(j) == 'O') {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(i);
                        temp.add(j);
                        queue.add(temp);
                    }

                } else {
                    // only first and last index will be explored
                    if (matrix.get(i).get(0) == 'O') {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(i);
                        temp.add(j);
                        queue.add(temp);
                    }

                    if (matrix.get(i).get(matrix.get(0).size() - 1) == 'O') {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(i);
                        temp.add(matrix.get(0).size() - 1);
                        queue.add(temp);
                    }
                    break;
                }

            }
        }

        // do a graph traversal on the queue
        while (queue.size() > 0) {
            traverseGraph(queue.peek().get(0), queue.peek().get(1), visited, matrix);
            queue.remove();
        }

        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = 0; j < matrix.get(0).size(); ++j) {
                if (matrix.get(i).get(j) == 'O') {
                    matrix.get(i).set(j, 'X');
                } else if (matrix.get(i).get(j) == 'A') {
                    matrix.get(i).set(j, 'O');
                }
            }
        }

    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ArrayList<ArrayList<Character>> matrix = new ArrayList<ArrayList<Character>>();

        String[] A = { "XOXXXXOOXX", "XOOOOXOOXX", "OXXOOXXXOO", "OXOXOOOXXO", "OXOOXXOOXX", "OXXXOXXOXO",
                "OOXXXXOXOO" };

        for (int i = 0; i < A.length; ++i) {
            ArrayList<Character> temp = new ArrayList<>();
            for (int j = 0; j < A[0].length(); ++j) {
                temp.add(A[i].charAt(j));
            }
            matrix.add(temp);
        }

        System.out.println("Before");
        for (int i = 0; i < matrix.size(); ++i) {
            System.out.println(matrix.get(i).toString());
        }

        solution.solve(matrix);

        System.out.println("Error");
        // System.out.println(matrix.toString());
        for (int i = 0; i < matrix.size(); ++i) {
            System.out.println(matrix.get(i).toString());
        }
    }
}