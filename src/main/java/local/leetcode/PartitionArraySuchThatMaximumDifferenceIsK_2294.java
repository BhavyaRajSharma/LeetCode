package local.leetcode;

import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK_2294 {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count=0;
        int minNum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-minNum>k){
                count++;
                minNum=nums[i];
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        int[] nums={2,2,4,5};
        int k=0;
        System.out.print(new PartitionArraySuchThatMaximumDifferenceIsK_2294().partitionArray(nums, k));
    }
}
