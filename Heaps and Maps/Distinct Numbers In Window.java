import java.util.*;

public class Solution {

    // "There is nowhere for you to hide
    // The hunter's moon is shining"
    // - Aurora, Running with the Wolves

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < B; ++i) {
            int num = A.get(i);
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(map.size());

        int removeIndex = 0;
        for (int i = B; i < A.size(); ++i) {
            int num = A.get(i);
            int toRemove = A.get(removeIndex);

            // We will decrement freq of toRemove by 1 from map
            if (map.containsKey(toRemove)) {
                map.put(toRemove, (map.get(toRemove) - 1));

                if (map.get(toRemove) == 0) {
                    map.remove(toRemove);
                }
            }

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            answer.add(map.size());
            removeIndex++;
        }

        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String arrStr = "31, 51, 31, 51, 31, 31, 31, 31, 31, 31, 51, 31, 31";
        String[] arr = arrStr.split(", ");
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; ++i) {
            arrList.add(Integer.parseInt(arr[i]));
        }

        // ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        // for (int i = 0; i < arrList.size(); ++i) {
        // Collections.shuffle(arrList);
        // matrix.add(arrList);
        // }

        Object answer = solution.dNums(arrList, 3);
        System.out.println(answer.toString());
    }
}