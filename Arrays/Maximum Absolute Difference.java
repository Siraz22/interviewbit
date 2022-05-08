public class Solution {

    // "The future depends on the past, even if we don’t get to see it."
    // - Riebeck, at Brittle Hollow, OUTER WILDS

    public int maxArr(ArrayList<Integer> A) {
        int answer = Integer.MIN_VALUE;

        // |A[i]-A[j]| + |i-j|, upon breaking are simplified to two cases =>
        // 1) A[i]+i - (A[j]+j)
        // 2) A[j]-j - (A[i]-i)

        int min1 = Integer.MAX_VALUE; // A[j]+j
        int max1 = Integer.MIN_VALUE; // A[i]+i
        int min2 = Integer.MAX_VALUE; // A[i]-i
        int max2 = Integer.MIN_VALUE; // A[j]-j

        for (int i = 0; i < A.size(); ++i) {
            max1 = Math.max(max1, A.get(i) + i);
            min1 = Math.min(min1, A.get(i) + i);
            max2 = Math.max(max2, A.get(i) - i);
            min2 = Math.min(min2, A.get(i) - i);
        }

        return Math.max((max1 - min1), (max2 - min2));
    }
}
