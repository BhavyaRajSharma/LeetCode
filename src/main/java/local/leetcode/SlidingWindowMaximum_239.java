package local.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result=new int[nums.length-k+1];
        Deque<Integer> queue= new ArrayDeque<>();
        int i=0;
        while(i<k){
            while(!queue.isEmpty() && nums[queue.peekLast()]<=nums[i])
                queue.pollLast();
            queue.add(i++);
        }
        for(;i<nums.length;i++){
            result[i-k]=nums[queue.peekFirst()];
            while (!queue.isEmpty() && i-queue.peekFirst()>=k)
                queue.pollFirst();
            while (!queue.isEmpty() && nums[queue.peekLast()]<=nums[i]){
                queue.pollLast();
            }
            queue.add(i);
        }
        result[i-k]=nums[queue.peekFirst()];
        return result;
    }

    public static void main(String[] args) {
        int[] nums={1,-1};
        int k=1;
        Arrays.stream(new SlidingWindowMaximum_239().maxSlidingWindow(nums, k)).forEach(System.out::println);
    }
}
