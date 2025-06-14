package local.leetcode;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int res=Integer.MIN_VALUE;
        int left=0, right=height.length-1;
        while (left<right){
            res= Math.max(res, (right-left) * (height[left] < height[right] ? height[left++] : height[right--]));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height={1,2,1};
        System.out.println(new ContainerWithMostWater_11().maxArea(height));
    }
}
