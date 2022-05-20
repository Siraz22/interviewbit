public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int repeatedNumber(final List<Integer> A) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            if (set.contains(A.get(i)))
                return A.get(i);
            else {
                set.add(A.get(i));
            }
        }
        return -1;
    }
}