import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 16948 12216kb 92ms
public class Main_16948_데스나이트 {
	
	static int[][] move = { { -2, -1 }, { -2, 1 }, { 0, -2 }, { 0, 2 }, { 2, -1 }, { 2, 1 } };
	static boolean[][] visited;

	static class Loc {
		int x;
		int y;
		int cnt;

		Loc(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static int bfs(int r1, int c1, int r2, int c2, int N) {

		Queue<Loc> q = new ArrayDeque<>();
		visited[r1][c1] = true;
		q.offer(new Loc(r1, c1, 0));

		while (!q.isEmpty()) {

			Loc now = q.poll();

			if (now.x == r2 && now.y == c2) {
				return now.cnt;
			}

			for (int i = 0; i < 6; i++) {
				int nx = now.x + move[i][0];
				int ny = now.y + move[i][1];

				if (nx < 0 || N <= nx || ny < 0 || N <= ny || visited[nx][ny])
					continue;
				visited[nx][ny] = true;
				q.offer(new Loc(nx, ny, now.cnt + 1));
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());

		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());

		int answer = bfs(r1, c1, r2, c2, N);

		bw.write(Integer.toString(answer)); // 데스 나이트가 (r1, c1)에서 (r2, c2)로 이동하는 최소 이동 횟수, 이동할 수 없는 경우 -1
		br.close();
		bw.flush();
		bw.close();
	}

}
