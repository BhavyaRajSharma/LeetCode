package local.leetcode;

public class MaximumDifferenceBetweenIncreasingElements_2016 {
    public int maximumDifference(int[] nums) {
        int index=nums.length-1;
        int max=nums[index];
        int maxDiff=0;
        while (index-->0){
            maxDiff= Math.max(maxDiff, (max-nums[index]));
            max= Math.max(max, nums[index]);
        }
        return maxDiff>0 ? maxDiff : -1;
    }

    public static void main(String[] args) {
        int[] nums= {7,1,5,4};
        System.out.println(new MaximumDifferenceBetweenIncreasingElements_2016().maximumDifference(nums));
    }
}
