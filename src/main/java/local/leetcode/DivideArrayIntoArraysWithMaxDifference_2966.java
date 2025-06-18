package local.leetcode;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference_2966 {
    public int[][] divideArray(int[] nums, int k) {
        int[][] NULL_ARRAY={};
        int SUB_SIZE= 3;
        if(nums.length%SUB_SIZE!=0) return NULL_ARRAY;
        int[][] res= new int[nums.length/3][];
        int index=0;
        int arrayCount= nums.length/SUB_SIZE;
        Arrays.sort(nums);
        while (index<arrayCount){
            res[index]=new int[3];
            res[index][0]=nums[index*SUB_SIZE];
            for (int i=1;i<SUB_SIZE;i++){
                if((nums[index*SUB_SIZE+i] - res[index][0] )> k)
                    return NULL_ARRAY;
                res[index][i]= nums[index*SUB_SIZE+i];
            }
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11};
        int k=14;
        int[][] res=new DivideArrayIntoArraysWithMaxDifference_2966().divideArray(nums, k);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[i].length; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
