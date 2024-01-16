import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//	BOJ_4179	52708kb	532ms
public class Main_4179 {

	public static class Loc {

		private int x;
		private int y;
		private int time;

		public Loc(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] board = new char[R][C];
		int[][] time = new int[R][C];
		boolean[][] visited = new boolean[R][C];

		int[][] move = { { 0, -1, }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

		Deque<Loc> fireLoc = new ArrayDeque<>(); // 불이 시작되는 위치
		Deque<Loc> loc = new ArrayDeque<>(); // 지훈이 위치

		int init = 1234567;
		int answer = init;

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {

				time[i][j] = init;
				board[i][j] = input.charAt(j);

				// 지훈이의 미로에서의 초기 위치
				if (board[i][j] == 'J') {
					if (i == 0 || j == 0 || i == R - 1 || j == C - 1) {
						answer = 1;
					} else {
						loc.add(new Loc(i, j, 0));
						visited[i][j] = true;
					}
				}
				// 불이 난 공간
				else if (board[i][j] == 'F') {
					fireLoc.add(new Loc(i, j, 0));
					time[i][j] = 0;
				}
			}
		}

		// 미리 불이 확산되는 위치와 시간 파악하기
		if (answer == init) {

			while (!fireLoc.isEmpty()) {

				Loc f = fireLoc.poll();

				for (int j = 0; j < 4; j++) {

					int nx = f.x + move[j][0];
					int ny = f.y + move[j][1];

					// 해당 방향으로 더이상 확산 X
					if (nx < 0 || ny < 0 || nx >= R || ny >= C || board[nx][ny] == '#' || time[nx][ny] != init)
						continue;

					time[nx][ny] = f.time + 1;
					fireLoc.add(new Loc(nx, ny, f.time + 1));

				}

			}
		}

		while (!loc.isEmpty()) {

			Loc jihoon = loc.poll();

			// 다음 칸이 가장자리에 접한 공간 : 탈출
			if (jihoon.x == 0 || jihoon.y == 0 || jihoon.x == R - 1 || jihoon.y == C - 1) {
				answer = jihoon.time + 1;
				break;
			}

			for (int j = 0; j < 4; j++) {

				int nx = jihoon.x + move[j][0];
				int ny = jihoon.y + move[j][1];

				// 벽 or 불 확산 속도 비교
				if (nx < 0 || ny < 0 || nx >= R || ny >= C || board[nx][ny] == '#' || time[nx][ny] <= jihoon.time + 1
						|| visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				loc.add(new Loc(nx, ny, jihoon.time + 1));
			}

		}

		br.close();
		bw.write(answer == init ? "IMPOSSIBLE" : Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
