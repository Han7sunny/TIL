import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        //  K 시간 이하로 배달이 가능한 마을에서만 주문을 받으려고 한다.
        //  1번 마을 기준
        int answer = 1;
        int[][] dp = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            Arrays.fill(dp[i], 500001);
        }
        
        for(int i = 0; i < road.length; i++){
            int s = road[i][0];
            int e = road[i][1];
            int t = road[i][2];
            if(dp[s][e] > t){
                dp[s][e] = t;
                dp[e][s] = t;
            }
        }
        
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);                    
                }
            }
        }
        
        for(int i = 2; i <= N; i++){
            if(dp[1][i] <= K)
                answer++;
        }
        
        return answer;
    }
}
