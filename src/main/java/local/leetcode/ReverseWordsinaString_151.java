package local.leetcode;

public class ReverseWordsinaString_151 {
    public String reverseWords(String s) {
        if(s.isBlank())
            return "";
        StringBuilder result=new StringBuilder();
        for(String temp: s.trim().split(" ")){
            if(temp.isBlank())
                continue;
            result.insert(0,temp);
            result.insert(0," ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String s="a good   example";
        System.out.println(new ReverseWordsinaString_151().reverseWords(s));
    }
}
