package local.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumNumberofEventsThatCanBeAttendedII_1751 {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int n = events.length;

        // Memoization table: dp[i][k] = max value starting from event i with k choices left
        Integer[][] memo = new Integer[n][k + 1];

        // Precompute the next non-overlapping index using binary search
        int[] nextIndex = new int[n];
        for (int i = 0; i < n; i++) {
            nextIndex[i] = binarySearch(events, events[i][1] + 1);
        }

        return dfs(0, k, events, nextIndex, memo);
    }

    private int dfs(int i, int k, int[][] events, int[] nextIndex, Integer[][] memo) {
        if (i == events.length || k == 0) return 0;
        if (memo[i][k] != null) return memo[i][k];

        // Skip current event
        int skip = dfs(i + 1, k, events, nextIndex, memo);

        // Take current event
        int take = events[i][2] + dfs(nextIndex[i], k - 1, events, nextIndex, memo);

        return memo[i][k] = Math.max(skip, take);
    }

    // Binary search to find the next event starting after time
    private int binarySearch(int[][] events, int target) {
        int left = 0, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int k=2;
        int[][] events={{1,2,4},{3,4,3},{2,3,10}};
        System.out.println(new MaximumNumberofEventsThatCanBeAttendedII_1751().maxValue(events, k));
    }
}
