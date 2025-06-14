package local.leetcode;

public class IncreasingTripletSubsequence_334 {
    public boolean increasingTriplet(int[] nums) {
        int first_num = Integer.MAX_VALUE, second_num = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= first_num) {
                first_num = num;
            } else if (num <= second_num) {
                second_num = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums= {20,100,10,12,5,13};
        System.out.println(new IncreasingTripletSubsequence_334().increasingTriplet(nums));
    }
}
