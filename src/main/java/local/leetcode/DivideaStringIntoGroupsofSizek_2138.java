package local.leetcode;

import java.util.Arrays;

public class DivideaStringIntoGroupsofSizek_2138 {
    public String[] divideString(String s, int k, char fill) {
        int size=(int) Math.ceil(s.length()/(double)k);
        String[] res= new String[size];
        size*=k;
        int index=0;
        for(int i=0;i<size; i++){
            if(res[i/k]==null) res[i/k]="";
            res[i/k]+=(i<s.length())?s.charAt(i):fill;
        }
        return res;
    }

    public static void main(String[] args) {
        String s="abcdefghij";
        int k=3;
        char fill='x';
        Arrays.stream(new DivideaStringIntoGroupsofSizek_2138().divideString(s, k, fill)).forEach(System.out::println);
    }
}
