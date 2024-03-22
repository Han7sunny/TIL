import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//	BOJ_2583	13112kb	84ms
public class Main_2583 {

	static int N, M;
	static int[][] move = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	static int[][] board;

	public static int dfs(int x, int y) {

		int result = 1;

		int nx, ny;
		for (int i = 0; i < 4; i++) {

			nx = x + move[i][0];
			ny = y + move[i][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == 1)
				continue;

			board[nx][ny] = 1;
			result += dfs(nx, ny);
		}

		return result;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		int count = 0;
		List<Integer> area = new ArrayList<>();

		for (int k = 0; k < K; k++) {

			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					if (board[i][j] == 1)
						continue;
					board[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					board[i][j] = 1;
					int result = dfs(i, j);
					area.add(result);
					count++;
				}
			}
		}

		Collections.sort(area);

		// Ãâ·Â
		answer.append(count).append("\n");
		for (int i = 0; i < area.size(); i++) {
			answer.append(area.get(i)).append(" ");
		}

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
