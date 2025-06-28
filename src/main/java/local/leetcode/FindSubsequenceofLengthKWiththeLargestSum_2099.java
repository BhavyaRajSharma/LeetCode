package local.leetcode;

import java.util.*;

public class FindSubsequenceofLengthKWiththeLargestSum_2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] temp=Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        Map<Integer, Integer> maxKMap= new HashMap<>();
        for(int i=temp.length-1;i>=temp.length-k;i--) maxKMap.put(temp[i], maxKMap.getOrDefault(temp[i],0)+1);
        int i=0, index=0;
        temp= new int[k];
        while (index<k){
            if(maxKMap.getOrDefault(nums[i++],0)>0){
                temp[index++]= nums[i-1];
                maxKMap.put(nums[i-1], maxKMap.getOrDefault(nums[i-1],0)-1);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums={50,-75};
        int k=2;
        System.out.println(new FindSubsequenceofLengthKWiththeLargestSum_2099().maxSubsequence(nums, k));
    }
}
