package local.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberofEventsThatCanBeAttended_1353 {
    public int maxEvents(int[][] events) {
        int count=0;
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<int[]> eventQueue= new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                    return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        int maxDate= 0;
        int i=0;
        while (i<events.length){
            if(maxDate >= events[i][0]){
                eventQueue.add(events[i++]);
            }
            else if(eventQueue.isEmpty()){
                maxDate= events[i][0];
                eventQueue.add(events[i++]);
            }
            else{
                int[] firstEvent= eventQueue.poll();
                if(maxDate<=firstEvent[1]){
                    maxDate= Math.max(maxDate+1, firstEvent[0]);
                    count++;
                }
            }
        }
        while (!eventQueue.isEmpty()){
            int[] firstEvent= eventQueue.poll();
            if(maxDate<=firstEvent[1]){
                maxDate= Math.max(maxDate+1, firstEvent[0]);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[][] events={{1,4},{4,4},{2,2},{3,4},{1,1}};
//        int[][] events={{1,2},{2,3},{3,4}};
        int[][] events={{1,5},{1,5},{1,5},{2,3},{2,3}};
        new MaximumNumberofEventsThatCanBeAttended_1353().maxEvents(events);
    }
}
