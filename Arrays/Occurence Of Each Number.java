public class Solution {
    public ArrayList<Integer> findOccurences(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.size(); ++i) {
            if (map.containsKey(A.get(i))) {
                map.put(A.get(i), map.get(A.get(i)) + 1);
            } else {
                map.put(A.get(i), 1);
            }
        }

        ArrayList<ArrayList<Integer>> aux = new ArrayList<ArrayList<Integer>>();

        for (Map.Entry elem : map.entrySet()) {
            int key = (int) elem.getKey();
            int val = (int) elem.getValue();
            ArrayList<Integer> temp = new ArrayList();
            temp.add(key);
            temp.add(val);
            aux.add(temp);
        }

        Collections.sort(aux, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0) - b.get(0);
            }
        });

        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int i = 0; i < aux.size(); ++i) {
            answer.add(aux.get(i).get(1));
        }
        return answer;
    }
}
