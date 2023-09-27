import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//	BOJ_2589 169680kb 444ms
public class Main_2589 {

	public static class Loc {
		private int x;
		private int y;
		private int dist;

		public Loc(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 보물 지도 세로 크기
		int M = Integer.parseInt(st.nextToken()); // 보물 지도 가로 크기

		Queue<Loc> q = new ArrayDeque<>();

		int answer = 0;
		boolean[][] visited;
		char[][] map = new char[N][M];
		int[][] move = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {

					visited = new boolean[N][M];
					visited[i][j] = true;
					q.add(new Loc(i, j, 0));

					while (!q.isEmpty()) {

						Loc loc = q.poll();

						for (int k = 0; k < 4; k++) {

							int nx = loc.x + move[k][0];
							int ny = loc.y + move[k][1];

							if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == 'W')
								continue;

							visited[nx][ny] = true;
							q.add(new Loc(nx, ny, loc.dist + 1));
							answer = Math.max(answer, loc.dist + 1);
						}
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
