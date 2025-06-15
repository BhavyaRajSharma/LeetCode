package local.leetcode;

public class MaxDifferenceYouCanGetFromChanginganInteger_1432 {
    public int maxDiff(int num) {
        if(num<10)
            return 8;
        int firstNonNineDigit=-1;
        int firstNonOneDigit=-1;
        int firstDigit=-1;
        int digitCount= (int) Math.log10(num)+1;
        int max=0, min=0;
        int minReplaceValue=0;
        while (digitCount-->0){
            int temp= (int) (num/ Math.pow(10, digitCount));
            if(firstDigit==-1)
                firstDigit=temp;
            if(firstNonNineDigit==-1 && temp!=9){
                firstNonNineDigit=temp;
            }
            if(firstNonOneDigit==-1 && temp>1 ){
                firstNonOneDigit=temp;
                if(firstDigit == firstNonOneDigit)
                    minReplaceValue=1;
            }

            max = max*10 + (firstNonNineDigit == temp ? 9 : temp);
            min = min*10 + (firstNonOneDigit == temp ? minReplaceValue : temp);
            num= (int) (num % Math.pow(10, digitCount));
        }
        System.out.println(max +" "+min);
        return max-min;
    }

    public static void main(String[] args) {
        int num=1101057;
        System.out.println(new MaxDifferenceYouCanGetFromChanginganInteger_1432().maxDiff(num));
    }
}
