package local.leetcode;

import java.util.*;

public class MaximumPerformanceofaTeam_1383 {
    private final int MOD = 1_000_000_007;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<SpeedEff> speedEffs= new ArrayList<>();
        for(int i=0;i<n;i++){
            speedEffs.add(new SpeedEff(speed[i], efficiency[i]));
        }
        Collections.sort(speedEffs, new Comparator<SpeedEff>() {
            @Override
            public int compare(SpeedEff o1, SpeedEff o2) {
                return o2.eff-o1.eff;
            }
        });
        PriorityQueue<Integer> process = new PriorityQueue<>();
        long maxRes=0;
        long sum=0;
        for(int i=0;i<n;i++){
            process.add(speedEffs.get(i).speed);
            sum= (sum+speedEffs.get(i).speed);
            if(process.size() > k)
                sum-= process.poll();
            long performance = sum * speedEffs.get(i).eff;
            maxRes= Math.max(maxRes, performance);
        }
        return (int) maxRes%MOD;
    }
    private class SpeedEff{
        int speed, eff;
        public SpeedEff(int speed, int eff){
            this.speed= speed;
            this.eff= eff;
        }
    }

    public static void main(String[] args) {
        int n=6;
        int[] speed={2,10,3,1,5,8};
        int[] efficiency={5,4,3,9,7,2};
        int k=2;
        System.out.println(new MaximumPerformanceofaTeam_1383().maxPerformance(n, speed, efficiency, k));
    }
}
