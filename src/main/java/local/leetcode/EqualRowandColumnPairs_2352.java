package local.leetcode;

import java.util.HashMap;
import java.util.Map;

public class EqualRowandColumnPairs_2352 {
    public int equalPairs(int[][] grid) {
        int res=0;
        Map<String, Integer> rowMapCount= new HashMap<>();
        for(int i=0;i<grid.length;i++){
            StringBuilder key= new StringBuilder();
            for(int j=0;j<grid[i].length; j++){
                key.append(grid[i][j]);
                key.append("_");
            }
            rowMapCount.put(key.toString(), rowMapCount.getOrDefault(key.toString(), 0)+1);
        }
        for(int i=0;i<grid.length;i++){
            StringBuilder key= new StringBuilder();
            for(int j=0;j<grid[i].length; j++){
                key.append(grid[j][i]);
                key.append("_");
            }
            res+= rowMapCount.getOrDefault(key.toString(), 0);
        }
        return res;
    }
}
