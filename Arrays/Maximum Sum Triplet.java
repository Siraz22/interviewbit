public class Solution {

    // "The best solution to a problem is usually the easiest one!"
    // - 'Portal 2'.

    public int solve(ArrayList<Integer> A) {

        ArrayList<Integer> rightMax = new ArrayList<Integer>(A);
        int max = A.get(A.size() - 1);

        for (int i = A.size() - 2; i >= 0; --i) {
            max = Math.max(max, A.get(i));
            rightMax.set(i, max);
        }

        // System.out.println(rightMax.toString());

        TreeSet<Integer> heap = new TreeSet<Integer>();
        heap.add(A.get(0));

        int answer = Integer.MIN_VALUE;

        for (int i = 1; i < A.size() - 1; ++i) {
            Integer left = heap.lower(A.get(i));
            int right = rightMax.get(i);

            if (left != null && right > A.get(i)) {
                answer = Math.max(answer, A.get(i) + right + left);
            }
            heap.add(A.get(i));
        }

        return answer;

    }
}
