package local.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CounttheNumberofArrayswithKMatchingAdjacentElements_3405 {
    private Map<String, Integer> memory;
    private final int MOD= 1_000_000_007;
    public int countGoodArrays(int n, int m, int k) {
        memory= new HashMap<>();
        int res=0;
        for(int i=1; i<=m ;i++){
            res= (res+DFS(n-1, m, k, i))%MOD;
        }
        return res;

    }
    private int DFS(int n, int m, int k, int prev){
        if(n==0) return k ==0 ? 1 : 0;
        if(memory.containsKey(n+"_"+k+"_"+prev)) return memory.get(n+"_"+k+"_"+prev);
        int res=0;
        for(int i=1; i<=m; i++){
            if(i == prev){
                if(k>0)
                    res= (res+DFS(n-1, m, k-1, i))%MOD;
            }
            else res= (res+DFS(n-1, m ,k, i))%MOD;
        }
        memory.put((n+"_"+k+"_"+prev), res);
        return res;
    }

    public static void main(String[] args) {
        int n=5581;
        int m=58624;
        int k=4766;
        System.out.println(new CounttheNumberofArrayswithKMatchingAdjacentElements_3405().countGoodArrays(n, m, k));
    }
}
