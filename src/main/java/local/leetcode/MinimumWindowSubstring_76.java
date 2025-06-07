package local.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        String result=s+"test";
        boolean isResultPossible= false;
        Map<Character, Integer> tCharCount= new HashMap<>();
        Map<Character, Integer> sCharCount= new HashMap<>();
        for(Character character: t.toCharArray()){
            tCharCount.put(character, tCharCount.getOrDefault(character, 0)+1);
        }
        StringBuilder temp= new StringBuilder();
        for(Character character: s.toCharArray()){
            temp.append(character);
            if(tCharCount.containsKey(character)){
                sCharCount.put(character, sCharCount.getOrDefault(character, 0)+1);
            }
            while (isGreaterOrEqual(sCharCount, tCharCount)){
                if(result.length() > temp.length()){
                    result= temp.toString();
                    isResultPossible= true;
                }
                if(sCharCount.containsKey(temp.charAt(0))){
                    sCharCount.put(temp.charAt(0), sCharCount.get(temp.charAt(0))-1);
                    if(sCharCount.get(temp.charAt(0))==0)
                        sCharCount.remove(temp.charAt(0));
                }
                temp.deleteCharAt(0);
            }
        }
        return isResultPossible ? result : "";
    }
    private static boolean isGreaterOrEqual(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Character key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                return false; // key missing in map2
            }
            if (map1.get(key) < map2.get(key)) {
                return false; // map1's value is less
            }
        }
        return true; // all values >=
    }

    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.println(new MinimumWindowSubstring_76().minWindow(s,t));
    }
}
