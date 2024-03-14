import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_14500	32340kb	520ms
public class Main_14500 {

	static int N, M, answer;
	static int[][] board;
	static int[][][] tetromino = { 
			{ { 0, 3 }, { 0, 2 }, { 0, 1 } }, { { 3, 0 }, { 2, 0 }, { 1, 0 } },	 //	파란색
			{ { 1, 1 }, { 1, 0 }, { 0, 1 } },	//	노란색
			{ { 2, 1 }, { 2, 0 }, { 1, 0 } }, { { 0, 2 }, { 1, 0 }, { 0, 1 } },
			{ { -1, 2 }, { 0, 2 }, { 0, 1 } }, { { 2, 1 }, { 1, 1 }, { 0, 1 } }, { { -2, 1 }, { -1, 1 }, { 0, 1 } },
			{ { 1, 2 }, { 0, 2 }, { 0, 1 } }, { { 1, 2 }, { 1, 1 }, { 1, 0 } }, { { 1, 0 }, { 2, 0 }, { 0, 1 } },	//	주황색
			{ { 1, 1 }, { 2, 1 }, { 1, 0 } }, { { 1, 2 }, { 1, 1 }, { 0, 1 } }, { { -1, 2 }, { -1, 1 }, { 0, 1 } }, { { -1, 1 }, { 1, 0 }, { 0, 1 } },	//	초록색
			{ { 0, 2 }, { 1, 1 }, { 0, 1 } }, { { -1, 1 }, { 0, 2 }, { 0, 1 } }, { { 2, 0 }, { 1, 1 }, { 1, 0 } }, { { -1, 1 }, { 1, 1 }, { 0, 1 } }	//	분홍색
			};

	// 테트로미노 순번, idx, 시작점 위치 x, y
	public static int dfs(int x, int y, int t, int idx, int sum) {
		
		if(idx == 3) {
			return sum;
		}

		int nx = x + tetromino[t][idx][0];
		int ny = y + tetromino[t][idx][1];

		if (nx < 0 || ny < 0 || nx >= N || ny >= M)
			return 0;

		return dfs(x, y, t, idx + 1, sum + board[nx][ny]);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		answer = 0;

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int t = 0; t < 19; t++) {
					answer = Math.max(answer, dfs(i, j, t, 0, board[i][j]));
				}
			}
		}
		
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
