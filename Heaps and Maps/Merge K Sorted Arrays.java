import java.util.*;

public class Solution {

    // "The more things change, the more they stay the same."
    // - Resident Evil 6

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (ArrayList<Integer> row : A) {
            for (int elem : row) {
                pq.offer(elem);
            }
        }
        while (pq.size() > 0) {
            answer.add(pq.poll());
        }
        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String arrStr = "1,5,3,4";
        String[] arr = arrStr.split(",");
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; ++i) {
            arrList.add(Integer.parseInt(arr[i]));
        }

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < arrList.size(); ++i) {
            Collections.shuffle(arrList);
            matrix.add(arrList);
        }

        Object answer = solution.solve(matrix);
        System.out.println(answer.toString());
    }
}