package local.uber;

import java.util.*;

public class ConnectedDrivers {
    /*
    * We have a log statement like
    * Log="1755630141 A rides B,
    * 1755630142 C rides D,
    * 1755630143 B rides C,
    * 1755630144 A rides E,
    * 1755630145 E rides B"
    *
    * And a list of riders=[A, B, C, D, E]
    *
    * Now we have to write a method which return a point where all the points are connected at the earliest timestamp
    * */

    public static void main(String[] args) {
        String logs= """
                1755630141 A rides B
                1755630142 C rides D
                1755630143 B rides E
                1755630145 E rides F
                """;
        List<String> riders= new ArrayList<>(Arrays.asList("A","B","C","D","E","F"));
        System.out.println(new ConnectedDrivers().fetchEarliestTime(logs, riders));
    }

    public int fetchEarliestTime(String logs, List<String> riders){
        int result=-1;
        int count=0;
        Rider rider= new Rider(riders);
        for(String log : logs.split("\n")){
            String[] logInfo= log.split(" ");
            if(!rider.findOriginParent(logInfo[1]).equals(rider.findOriginParent(logInfo[3]))){
                rider.merge(logInfo[1], logInfo[3]);
                if(++count== riders.size()-1){
                    result= Integer.parseInt(logInfo[0]);
                    break;
                }
            }
        }
        return result;
    }
    private class Rider{
        Map<String, String> parent;
        Map<String, Integer> rank;
        public Rider(List<String> riders){
            parent= new HashMap<>();
            rank= new HashMap<>();
            for(String rider: riders){
                parent.put(rider, rider);
                rank.put(rider,0);
            }
        }
        public String findOriginParent(String rider){
            return parent.get(rider).equals(rider) ? rider : findOriginParent(parent.get(rider));
        }

        public void merge(String rider1, String rider2){
            String parent1= findOriginParent(rider1);
            String parent2= findOriginParent(rider2);
            if(!parent1.equals(parent2)){
                if(rank.get(parent1)<rank.get(parent2)) parent.put(parent1, parent2);
                else if(rank.get(parent1) > rank.get(parent2)) parent.put(parent2, parent1);
                else {
                    parent.put(parent2, parent1);
                    rank.put(parent1,rank.get(parent1)+1);
                }
            }
        }
    }
}
