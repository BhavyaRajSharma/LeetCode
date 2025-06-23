package local.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumofkMirrorNumbers_2081 {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;

        while (count < n) {
            // Even-length and odd-length palindromes
            for (long pal : generatePalindromes(length)) {
                if (isKPalindrome(pal, k)) {
                    sum += pal;
                    count++;
                    if (count == n) return sum;
                }
            }
            length++;
        }
        return sum;
    }

    private boolean isKPalindrome(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        String baseK = sb.toString();
        return baseK.equals(sb.reverse().toString());
    }

    private List<Long> generatePalindromes(int len) {
        List<Long> res = new ArrayList<>();

        // Odd-length palindromes
        int start = (int)Math.pow(10, (len - 1) / 2);
        int end = (int)Math.pow(10, (len + 1) / 2);
        for (int i = start; i < end; i++) {
            String firstHalf = Integer.toString(i);
            String secondHalf = new StringBuilder(firstHalf.substring(0, len / 2)).reverse().toString();
            res.add(Long.parseLong(firstHalf + secondHalf));
        }

        return res;
    }
}
