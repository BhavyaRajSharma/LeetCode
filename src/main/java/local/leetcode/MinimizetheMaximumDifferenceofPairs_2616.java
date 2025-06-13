package local.leetcode;

import java.util.Arrays;

public class MinimizetheMaximumDifferenceofPairs_2616 {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums); // Sort the array
        int left = 0;
        int right = nums[nums.length - 1] - nums[0]; // Max possible diff

        while (left < right) {
            int mid = (left + right) / 2;
            if (canFormPairs(nums, p, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 1;

        while (i < nums.length) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i += 2; // Skip next index to avoid reuse
            } else {
                i++;
            }
            if (count >= p) return true;
        }

        return count >= p;
    }
}
