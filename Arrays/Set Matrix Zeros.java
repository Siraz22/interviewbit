public class Solution {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {

        ArrayList<Integer> helper = new ArrayList<Integer>();
        for (int i = 0; i < a.get(0).size(); ++i) {
            helper.add(1);
        }

        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

        // update the helper first

        for (int i = 0; i < a.size(); ++i) {
            for (int j = 0; j < a.get(0).size(); ++j) {
                if (a.get(i).get(j) == 0) {
                    helper.set(j, 0);
                    hashmap.put(i, 1);
                }
            }
        }

        for (int i = 0; i < a.size(); ++i) {

            if (hashmap.containsKey(i)) {
                // entire row will be zero
                for (int j = 0; j < a.get(0).size(); ++j) {
                    a.get(i).set(j, 0);
                }
            } else {
                for (int j = 0; j < a.get(0).size(); ++j) {
                    a.get(i).set(j, helper.get(j) * a.get(i).get(j));
                }
            }
        }

    }
}
