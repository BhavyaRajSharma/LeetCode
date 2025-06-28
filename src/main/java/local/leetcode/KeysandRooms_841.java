package local.leetcode;

import java.util.*;

public class KeysandRooms_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visitedRooms= new HashSet<>();
        visitedRooms.add(0);
        Queue<Integer> keys= new LinkedList<>();
        keys.addAll(rooms.get(0));
        while (!keys.isEmpty()){
            if(visitedRooms.contains(keys.peek())) {
                keys.poll();
                continue;
            }
            keys.addAll(rooms.get(keys.peek()));
            visitedRooms.add(keys.poll());
        }
        return visitedRooms.size() == rooms.size();
    }
}
