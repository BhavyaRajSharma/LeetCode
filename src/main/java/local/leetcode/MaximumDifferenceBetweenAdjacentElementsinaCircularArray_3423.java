package local.leetcode;

public class MaximumDifferenceBetweenAdjacentElementsinaCircularArray_3423 {
    public int maxAdjacentDistance(int[] nums) {
        int maxDiff=Math.abs(nums[0]-nums[nums.length-1]);
        for(int i=1;i<nums.length;i++){
            maxDiff= Math.max(maxDiff, Math.abs(nums[i]-nums[i-1]));
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] nums={-5,-10,-5};
        System.out.println(new MaximumDifferenceBetweenAdjacentElementsinaCircularArray_3423().maxAdjacentDistance(nums));
    }
}
