import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//	BOJ_14940	49896kb	744ms
public class Main_14940 {

	public static class Loc {

		private int x;
		private int y;

		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Queue<Loc> q = new ArrayDeque<>();

		int[][] board = new int[N][M];
		int[][] dist = new int[N][M];
		int[][] move = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

		Loc start = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());

				// 목표 지점
				if (board[i][j] == 2) {
					start = new Loc(i, j);
				}

			}
		}

		//	BFS
		q.add(start);
		while (!q.isEmpty()) {

			Loc now = q.poll();
			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = now.x + move[i][0];
				ny = now.y + move[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || dist[nx][ny] > 0 || board[nx][ny] != 1 || dist[nx][ny] >= dist[now.x][now.y] + board[nx][ny])
					continue;
				
				dist[nx][ny] = dist[now.x][now.y] + board[nx][ny];
				q.add(new Loc(nx, ny));
			}

		}
		
		//	출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(dist[i][j] == 0 && board[i][j] == 1)
					answer.append("-1 ");
				else
					answer.append(dist[i][j]).append(" ");
			}
			answer.append("\n");
		}

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
