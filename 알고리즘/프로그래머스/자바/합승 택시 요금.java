import java.util.*;
import java.io.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
       
        int answer = 20000000;
        int[][] dist = new int[n + 1][n + 1];
        
        for(int i = 0; i <= n; i++)
            Arrays.fill(dist[i], 20000000);
        
        for(int i = 0; i < fares.length; i++){
            dist[fares[i][0]][fares[i][1]] = fares[i][2];
            dist[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        answer = Math.min(answer, dist[s][a] + dist[s][b]);
        for(int i = 1; i <= n; i++){                
                if(i == a)
                    answer = Math.min(answer, dist[s][i] + dist[i][b]);
                else if(i == b)
                    answer = Math.min(answer, dist[s][i] + dist[i][a]);
                else
                    answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }
        return answer;
    }
}
