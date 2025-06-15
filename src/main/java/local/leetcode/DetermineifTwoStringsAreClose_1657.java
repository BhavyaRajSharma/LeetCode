package local.leetcode;

import java.util.*;

public class DetermineifTwoStringsAreClose_1657 {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())
            return false;
        Map<Character, Integer> wordMap1 = new HashMap<>();
        for(Character character : word1.toCharArray()){
            wordMap1.put(character, wordMap1.getOrDefault(character, 0)+1);
        }
        Map<Character, Integer> wordMap2 = new HashMap<>();
        for(Character character : word2.toCharArray()){
            if(!wordMap1.containsKey(character))
                return false;
            wordMap2.put(character, wordMap2.getOrDefault(character, 0)+1);
        }
        if(wordMap1.size() != wordMap2.size())
            return false;
        Map<Integer, List<Character>> freqMap = new HashMap<>();
        for(Character character: wordMap1.keySet()){
            if(!freqMap.containsKey(wordMap1.get(character))){
                freqMap.put(wordMap1.get(character), new ArrayList<>());
            }
            freqMap.get(wordMap1.get(character)).add(character);
        }
        for(Character character: wordMap2.keySet()){
            if(freqMap.getOrDefault(wordMap2.get(character), new ArrayList<>()).isEmpty())
                return false;
            freqMap.get(wordMap2.get(character)).remove(0);
        }
        return true;
    }
    public static void main(String[] args) {
        String word1="uau";
        String word2="ssx";
        System.out.println(new DetermineifTwoStringsAreClose_1657().closeStrings(word1, word2));
    }
}
