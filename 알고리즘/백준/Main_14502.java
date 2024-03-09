import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//	BOJ_14502	294564kb	792ms
public class Main_14502 {
	static int N, M;
	static int answer;
	static int[][] board;
	static int[][] move = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

	public static class Loc {
		private int x;
		private int y;

		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs() {
		
		Queue<Loc> virus = new ArrayDeque<>();
		int[][] copyBoard = new int[N][M];
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyBoard[i][j] = board[i][j];
				if(copyBoard[i][j] == 0)
					count++;
				else if(copyBoard[i][j] == 2)
					virus.add(new Loc(i, j));
			}
		}
		
		while (!virus.isEmpty()) {
			for (int i = 0; i < virus.size(); i++) {

				Loc now = virus.poll();

				int nx, ny;
				for (int j = 0; j < 4; j++) {
					nx = now.x + move[j][0];
					ny = now.y + move[j][1];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || copyBoard[nx][ny] > 0) continue;
					
					copyBoard[nx][ny] = 2;
					count--;
					virus.add(new Loc(nx, ny));
				}
			}
		}
		
		answer = Math.max(answer, count);
	}
	
	public static void dfs(int count) {
		if(count == 3) {
			bfs();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j] == 0) {
					board[i][j] = 1;
					dfs(count + 1);
					board[i][j] = 0;
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		answer = 0;
		board = new int[N][M];

		// 3개의 벽 새로 세워야 한다. (안 세우는 거 없음)

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//	벽 먼저 세우고
		dfs(0);
		//	바이러스 퍼트려서 안전 영역 count
		

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
