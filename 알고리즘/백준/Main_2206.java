import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//	BOJ_2206	114832kb 652ms
public class Main_2206 {

	public static class Info{
		private int x;
		private int y;
		private boolean isBreak;
		private int count;

		public Info(int x, int y, boolean isBreak, int count) {
			this.x = x;
			this.y = y;
			this.isBreak = isBreak;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Queue<Info> q = new ArrayDeque<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		boolean[][][] visited = new boolean[N][M][2]; // 0 : 벽 부수지 않은 경우, 1 : 벽 부순 경우
		int[][] move = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

		int answer = -1;

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		q.add(new Info(0, 0, false, 1));
		visited[0][0][0] = true;	//	벽 부수지 않은 0, 0

		// 최단 경로 => BFS
		while (!q.isEmpty()) {

			Info now = q.poll();

			if (now.x == N - 1 && now.y == M - 1) {
				answer = now.count;
				break;
			}

			for (int i = 0; i < 4; i++) {

				int nx = now.x + move[i][0];
				int ny = now.y + move[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (now.isBreak) {
					//	벽 부순 적 있으며 다음 칸이 방문하지 않은 빈 칸인 경우
					if (map[nx][ny] == '0' && !visited[nx][ny][1]) {
						visited[nx][ny][1] = true;
						q.add(new Info(nx, ny, now.isBreak, now.count + 1));
					}
				} else {
					//	벽 부순 적 없으며 다음 칸이 벽인 경우
					if (map[nx][ny] == '1') {
						visited[nx][ny][1] = true;
						q.add(new Info(nx, ny, true, now.count + 1));
					} 
					//	벽 부순 적 없으며 다음 칸이 방문하지 않은 빈 칸인 경우
					else if (!visited[nx][ny][0]) {
						visited[nx][ny][0] = true;
						q.add(new Info(nx, ny, now.isBreak, now.count + 1));
					}

				}

			}
		}

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
