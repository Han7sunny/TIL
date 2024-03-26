import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_4920	18632kb	176ms
public class Main_4920 {

	static int[][][] block = { { { 0, 3 }, { 0, 2 }, { 0, 1 } }, { { 1, 2 }, { 1, 1 }, { 0, 1 } },
			{ { 1, 2 }, { 0, 2 }, { 0, 1 } }, { { 0, 2 }, { 1, 1 }, { 0, 1 } }, { { 1, 1 }, { 0, 1 }, { 1, 0 } } };
	static int[] count = { 2, 2, 4, 4, 1 };
	static int[][][] board;
	static int N, max;

	public static int[][] rotate(int idx) {
		int[][] result = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] = board[idx][j][N - i - 1];
			}
		}
		
		return result;
	}

	public static void tetris(int x, int y) {

		//	i번째 block을 count[i]번 회전해서(board[count[i]][nx][ny]) 비교
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < count[i]; j++) {
				// board[j][][]에 block 맞춰보기
				
				int sum = board[j][x][y];
				boolean isPossible = true;
				
				for (int k = 0; k < 3; k++) {
					int nx = x + block[i][k][0];
					int ny = y + block[i][k][1];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
						isPossible = false;
						break;
					}
					
					sum += board[j][nx][ny];
					
				}
				
				//	음수값 존재하기 때문에 boolean 타입으로 확인하기
				if(isPossible)
					max = Math.max(max, sum);
				
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		int testCase = 1;

		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 0)
				break;

			max = Integer.MIN_VALUE;
			board = new int[4][N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[0][i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// board 회전
			for (int i = 1; i < 4; i++) {
				board[i] = rotate(i - 1);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tetris(i, j);
				}
			}

			answer.append(testCase).append(". ").append(max).append("\n");
			testCase++;
		}

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();

	}

}
