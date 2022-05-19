public class Solution {
    public int perfectPeak(ArrayList<Integer> A) {

        ArrayList<Integer> leftMax = new ArrayList<Integer>();
        ArrayList<Integer> rightMin = new ArrayList<Integer>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); ++i) {
            int num = A.get(i);
            if (num > max) {
                leftMax.add(num);
                max = num;
            } else {
                leftMax.add(max);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = A.size() - 1; i > -1; --i) {
            int num = A.get(i);
            if (num < min) {
                rightMin.add(num);
                min = num;
            } else {
                rightMin.add(min);
            }
        }
        Collections.reverse(rightMin);

        // 0th and n-1 don't contribute
        for (int i = 1; i < A.size() - 1; ++i) {
            int num = A.get(i);

            if (leftMax.get(i - 1) < num && num < rightMin.get(i + 1)) {
                // System.out.println(leftMax.get(i-1)+" "+num+" "+rightMin.get(i+1));
                return 1;
            }
        }

        return 0;
    }
}
