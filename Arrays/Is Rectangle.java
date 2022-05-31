public class Solution {
    public int solve(int A, int B, int C, int D) {
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        hashmap.put(A, 1);

        ArrayList<Integer> sides = new ArrayList<Integer>();
        sides.add(B);
        sides.add(C);
        sides.add(D);

        for (int num : sides) {
            if (hashmap.containsKey(num)) {
                hashmap.put(num, hashmap.get(num) + 1);
            } else {
                hashmap.put(num, 1);
            }
        }

        for (Map.Entry element : hashmap.entrySet()) {
            if ((int) element.getValue() != 2)
                return 0;
        }
        return 1;
    }
}
