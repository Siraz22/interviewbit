public class Solution {

    // "Big Brother, coming for overwatch."
    // - Olivier "Lion" Flament, Rainbow Six Siege

    public int solve(ArrayList<Integer> A, int B) {

        int answer = 0;

        for (int i = 0; i < A.size(); ++i) {
            int bulbStatus = A.get(i);

            // Case 1 : bulb is faulty, check B-1 steps ahead to see if there is a light
            // IMP : and if no bulb on right are found, then check back till i-B+1;
            if (bulbStatus == 0) {
                int rightmost = Math.min(A.size() - 1, i + B - 1);

                int workingBulbFoundIndex = -1;
                for (int j = rightmost; j >= Math.max(0, i - B + 1); --j) {
                    if (A.get(j) == 1) {
                        workingBulbFoundIndex = j;
                        break;
                    }
                }
                if (workingBulbFoundIndex != -1) {
                    answer++;
                    i = (workingBulbFoundIndex + B - 1);
                } else {
                    return -1; // the current index will never get lighted up
                }
            }

            // 1, 0, 1, 1, 1, 0, 0, 1
            // Case 2 : bulb is working, check in front if there is another working bulb
            // which covers the same area the current bulb does
            if (bulbStatus == 1) {
                int rightmost = Math.min(A.size() - 1, i + B - 1);
                int workingBulbFoundIndex = -1;
                for (int j = rightmost; j > i; --j) {
                    if (A.get(j) == 1) {
                        workingBulbFoundIndex = j;
                        break;
                    }
                }
                if (workingBulbFoundIndex != -1) {
                    // the later bulb can light up the same area too. Choose that to reduce number
                    // of bulbs
                    i = (workingBulbFoundIndex + B - 1);
                    answer++;
                } else {
                    answer++;
                }
            }

        }

        return answer;

    }
}
