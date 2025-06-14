package local.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberofKSumPairs_1679 {
    public int maxOperations(int[] nums, int k) {
        int res=0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(Integer num: nums){
            if(freqMap.getOrDefault(k-num, 0)>0){
                freqMap.put(k-num, freqMap.get(k-num)-1);
                res++;
            }
            else freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={3,1,3,4,3};
        int k=6;
        System.out.println(new MaxNumberofKSumPairs_1679().maxOperations(nums, k));
    }
}
