import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
class Solution {
   // 처음에 Map으로 풀었었는데 실패...나중에 다시 시도..?
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] play = new int[n + 1][n + 1];
        for(int[] result : results){
            play[result[0]][result[1]] = 1; // win
            play[result[1]][result[0]] = -1; // lose
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(play[i][k] == 1 && play[k][j] == 1){
                        play[i][j] = 1;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(play[i][j] == 1 || play[j][i] == 1)
                    cnt++;
            }
            if(cnt == n - 1)
                answer++;
        }
        return answer;
    }
}
