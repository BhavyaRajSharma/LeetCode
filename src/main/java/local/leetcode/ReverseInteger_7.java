package local.leetcode;

public class ReverseInteger_7 {
    public int reverse(int x) {
        int ans=0;
        int lastDigit;
        while (x!=0){
            lastDigit= x%10;
            if(x>0 && ans>Integer.MAX_VALUE/10){
                return 0;
            }
            if(x<0 && ans<Integer.MIN_VALUE/10){
                return 0;
            }
            x/=10;
            ans = ans*10 + lastDigit;
        }
        return ans;
    }

    public static void main(String[] args) {
        int x=-2_147_483_640;
        System.out.println(new ReverseInteger_7().reverse(x));
    }
}
