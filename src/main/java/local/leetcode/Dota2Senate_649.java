package local.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Dota2Senate_649 {
    private String predictPartyVictory(String senate, Queue<Character> rQueue, Queue<Character> dQueue) {
        if(senate.isEmpty()){
            return rQueue.size()>dQueue.size() ? "Radiant": "Dire";
        }
        String temp="";
        for(Character character: senate.toCharArray()){
            if(character=='R'){
                if(!dQueue.isEmpty()){
                    temp+=dQueue.poll();
                }
                else{
                    rQueue.add(character);
                }
            }
            if(character=='D'){
                if(!rQueue.isEmpty()){
                    temp+=rQueue.poll();
                }
                else{
                    dQueue.add(character);
                }
            }
        }
        return predictPartyVictory(temp, rQueue, dQueue);
    }
    public String predictPartyVictory(String senate) {
        return predictPartyVictory(senate, new ArrayDeque<>(), new ArrayDeque<>());
    }
    public static void main(String[] args) {
        String s="DRRDRDRDRDDRDRDR";
        System.out.println(new Dota2Senate_649().predictPartyVictory(s));
    }
}
