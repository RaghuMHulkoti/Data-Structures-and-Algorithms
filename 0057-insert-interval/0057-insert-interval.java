class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        boolean inserted = false;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            if (!inserted && start >= newInterval[0]) {
                ans.add(newInterval);
                inserted = true;
            }
            ans.add(intervals[i]);
        }
        if (!inserted)
            ans.add(newInterval);

        return merge(ans.toArray(new int[ans.size()][]));

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            if (nextStart <= end) {
                end = Math.max(end, nextEnd);
            } else {
                res.add(new int[] { start, end });
                start = nextStart;
                end = nextEnd;
            }

        }
        res.add(new int[] { start, end });

        return res.toArray(new int[res.size()][]);

    }
}