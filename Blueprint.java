import java.util.*;

class Solution {
    public int functionName() {
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String arrStr = "1,2,3,4";
        String[] arr = arrStr.split(",");
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; ++i) {
            arrList.add(Integer.parseInt(arr[i]));
        }
        Object answer = solution.functionName();
        System.out.println(answer.toString());
    }
}