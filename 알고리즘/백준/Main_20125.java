import java.io.*;

//  BOJ_20125   20140ms 220ms
public class Main_20125 {

    static int N;
    static char[][] board;
    static int[][] move = {{0, -1}, {0, 1}, {1, 0}};

    public static class Loc {

        private int x;
        private int y;

        public Loc(int x,  int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int dfs(int x, int y, int dir){
        int length = 1;

        board[x][y] = '_';
        int nx = x + move[dir][0];
        int ny = y + move[dir][1];

        if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == '_')
            return length;

        length += dfs(nx, ny, dir);

        return length;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(br.readLine());    //  최대 1000

        board = new char[N][N];
        Loc heart = null;

        for (int i = 0; i < N; i++){
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j);
                if(board[i][j] == '*' && heart == null){    //  머리 위치
                    heart = new Loc(i + 1, j);
                    board[i][j] = '_';
                    board[heart.x][heart.y] = '_';
                }
            }
        }

        //  심장의 위치
        answer.append(heart.x + 1).append(" ").append(heart.y + 1).append("\n");

        //  왼쪽 팔
        answer.append(dfs(heart.x, heart.y - 1, 0)).append(" ");

        //  오른쪽 팔
        answer.append(dfs(heart.x, heart.y + 1, 1)).append(" ");

        //  허리
        int waistLength = dfs(heart.x + 1, heart.y, 2);
        Loc waistEnd = new Loc(heart.x + waistLength, heart.y);
        answer.append(waistLength).append(" ");

        //  오른쪽 다리
        answer.append(dfs(waistEnd.x + 1, waistEnd.y - 1, 2)).append(" ");

        //  왼쪽 다리
        answer.append(dfs(waistEnd.x + 1, waistEnd.y + 1, 2));


        br.close();
        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
}
