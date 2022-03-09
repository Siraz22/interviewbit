import java.util.*;

public class Solution {

    // "There was a boy
    // A very strange enchanted boy
    // They say he wandered very far, very far
    // Over land and sea"
    // - Nat King Cole, Nature Boy

    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        pq.addAll(A);
        int costSum = 0;
        for (int i = 0; i < B; ++i) {
            int temp = pq.poll();
            costSum += temp;
            temp -= 1;
            pq.add(temp);
        }
        return costSum;
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
        Object answer = solution.solve(arrList, 2);
        System.out.println(answer.toString());
    }
}