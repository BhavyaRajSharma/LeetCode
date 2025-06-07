package local.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        int result=0;
        Set<Character> characterSet = new HashSet<>();
        int startIndex=0;
        for(int endIndex=0;endIndex< s.length();endIndex++){
            char character = s.charAt(endIndex);
            while(characterSet.contains(character)){
                characterSet.remove(s.charAt(startIndex++));
            }
            characterSet.add(character);
            result = Math.max(result, endIndex - startIndex + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters_3().lengthOfLongestSubstring(s));
    }
}
