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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        // First, udpating boundaries without merging

        boolean merging = false; // this is to make sure the new interval wasn't merged, hence will be added as a
                                 // new Interval data in the ArrayList

        for (int i = 0; i < intervals.size(); ++i) {
            Interval currentInterval = intervals.get(i);

            if (currentInterval.end >= newInterval.start && currentInterval.start <= newInterval.end) {
                // there is a merging, hence update boundary
                merging = true;
                currentInterval.start = Math.min(currentInterval.start, newInterval.start);
                currentInterval.end = Math.max(currentInterval.end, newInterval.end);
            }
        }

        if (!merging) {
            intervals.add(newInterval);
            Collections.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval a, Interval b) {
                    if (a.start != b.start) {
                        return a.start - b.start;
                    } else {
                        return a.end - b.end;
                    }
                }
            });

            return intervals;
        }

        ArrayList<Interval> answer = new ArrayList<Interval>();

        // if there was merging, there is no extra data added in the array, hence,
        // simply simplify and merge
        answer.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); ++i) {

            Interval currentInterval = intervals.get(i);
            Interval prevInterval = answer.get(answer.size() - 1);

            if (prevInterval.end >= currentInterval.start) {
                Interval toChange = answer.get(answer.size() - 1);
                toChange.start = Math.min(toChange.start, currentInterval.start);
                toChange.end = Math.max(toChange.end, currentInterval.end);
            } else {
                answer.add(currentInterval);
            }
        }

        return answer;

    }
}
