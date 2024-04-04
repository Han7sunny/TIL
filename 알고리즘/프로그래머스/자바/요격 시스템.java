import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (t1,t2)-> Integer.compare(t1[1], t2[1]));
        
        int pre = 0;
        for(int i = 1; i < targets.length; i++){
            if(targets[pre][1] <= targets[i][0]){
                pre = i;
                answer++;
            }
        }
        
        return answer;
    }
}
