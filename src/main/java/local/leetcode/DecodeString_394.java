package local.leetcode;

import java.util.Stack;

public class DecodeString_394 {
    public String decodeString(String s) {
        String res="";
        int openBracketCount=0;
        int tempDigit=0;
        for(int i=0;i<s.length();){
            Character character=s.charAt(i++);
            if(Character.isDigit(character)){
                tempDigit *=10;
                tempDigit+=(character-'0');
            }
            else if(character=='['){
                openBracketCount+=1;
                String temp="";
                while (openBracketCount>0){
                    Character tempChar= s.charAt(i++);
                    if(tempChar==']'){
                        openBracketCount--;
                        if(openBracketCount>0)
                            temp+=tempChar;
                    }
                    else{
                        if(tempChar=='['){
                            openBracketCount++;
                        }
                        temp+=tempChar;
                    }
                }
                temp=decodeString(temp);
                while (tempDigit>0){
                    res+=temp;
                    tempDigit--;
                }
            }
            else{
                res+=character;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s="2[abc]3[cd]ef";
        System.out.println(new DecodeString_394().decodeString(s));
    }
}
