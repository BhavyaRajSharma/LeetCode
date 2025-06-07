package local.leetcode;

import java.util.*;

public class LexicographicallyMinimumStringAfterRemovingStars_3170 {
    public String clearStars(String s) {
        StringBuilder result= new StringBuilder();
        Set<Integer> removedIndex = new HashSet<>();
        PriorityQueue<CharacterIndexMap> characterIndexMaps = new PriorityQueue<>((o1, o2) -> o1.ch == o2.ch ? o2.index - o1.index : o1.ch - o2.ch);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='*'){
                characterIndexMaps.add(new CharacterIndexMap(s.charAt(i), i));
            }
            else{
                removedIndex.add(characterIndexMaps.poll().index);
            }
        }
        for(int i=0;i<s.length();i++){
            if(!(s.charAt(i)=='*' || removedIndex.contains(i))){
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
    static class CharacterIndexMap{
        char ch;
        int index;

        public CharacterIndexMap(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        String s="aaba**";
        System.out.println(new LexicographicallyMinimumStringAfterRemovingStars_3170().clearStars(s));
    }
}
