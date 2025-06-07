package local.leetcode;

public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int result=0;
        int[] leftWallSize = new int[height.length];
        leftWallSize[0]=0;
        int[] rightWallSize = new int[height.length];
        rightWallSize[height.length-1]=0;
        for(int i=1, j=height.length-2; i<height.length && j>=0 ;i++, j--){
            leftWallSize[i] = Math.max(leftWallSize[i-1], height[i-1]);
            rightWallSize[j] = Math.max(rightWallSize[j+1], height[j+1]);
        }
        for(int i=0;i<height.length;i++){
            int temp= Math.min(leftWallSize[i], rightWallSize[i])-height[i];
            result+= Math.max(temp, 0);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height= {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new TrappingRainWater_42().trap(height));
    }
}
