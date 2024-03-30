class Solution {
  
    int N, M, desR, desC, routeLen;
    String answer = "";
    int[][] move = {{1,0}, {0,-1}, {0,1}, {-1,0}};
    String[] route = {"d", "l", "r", "u"};
    boolean isEscape = false;
    
    public void dfs(int x, int y, int remain, String r){
        
        if(isEscape) return;

        if(remain == 0){
            if(x == desR && y == desC){
                answer = r;
                isEscape = true;
            }
            return;
        }
        
        int nx, ny;
        for(int i = 0; i < 4; i++){
            nx = x + move[i][0];
            ny = y + move[i][1];
                
            // 조건 추가
            if(nx < 0 || ny < 0 || nx >= N || ny >= M || Math.abs(nx - desR) + Math.abs(ny - desC) > remain) continue;
                
            dfs(nx, ny, remain - 1, r + route[i]);
        }
        
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        N = n;
        M = m;
        desR = r - 1;
        desC = c - 1;
        routeLen = k;
        
        // 조건 추가
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if(k >= dist && (dist % 2 == k % 2))
            dfs(x - 1, y - 1, k, "");
        
        return answer == "" ? "impossible" : answer;
    }
}
