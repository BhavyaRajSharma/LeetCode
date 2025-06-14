package local.leetcode;

public class StringCompression_443 {
    public int compress(char[] chars) {
        int i=0;
        int index=0;
        Character prevChar=chars[0];
        for(Character character:chars){
            if(prevChar==character){
                i++;
                continue;
            }
            chars[index++]=prevChar;
            if(i>1){
                for(Character digit: String.valueOf(i).toCharArray()){
                    chars[index++]=digit;
                }
            }
            prevChar= character;
            i=1;
        }
        chars[index++]=prevChar;
        if(i>1){
            for(Character digit: String.valueOf(i).toCharArray()){
                chars[index++]=digit;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        char[] chars={'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(new StringCompression_443().compress(chars));
    }
}
