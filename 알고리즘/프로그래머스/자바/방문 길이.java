import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;
class Solution {
    public int solution(String dirs) {
        Set<String> pass = new HashSet<>(); // 처음엔 int[] 사용했지만 new int[]{}로 인해 같은 값이여도 다른 객체로 인식
        Map<Character, int[]> position = new HashMap<>();
        position.put('U',new int[]{0,1});
        position.put('D',new int[]{0,-1});
        position.put('L',new int[]{-1,0});
        position.put('R',new int[]{1,0});
        int x = 0; int y = 0;int newX = 0; int newY = 0;
        for(int i = 0; i < dirs.length(); i++){
            newX = x + position.get(dirs.charAt(i))[0];
            newY = y + position.get(dirs.charAt(i))[1];
            if(Math.abs(newX) <= 5 && Math.abs(newY) <= 5){
                pass.add(Integer.toString(x)+","+Integer.toString(y)+","+Integer.toString(newX)+","+Integer.toString(newY));
                pass.add(Integer.toString(newX)+","+Integer.toString(newY)+","+Integer.toString(x)+","+Integer.toString(y));
                x = newX;
                y = newY;
            }
        }
        return pass.size()/2;
    }
}
