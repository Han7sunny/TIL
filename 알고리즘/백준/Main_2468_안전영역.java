import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// BOJ 2468 16284kb 208ms
public class Main_2468_안전영역 {
	static int N;
	static int[][] map;
	static int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][] visited;

	public static void check(int x, int y, int h) {
		visited[x][y] = true;

		int nx = 0;
		int ny = 0;
		for (int i = 0; i < 4; i++) {
			nx = x + move[i][0];
			ny = y + move[i][1];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N|| visited[nx][ny] || map[nx][ny] <= h)
				continue;
			check(nx, ny, h);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int maxHeight = 0;
		int answer = 0;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(map[i][j], maxHeight);
			}
		}

		for (int height = 0; height < maxHeight; height++) {
			visited = new boolean[N][N];
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > height && !visited[i][j]) { // 안전 영역만 확인하기
						check(i, j, height);
						count++;
					}
				}
			}
			answer = Math.max(answer, count);
		}

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

}
