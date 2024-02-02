import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_2169	84812kb	540ms
public class Main_2169 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] board = new int[N][M];
		int[][] sum = new int[N][M];
		int[][] tmp = new int[2][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// ¿Þ -> ¿À
		sum[0][0] = board[0][0];
		for (int i = 1; i < M; i++) {
			sum[0][i] = sum[0][i - 1] + board[0][i];
		}

		for (int i = 1; i < N; i++) {

			// ¿Þ -> ¿À tmp[0][?]
			// ¿Þ <- ¿À tmp[1][?]
			tmp[0][0] = sum[i - 1][0] + board[i][0];
			tmp[1][M - 1] = sum[i - 1][M - 1] + board[i][M - 1];
			for (int j = 1; j < M; j++) {
				tmp[0][j] = Math.max(sum[i - 1][j], tmp[0][j - 1]) + board[i][j];
				tmp[1][M - j - 1] = Math.max(sum[i - 1][M - j - 1], tmp[1][M - j]) + board[i][M - j - 1];
			}

			for (int j = 0; j < M; j++) {
				sum[i][j] = Math.max(tmp[0][j], tmp[1][j]);
			}

		}

		br.close();
		bw.write(Integer.toString(sum[N - 1][M - 1]));
		bw.flush();
		bw.close();
	}

}
