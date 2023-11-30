import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//	BOJ_2665 13320kb 104ms
//	https://www.acmicpc.net/problem/2665

public class Main_2665 {

	static int N;
	static int[][] move = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	static char[][] room;
	static int[][] count;

	public static class Loc {

		private int x;
		private int y;

		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void search(int x, int y) {

		count[x][y] = 0;
		Queue<Loc> q = new ArrayDeque<>();
		q.offer(new Loc(x, y));

		while (!q.isEmpty()) {

			Loc now = q.poll();

			for (int i = 0; i < 4; i++) {

				int nx = now.x + move[i][0];
				int ny = now.y + move[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || count[nx][ny] <= count[now.x][now.y])
					continue;

				if (room[nx][ny] == '1')
					count[nx][ny] = count[now.x][now.y];
				else
					count[nx][ny] = count[now.x][now.y] + 1;

				q.offer(new Loc(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // 최대 50
		int INF = 987654321;

		room = new char[N][N];
		count = new int[N][N]; // 검은 방을 흰 방으로 바꾼 개수

		for (int i = 0; i < N; i++) {
			Arrays.fill(count[i], INF);
			room[i] = br.readLine().toCharArray();
		}

		search(0, 0);

		br.close();
		bw.write(Integer.toString(count[N - 1][N - 1]));
		bw.flush();
		bw.close();

	}

}
