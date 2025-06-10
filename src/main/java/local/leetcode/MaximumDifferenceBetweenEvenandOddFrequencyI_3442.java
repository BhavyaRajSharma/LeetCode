package local.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumDifferenceBetweenEvenandOddFrequencyI_3442 {
    public int maxDifference(String s) {
        Map<Character, Integer> charCountMap= new HashMap<>();
        int maxFreq=0, minFreq=Integer.MAX_VALUE;
        for(Character character: s.toCharArray()){
            charCountMap.put(character, charCountMap.getOrDefault(character, 0)+1);
        }
        for(Character character: charCountMap.keySet()){
            if(charCountMap.get(character)%2==0 && charCountMap.get(character)<minFreq)
                minFreq= charCountMap.get(character);
            if(charCountMap.get(character)%2!=0 && charCountMap.get(character)>maxFreq)
                maxFreq= charCountMap.get(character);
        }
        return maxFreq-minFreq;
    }

    public static void main(String[] args) {
        String s="abcabcab";
        System.out.println(new MaximumDifferenceBetweenEvenandOddFrequencyI_3442().maxDifference(s));
    }
}
