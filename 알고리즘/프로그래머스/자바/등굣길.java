
class Solution {
	final int PUDDLE = -1;
    
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] count = new int[n + 1][m + 1]; // 최단 거리당 개수

        for (int[] location : puddles) {
            count[location[1]][location[0]] = PUDDLE;
        }

        for(int i = 1; i <= m; i++){
            count[0][i] = PUDDLE;
        }    
      
        for(int i = 1; i <= n; i++){
            count[i][0] = PUDDLE;
        }

        count[1][1] = 1;

        //  [x][y]를 기준으로 바로 위와 바로 왼쪽에서 오는 것의 합
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= m; y++) {

                if((x == 1 && y == 1) || count[x][y] == PUDDLE) {
                    continue;
                }

                if(count[x - 1][y] == PUDDLE && count[x][y - 1] == PUDDLE){
                    continue;
                }
                else if(count[x - 1][y] == PUDDLE){
                    count[x][y] = count[x][y - 1] % 1000000007;
                }
                else if(count[x][y - 1] == PUDDLE){
                    count[x][y] = count[x - 1][y] % 1000000007;
                }
                else{
                    count[x][y] = (count[x - 1][y] % 1000000007 + count[x][y - 1] % 1000000007) % 1000000007;
                }

            }
        }

        return count[n][m] % 1000000007;
    }
}
