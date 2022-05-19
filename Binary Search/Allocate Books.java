public class Solution {
    public int books(ArrayList<Integer> A, int studentsAlloted) {

        if (studentsAlloted > A.size()) {
            // all students can't get one book each
            return -1;
        }

        int low = 0;
        int high = 0;
        for (int elem : A) {
            high += elem;
        }

        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int totalPages = 0;
            int studentCount = 1;

            for (int i = 0; i < A.size(); ++i) {
                int currPageCount = A.get(i);
                totalPages += currPageCount;

                if (currPageCount > mid) {
                    // this can't be the answer as pages exceed the allowed count, ie, mid
                    studentCount = Integer.MAX_VALUE;
                    break;
                }

                if (totalPages > mid) {
                    // use an extra student
                    studentCount += 1;
                    // reset totalPages value
                    totalPages = currPageCount;
                }

                if (studentCount > studentsAlloted)
                    break;
            }

            if (studentCount <= studentsAlloted) {
                // less or req. number of students did the work. check if answer at lower burden
                // exists
                high = mid - 1;
                answer = mid;
            } else {
                // we used more students than alloted. Increase workload
                low = mid + 1;
            }
        }

        return answer;
    }
}
