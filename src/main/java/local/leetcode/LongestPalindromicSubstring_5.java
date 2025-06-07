package local.leetcode;

public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        String result="";
        for(int type=0; type<=1; type++){
            for(int i=0; i<s.length(); i++){
                String temp=""+s.charAt(i);
                if(type==1){
                    if(i+type<s.length() && s.charAt(i) == s.charAt(i+type))
                        temp+=s.charAt(i+type);
                    else continue;
                }
                int steps=1;
                Character previousCharacter= null;
                Character nextCharacter=null;
                if(i-steps>=0 && i+type+steps<s.length()) {
                    previousCharacter = s.charAt(i - steps);
                    nextCharacter = s.charAt(i + type + steps);
                    while (previousCharacter == nextCharacter){
                        temp = previousCharacter + temp + nextCharacter;
                        steps++;
                        if(i-steps>=0 && i+type+steps<s.length()) {
                            previousCharacter = s.charAt(i - steps);
                            nextCharacter = s.charAt(i + type + steps);
                        }
                        else break;
                    }
                }
                if(result.length()<temp.length()){
                    result=temp;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s="a";
        System.out.println(new LongestPalindromicSubstring_5().longestPalindrome(s));
    }
}
