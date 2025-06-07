package local.leetcode;

class LongestMountaininArray_845 {
    public int longestMountain(int[] arr) {
        int result=0;
        int[] leftSubArray = new int[arr.length], rightSubArray = new int[arr.length];
        leftSubArray[0]=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                leftSubArray[i]=leftSubArray[i-1]+1;
            }
            else leftSubArray[i]=0;
        }
        rightSubArray[arr.length-1]=0;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                rightSubArray[i]=rightSubArray[i+1]+1;
            }
            else rightSubArray[i]=0;
        }
        for(int i=1;i<arr.length-1;i++){
            if(leftSubArray[i]!=0 && rightSubArray[i]!=0)
                result = Math.max(result, leftSubArray[i]+rightSubArray[i]+1);
        }
        return result>1? result : 0;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(new LongestMountaininArray_845().longestMountain(arr));
    }
}
