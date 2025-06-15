package local.leetcode;

import java.util.Stack;

public class RemovingStarsFromaString_2390 {
    public String removeStars(String s) {
        StringBuilder res= new StringBuilder();
        Stack<Character> characterStack = new Stack<>();
        for(Character character: s.toCharArray()){
            if(character=='*'){
                characterStack.pop();
            }
            else characterStack.push(character);
        }
        while (!characterStack.isEmpty()){
            res.insert(0, characterStack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s="erase*****";
        System.out.println(new RemovingStarsFromaString_2390().removeStars(s));
    }
}
