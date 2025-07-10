class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int lastEnd = 0;
        int n = startTime.length;
        int maxLeft = 0;
        int res = 0;
     // Array to store free gaps between events, plus before the first and after the last event
        
        int[] gaps = new int[n + 1];
     // Calculate gaps between consecutive events
        for (int i = 0; i < startTime.length; i++) {
            // Free time before current event
            gaps[i] = startTime[i] - lastEnd;
            // Update lastEnd for next iteration
            lastEnd = endTime[i];
        }
// Add the final gap after the last event
        gaps[n] = eventTime - lastEnd;
 // Try removing each event and merging its two adjacent gaps
        int[] maxRight = new int[n + 1];
        for (int i = n - 1; i >= 0; i--)
            maxRight[i] = Math.max(maxRight[i + 1], gaps[i + 1]);

        for (int i = 1; i <= n; i++) {
            int dur = endTime[i - 1] - startTime[i - 1];

            if (maxLeft >= dur || maxRight[i] >= dur)
                res = Math.max(res, gaps[i - 1] + dur + gaps[i]);
// Update maximum gap if this merged gap is larger
            res = Math.max(res, gaps[i - 1] + gaps[i]);
            maxLeft = Math.max(maxLeft, gaps[i - 1]);
        }

        return res;
    }
}
