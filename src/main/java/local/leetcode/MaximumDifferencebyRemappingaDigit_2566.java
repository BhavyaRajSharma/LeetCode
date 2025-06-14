package local.leetcode;

public class MaximumDifferencebyRemappingaDigit_2566 {
    public int minMaxDifference(int num) {
        int maxNumber=0,minNumber=0;
        int temp= num;
        int firstNonNine=-1;
        int firstDigit=-1;
        int digitCount=(int) Math.log10(temp)+1;
        while (digitCount>0){
            digitCount--;
            if(temp==0){
                maxNumber= maxNumber*10 + (firstNonNine==-1 ? 9 : 0);
                minNumber= minNumber*10;
                continue;
            }
            int divisor= (int) Math.pow(10, digitCount);
            if(firstNonNine==-1 && temp/divisor!=9){
                firstNonNine= temp/divisor;
            }
            if(firstDigit==-1){
                firstDigit= temp/divisor;
            }
            maxNumber = maxNumber * 10 + (((int) (temp/divisor)) == firstNonNine ? 9 : temp/divisor);
            minNumber= minNumber*10 + (((int) temp/divisor) == firstDigit ? 0 : temp/divisor);
            temp%=divisor;
        }
        System.out.println(num);
        System.out.println("Max: "+maxNumber+" , min: "+minNumber);
        return maxNumber - minNumber;
    }

    public static void main(String[] args) {
        int n=90693669;
        System.out.println(new MaximumDifferencebyRemappingaDigit_2566().minMaxDifference(n));
    }
}
