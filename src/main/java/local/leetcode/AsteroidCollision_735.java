package local.leetcode;

import java.util.Arrays;

public class AsteroidCollision_735 {
    public int[] asteroidCollision(int[] asteroids) {
        int[] res;
        int[] asteroidsCollision = new int[asteroids.length];
        int index=0;
        while (index <asteroids.length && asteroids[index]<0){
            asteroidsCollision[index]=asteroids[index];
            index++;
        }
        if(index==0)asteroidsCollision[index++]= asteroids[0];
        for(int i=index; i <asteroids.length; i++){
            if(asteroids[i]<0){
              while (index>0 && asteroidsCollision[index-1]>0 && Math.abs(asteroids[i])>asteroidsCollision[index-1]){
               index--;
              }
              if(index==0 || asteroidsCollision[index-1]<0)
                  asteroidsCollision[index++]=asteroids[i];
              else if(asteroidsCollision[index-1]==Math.abs(asteroids[i])){
                  index--;
              }
            }
            else asteroidsCollision[index++]=asteroids[i];
        }
        res= new int[index];
        for(int i=0;i<index; i++){
            res[i]=asteroidsCollision[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] asteroids={-2,-2,-2,-2};
        Arrays.stream(new AsteroidCollision_735().asteroidCollision(asteroids)).forEach(System.out::println);
    }
}
