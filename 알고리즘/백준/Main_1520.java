import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1520 {
	
	static int[][] move = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
	static int N, M;
	static int[][] dp, map;

	public static int countRoute(int x, int y) {

		if (x == M - 1 && y == N - 1)
			return 1;

		// 탐색한 경로일 경우
		// 초기값 0으로 설정할 경우, 이미 계산해서 0이 나와도 초기값과 같다는 이유로 또 계산할 수 있음
		if (dp[x][y] != -1)
			return dp[x][y];

		dp[x][y] = 0;
		for (int i = 0; i < 3; i++) {

			int nx = x + move[i][0];
			int ny = y + move[i][1];

			if (nx < 0 || ny < 0 || nx >= M || ny >= N || map[x][y] <= map[nx][ny])
				continue;

			dp[x][y] += countRoute(nx, ny);
		}

		return dp[x][y];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 지도의 세로 크기
		N = Integer.parseInt(st.nextToken()); // 지도의 가로 크기

		map = new int[M][N]; // 각 지점의 높이
		dp = new int[M][N]; // 경로의 수

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[i], -1);
		}

		int H = countRoute(0, 0); // 이동 가능한 경로의 수

		br.close();
		bw.write( Integer.toString(H) );
		bw.flush();
		bw.close();
	}

}
