import java.util.*;

public class Solution {

    // "And I think it's gonna be a long, long time
    // 'Til touchdown brings me 'round again to find
    // I'm not the man they think I am at home"
    // - Elton John, Rocketman

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int elem : A) {
            pq.add(elem);
        }
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int i = 0; i < B; ++i) {
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
        Object answer = solution.solve(arrList, 2);
        System.out.println(answer.toString());
    }
}