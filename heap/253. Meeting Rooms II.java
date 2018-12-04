/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
*/


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length < 1) return 0;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<> ((a, b) -> a.end - b.end);
        
        pq.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            Interval inter = intervals[i];
            Interval cur = pq.poll();
            if (cur.end <= inter.start) {
                cur.end = inter.end;
            } else {
                pq.offer(inter);
            }
            pq.offer(cur);
        }
        return pq.size();
    }
}
