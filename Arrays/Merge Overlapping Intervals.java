/**
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        Collections.sort(intervals, new Comparator<Interval>() {

            public int compare(Interval a, Interval b) {
                if (a.start != b.start) {
                    return a.start - b.start;
                } else {
                    return a.end - b.end;
                }
            }
        });

        ArrayList<Interval> answer = new ArrayList<Interval>();
        answer.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); ++i) {
            Interval currInterval = intervals.get(i);
            Interval prevInterval = answer.get(answer.size() - 1);

            if (prevInterval.end >= currInterval.start) {
                // there is an overlapping
                Interval toChange = answer.get(answer.size() - 1);
                toChange.start = Math.min(toChange.start, currInterval.start);
                toChange.end = Math.max(toChange.end, currInterval.end);
            } else {
                answer.add(currInterval);
            }
        }

        return answer;
    }
}