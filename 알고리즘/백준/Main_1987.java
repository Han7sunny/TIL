import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1987 {

	static int answer = 0;
	static int R, C;
	static char[][] board;
	static boolean[] checkedAlp;
	static int[][] move = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

	// 12448kb 884ms
	public static void moveBoard1(int x, int y, int count) {

		answer = Math.max(answer, count);

		for (int i = 0; i < 4; i++) {

			int nx = x + move[i][0];
			int ny = y + move[i][1];

			if (nx < 0 || ny < 0 || nx >= R || ny >= C || checkedAlp[board[nx][ny]])
				continue;

			checkedAlp[board[nx][ny]] = true;
			moveBoard1(nx, ny, count + 1);
			checkedAlp[board[nx][ny]] = false;
		}

	}

	// 12472kb 932ms
	public static int moveBoard2(int x, int y, int count) {

		int max = count;

		for (int i = 0; i < 4; i++) {

			int nx = x + move[i][0];
			int ny = y + move[i][1];

			if (nx < 0 || ny < 0 || nx >= R || ny >= C || checkedAlp[board[nx][ny]])
				continue;

			checkedAlp[board[nx][ny]] = true;
			max = Math.max(max, moveBoard2(nx, ny, count + 1));
			checkedAlp[board[nx][ny]] = false;

		}

		return max;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		checkedAlp = new boolean[91]; // Z : 90

		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}

		checkedAlp[board[0][0]] = true;

		moveBoard1(0, 0, 1);
//		answer = moveBoard2(0, 0, 1);

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
