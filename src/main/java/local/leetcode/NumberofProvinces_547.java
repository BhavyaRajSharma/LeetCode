package local.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberofProvinces_547 {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<isConnected.length;i++){
            if(visited.contains(i))
                continue;
            visitProvinces(isConnected, i, visited);
            count++;
        }
        return count;
    }
    private void visitProvinces(int[][] isConnected, int i, Set<Integer> visited){
        visited.add(i);
        for(int j=0; j< isConnected[i].length; j++){
            if(visited.contains(j) || isConnected[i][j]==0 || i==j)
                continue;
            visitProvinces(isConnected, j, visited);
        }
    }
}
