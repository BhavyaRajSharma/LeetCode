package local.leetcode;
public class CounttheNumberofArrayswithKMatchingAdjacentElements_3405_SecondWay {
    private static final int MOD = 1_000_000_007;
    private static final int MAX = 100_005;
    private static long[] fact = new long[MAX];
    private static long[] invFact = new long[MAX];

    static {
        // Precompute factorials and inverse factorials
        fact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        invFact[MAX - 1] = modInverse(fact[MAX - 1]);
        for (int i = MAX - 2; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    public int countGoodArrays(int n, int m, int k) {
        if (k > n - 1) return 0;

        long choose = comb(n - 1, k);  // C(n - 1, k)
        long first = m;
        long rest = modPow(m - 1, n - k - 1);

        long res = choose * first % MOD;
        res = res * rest % MOD;
        return (int) res;
    }

    // Compute C(n, r)
    private long comb(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    // Modular exponentiation
    private static long modPow(long base, int exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }

    // Modular inverse using Fermat’s little theorem
    private static long modInverse(long x) {
        return modPow(x, MOD - 2);
    }
}
