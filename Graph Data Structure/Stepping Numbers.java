import java.util.*;

public class Solution {

    // "Though I know that evening's empire has returned into sand
    // Vanished from my hand
    // Left me blindly here to stand, but still not sleeping"
    // - Bob Dylan, Mr Tambourine Man

    public void construct(int rootNum, ArrayList<Integer> answer, int A, int B) {
        if (rootNum >= A && rootNum <= B) {
            answer.add(rootNum);
        }

        if (rootNum > B)
            return;

        int lastDigit = rootNum % 10;

        // decrement number added
        if (lastDigit - 1 >= 0) {
            int decRootNumber = rootNum * 10 + (lastDigit - 1);
            construct(decRootNumber, answer, A, B);
        }

        // increment number added
        if (lastDigit + 1 <= 9) {
            int incRootNumber = rootNum * 10 + (lastDigit + 1);
            construct(incRootNumber, answer, A, B);
        }

    }

    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        // Corner case
        if (A == 0) {
            answer.add(0);
        }

        for (int i = 1; i <= 9; ++i) {
            construct(i, answer, A, B);
        }

        Collections.sort(answer);
        return answer;
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

        Object answer = solution.stepnum(100, 300);
        System.out.println(answer.toString());
    }
}