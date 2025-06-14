package local.leetcode;

public class MaxConsecutiveOnesIII_1004 {
    public int longestOnes(int[] nums, int k) {
        int count0=0, max=0;
        int startIndex=0, endIndex=0;
        while (endIndex<nums.length){
            while (count0>k){
                if (nums[startIndex++]==0) {
                    count0--;
                }
            }
            if(nums[endIndex++]==0)
                count0++;
            if(count0==k){
                max= Math.max(max, endIndex-startIndex);
            }
        }
        if(count0<k)
            max= Math.max(max, endIndex-startIndex);
        return max;
    }

    public static void main(String[] args) {
        int[] nums={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(new MaxConsecutiveOnesIII_1004().longestOnes(nums, k));
    }
}
