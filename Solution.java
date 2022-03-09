import java.util.*;

public class Solution {
    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int elem : B) {
            pq.add(elem);
        }
        long answer = 0;
        for (int i = 0; i < A; ++i) {
            int temp = pq.poll();
            answer = (answer + temp) % 1000000007;
            temp = (int) Math.floor(temp / 2);
            pq.offer(temp);
        }
        return (int) answer % 1000000007;
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

        Object answer = solution.nchoc(3, arrList);
        System.out.println(answer.toString());
    }
}