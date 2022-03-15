import java.util.*;

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {

        int minWindow = Integer.MAX_VALUE;
        int currWindow = 0;
        int sum = 0;

        for (int i = 0; i < A.size() - B; ++i) {
            sum += A.get(i);
            currWindow += A.get(i);
        }

        minWindow = Math.min(minWindow, currWindow);

        for (int i = A.size() - B; i < A.size(); ++i) {
            sum += A.get(i);
            currWindow -= A.get(i - (A.size() - B)); // MARK
            currWindow += A.get(i);
            minWindow = Math.min(minWindow, currWindow);
        }

        return sum - minWindow;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String arrStr = "5,-2,3,1,2";

        String[] arr = arrStr.split(",");
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; ++i) {
            arrList.add(Integer.parseInt(arr[i]));
        }

        // ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        // for (int i = 0; i < arrList.size(); ++i) {
        // Collections.shuffle(arrList);
        // matrix.add(arrList);
        // }

        Object answer = solution.solve(arrList, 3);
        System.out.println(answer.toString());
    }
}