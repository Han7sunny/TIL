import java.util.*;
import java.io.*;

class Solution {
    
    int n, m;
    int[] oil;
    int[][] land;
    int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public class Loc {
        
        private int x;
        private int y;
        
        public Loc(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public void bfs(int x, int y){
        
        Queue<Loc> q = new ArrayDeque<>();
        Set<Integer> loc = new HashSet<>(); //  지나온 시추관 위치(중복 X)
        int sum = 0;
        
        land[x][y] = 0;
        q.add(new Loc(x, y));
        
        while(!q.isEmpty()){
            
            Loc now = q.poll();
            loc.add(now.y);
            sum++;
            
            int nx, ny;
            
            for(int i = 0; i < 4; i++){
                
                nx = now.x + move[i][0];
                ny = now.y + move[i][1];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || land[nx][ny] == 0) continue;
                
                land[nx][ny] = 0;
                q.add(new Loc(nx, ny));
            }
        }
        
        //  지나온 시추관 위치에 획득한 덩어리 축적
        for(int l : loc){
            oil[l] += sum;
        }
        
    }
    public int solution(int[][] land) {
        
        n = land.length;    //  세로 길이
        m = land[0].length; //  가로 길이
        oil = new int[m]; //  시추관 위치에 해당하는 총 석유량
        this.land = land;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1){
                    bfs(i, j);
                }
            }
        }

        //  가장 많은 석유량
        Arrays.sort(oil);
        return oil[m - 1];
    }
}
