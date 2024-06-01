import java.io.*;
import java.util.*;

//  BOJ_18428   22232kb 160ms
public class Main_18428 {
    static int N;
    static String board[][];
    static List<Info> teachers;
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  //  장애물 건너편은 볼 수 없다.
    static boolean answer;

    public static class Info {
        private int x;
        private int y;
        private int dir;

        public Info(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void dfs(int count) {
        if(count == 3){
            answer = bfs();
            return;
        }

        //  board[][] = "O"로 만들기
        out: for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(answer)
                    break out;
                if(board[i][j].equals("X")){
                    board[i][j] = "O";
                    dfs(count + 1);
                    board[i][j] = "X";
                }
            }
        }
    }

    public static boolean bfs(){
        Queue<Info> q = new ArrayDeque<>();
        for(Info teacher : teachers){
            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = teacher.x + move[i][0];
                ny = teacher.y + move[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny].equals("O")) continue;

                if(board[nx][ny].equals("S"))
                    return false;

                q.add(new Info(nx, ny, i));
            }

            while(!q.isEmpty()){
                Info now = q.poll();
                nx = now.x + move[now.dir][0];
                ny = now.y + move[now.dir][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny].equals("O")) continue;
                if(board[nx][ny].equals("S"))
                    return false;
                q.add(new Info(nx, ny, now.dir));
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    //  최대 6
        board = new String[N][N];
        teachers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = st.nextToken();   //  S학생 T선생님 X빈칸
                if(board[i][j].equals("T"))
                    teachers.add(new Info(i, j, -1));
            }
        }

        //  3개의 장애물 설치하여 모든 학생들을 감시로부터 피할 수 있는지 계산
        dfs(0);

        br.close();
        bw.write(answer ? "YES" : "NO");
        bw.flush();
        bw.close();
    }
}
