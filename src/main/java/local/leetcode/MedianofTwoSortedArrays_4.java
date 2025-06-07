package local.leetcode;

public class MedianofTwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int medianSum=0;
        int avgIndexCount= nums1.length + nums2.length;
        boolean isDualMedian = avgIndexCount%2 == 0;
        avgIndexCount/=2;
        int index1=0, index2=0;
        for(int i=0;i<avgIndexCount+1; i++){
            int temp;
            if(index1<nums1.length && index2<nums2.length){
                temp= nums1[index1] < nums2[index2] ? nums1[index1++] : nums2[index2++];
            }
            else if(index1<nums1.length){
                temp= nums1[index1++];
            }
            else temp= nums2[index2++];
            if(i==avgIndexCount-1 && isDualMedian)
                medianSum+= temp;
            if(i== avgIndexCount) {
                medianSum += temp;
                break;
            }
        }
        return isDualMedian ? medianSum /2.0 : medianSum;
    }

    public static void main(String[] args) {
        int[] nums1={1,2,3,4,5};
        int[] nums2={6,7,8,9,10,11,12,13,14,15,16,17};
        System.out.println(new MedianofTwoSortedArrays_4().findMedianSortedArrays(nums1, nums2));
    }
}
