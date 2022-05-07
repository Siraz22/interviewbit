public class Solution {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

        // "Blackbird singing in the dead of night
        // Take these broken wings and learn to fly"
        // - Paul McCartney, The Beatles, Blackbird

        int answer = 0;

        if (A.size() == 1)
            return 0;

        for (int i = 1; i < A.size(); ++i) {
            int xDist = Math.abs(A.get(i - 1) - A.get(i));
            int yDist = Math.abs(B.get(i - 1) - B.get(i));
            int greater = Math.max(xDist, yDist);
            answer += greater;
        }

        return answer;
    }
}