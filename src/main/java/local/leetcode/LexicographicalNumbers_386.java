package local.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers_386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> numbers = new ArrayList<>(n);
        for(int i=1;i<10;i++)
            findNumbers(i, n, numbers);
        return numbers;
    }
    void findNumbers(int number, int limit, List<Integer> numbers){
        if(number<=limit){
            numbers.add(number);
            for(int i=0;i<10;i++){
                int temp = number*10+i;
                if(temp<=limit){
                    findNumbers(temp, limit, numbers);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n=100;
        new LexicographicalNumbers_386().lexicalOrder(n).forEach(System.out::println);
    }
}
