import java.io.*;
import java.util.*;

public class Softeer_6281 {

    public static class Loc {

        private int x;
        private int y;

        public Loc(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Loc> q = new ArrayDeque<>();
        Queue<Loc> ice = new ArrayDeque<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        int[][] count = new int[N][M]; // 외부 공기와 접촉하는 변의 수
        int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        int answer = 0;
        

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1){
                    ice.add(new Loc(i, j));
                }
            }
        }

        board[0][0] = -1;
        q.add(new Loc(0, 0));
        
        while(!ice.isEmpty()){

            // 외부 공기 확산
            while(!q.isEmpty()) {
                
                Loc now = q.poll(); // -1

                int nx, ny;
                for(int i = 0; i < 4; i++){
                    nx = now.x + move[i][0];
                    ny = now.y + move[i][1];
                    
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == -1) continue;
    
                    if(board[nx][ny] == 0){
                        board[nx][ny] = -1;
                        q.add(new Loc(nx, ny));
                    }
                    else
                        count[nx][ny]++;
                }
                
            }

            // 얼음 확인
            int size = ice.size();
            for(int i = 0; i < size; i++){
                
                Loc now = ice.poll();

                if(count[now.x][now.y] >= 2){
                    board[now.x][now.y] = -1;
                    q.add(now);
                }
                else
                    ice.add(now);
            }
            

            answer++;
        
        }
        
        br.close();
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        
    }
}
