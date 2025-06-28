package local.leetcode;

import java.util.*;

public class ReorderRoutestoMakeAllPathsLeadtotheCityZero_1466 {
    public int minReorder(int n, int[][] connections) {
        int count=0;
        Map<Integer, Path> pathMap= new HashMap<>();
        for(int[] connection: connections){
            if(!pathMap.containsKey(connection[0])) pathMap.put(connection[0], new Path(connection[0]));
            if(!pathMap.containsKey(connection[1])) pathMap.put(connection[1], new Path(connection[1]));
            pathMap.get(connection[0]).away.add(pathMap.get(connection[1]));
            pathMap.get(connection[1]).towards.add(pathMap.get(connection[0]));
        }
        return DFS(pathMap.get(0), new HashSet<>());
    }
    private int DFS(Path path, Set<Path> visited){
        int count=0;
        visited.add(path);
        for(Path subPath: path.towards){
            if(!visited.contains(subPath)){
                count+=DFS(subPath, visited);
            }
        }
        for(Path subPath: path.away){
            if(!visited.contains(subPath)){
                count+=DFS(subPath, visited)+1;
            }
        }
        return count;
    }
    private class Path{
        int pathId;
        List<Path> towards= new ArrayList<>();
        List<Path> away= new ArrayList<>();

        public Path(int pathId) {
            this.pathId = pathId;
        }
    }

    public static void main(String[] args) {
        int n=6;
        int[][] connections= {{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println(new ReorderRoutestoMakeAllPathsLeadtotheCityZero_1466().minReorder(n , connections));
    }
}
