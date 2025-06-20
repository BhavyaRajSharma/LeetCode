package local.leetcode;

public class MaximumManhattanDistanceAfterKChanges_3443 {
    public int maxDistance(String s, int k) {
        int countN=0, countW=0, countE=0, countS=0;
        int maxV=0, maxH=0;
        int minV=0, minH=0;
        int max=0;
        for(Character character: s.toCharArray()){
            int tempK=k;
            switch (character){
                case 'N':countN++; break;
                case 'S':countS++; break;
                case 'E':countE++; break;
                case 'W':countW++; break;
            }
            maxV= Math.max(countN, countS);
            minV= Math.min(countN, countS);
            maxH= Math.max(countW, countE);
            minH= Math.min(countW, countE);
            if(tempK>minV){
                maxV+=minV;
                tempK-=minV;
                minV=0;
            }
            else{
                maxV+=tempK;
                minV-=tempK;
                tempK=0;
            }
            if(tempK>minH){
                maxH+=minH;
                minH=0;
            }
            else{
                maxH+=tempK;
                minH-=tempK;
            }
            max= Math.max(max, maxV+maxH-minV-minH);
        }
        return max;
    }

    public static void main(String[] args) {
        String s="EWWE";
        int k=0;
        System.out.print(new MaximumManhattanDistanceAfterKChanges_3443().maxDistance(s, k));
    }
}
