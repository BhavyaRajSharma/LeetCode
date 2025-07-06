package local.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindingPairsWithaCertainSum_1865 {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> freqCount=new HashMap<>();
    public FindingPairsWithaCertainSum_1865(int[] nums1, int[] nums2) {
        this.nums1= nums1;
        this.nums2= nums2;
        for(int num: nums2){
            freqCount.put(num, freqCount.getOrDefault(num, 0)+1);
        }
    }

    public void add(int index, int val) {
        freqCount.put(nums2[index], freqCount.get(nums2[index])-1);
        nums2[index]+=val;
        freqCount.put(nums2[index], freqCount.getOrDefault(nums2[index],0)+1);
    }

    public int count(int tot) {
        int count=0;
        for(int num: nums1){
            if(num>tot) continue;
            if(freqCount.getOrDefault(tot-num, 0)>0){
                count+= freqCount.get(tot-num);
            }
        }
        return count;
    }
}
