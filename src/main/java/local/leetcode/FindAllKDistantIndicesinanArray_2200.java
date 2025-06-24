package local.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndicesinanArray_2200 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res= new ArrayList<>();
        int size= nums.length;
        int lastKeyIndex=-1;
        for(int i=0;i<size;i++){
            if(nums[i]==key){
                for(int j= Math.max(lastKeyIndex+1, i-k); j<=i+k && j<size; j++){
                    lastKeyIndex= j;
                    res.add(lastKeyIndex);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums= {2,2,2,2,2};
        int key=2;
        int k=2;
        System.out.print(new FindAllKDistantIndicesinanArray_2200().findKDistantIndices(nums, key, k));
    }
}
