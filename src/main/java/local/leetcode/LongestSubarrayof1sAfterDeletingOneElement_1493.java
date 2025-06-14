package local.leetcode;

public class LongestSubarrayof1sAfterDeletingOneElement_1493 {
    public int longestSubarray(int[] nums) {
        int maxSize=0;
        int kCount=0;
        int startIndex=0, endIndex=0;
        boolean deleted=false;
        while (endIndex<nums.length){
            while (kCount>1){
                if(nums[startIndex++]!=1)
                    kCount--;
            }
            if(nums[endIndex]!=1) {
                kCount++;
                deleted=true;
            }
            if(kCount==1){
                maxSize= Math.max(maxSize, endIndex-startIndex);
            }
            endIndex++;
        }
        if(kCount<1)
            maxSize= Math.max(maxSize, endIndex-startIndex);
        return deleted? maxSize: maxSize-1;
    }

    public static void main(String[] args) {
        int[] nums={1,1,1};
        System.out.println(new LongestSubarrayof1sAfterDeletingOneElement_1493().longestSubarray(nums));
    }
}
