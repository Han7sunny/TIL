import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {


	static class Loc {
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int[][] board = new int[R][C];
		Queue<Loc> outline = new ArrayDeque<>();
		Queue<Loc> air = new ArrayDeque<>();
		air.offer(new Loc(0, 0));
		int cheezeCnt = 0;
		int time = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken()); // 1 : 치즈 있는 칸
				if (board[i][j] == 1)
					cheezeCnt++;
			}
		}

		while (cheezeCnt > 0) {
			while (!air.isEmpty()) {
				Loc now = air.poll();

				for (int m = 0; m < 4; m++) {
					int nx = now.x + move[m][0];
					int ny = now.y + move[m][1];
					if (nx < 0 || ny < 0 || nx >= R || ny >= C)
						continue;

					if (board[nx][ny] == 1) { // 처음 만나는 치즈 (테두리)
						board[nx][ny] = -1;
						outline.offer(new Loc(nx, ny));
					} else if (board[nx][ny] == 0) {
						board[nx][ny] = -1;
						air.offer(new Loc(nx, ny));
					}
				}
			}
			
			time++;
			if (cheezeCnt - outline.size() == 0) {
				answer.append(time).append("\n");
				answer.append(cheezeCnt); 
				break;
			}
			cheezeCnt -= outline.size(); // 남은 치즈 개수
			air = outline;
			outline = new ArrayDeque<>();
		}

		bw.write(answer.toString()); // 모두 녹아 없어지는데 걸리는 시간, 모두 녹기 한 시간 전에 남아있는 치즈 조각 개수
		br.close();
		bw.flush();
		bw.close();
	}
}
