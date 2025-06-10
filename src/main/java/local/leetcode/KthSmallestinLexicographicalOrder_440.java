package local.leetcode;

public class KthSmallestinLexicographicalOrder_440 {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1; // first number is 1

        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr++;      // move to next sibling
                k -= steps;  // skip the subtree
            } else {
                curr *= 10;  // go deeper in current subtree
                k--;
            }
        }

        return curr;
    }

    private long countSteps(int n, long first, long last) {
        long steps = 0;
        while (first <= n) {
            steps += Math.min(n + 1, last) - first;
            first *= 10;
            last *= 10;
        }
        return steps;
    }

    public static void main(String[] args) {
        int n=100;
        int k=5;
        System.out.println(new KthSmallestinLexicographicalOrder_440().findKthNumber(n,k));
    }
}
