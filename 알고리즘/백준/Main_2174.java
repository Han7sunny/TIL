import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//	BOJ_2174 16188kb 160ms
public class Main_2174 {

	static int[][] board;
	static Map<Integer, Info> robotInfo;
	static String answer = "OK";
	static int A, B;

	public static class Info {

		private int x;
		private int y;
		// 0 : N, 1 : W, 2 : S, 3 : E
		private int dir;

		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Info(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

	}

	public static boolean move(int num, int count) {

		boolean isCrashWall = false;
		Info info = robotInfo.get(num);
		int x = info.x;
		int y = info.y;

		switch (info.dir) {
		case 0: // N
			info.x -= count;
			if (info.x < 0) {
				isCrashWall = true;
				info.x = 0;
			}
			break;
		case 2: // S
			info.x += count;
			if (info.x >= B) {
				isCrashWall = true;
				info.x = B - 1;
			}
			break;

		case 1: // W
			info.y -= count;
			if (info.y < 0) {
				isCrashWall = true;
				info.y = 0;
			}
			break;

		case 3: // E
			info.y += count;
			if (info.y >= A) {
				isCrashWall = true;
				info.y = A - 1;
			}
			break;
		}

		// 다른 로봇과 충돌하는 경우 확인
		switch (info.dir) {
			case 0: // N
				for (int i = x - 1; i >= info.x; i--) {
					if (board[i][info.y] != 0) {
						answer = "Robot " + num + " crashes into robot " + board[i][info.y];
						return true;
					}
				}
				break;
			case 1: // W
				for (int i = y - 1; i >= info.y; i--) {
					if (board[info.x][i] != 0) {
						answer = "Robot " + num + " crashes into robot " + board[info.x][i];
						return true;
					}
				}
				break;
	
			case 2: // S
				for (int i = x + 1; i <= info.x; i++) {
					if (board[i][info.y] != 0) {
						answer = "Robot " + num + " crashes into robot " + board[i][info.y];
						return true;
					}
				}
				break;
			case 3: // E
				for (int i = y + 1; i <= info.y; i++) {
					if (board[info.x][i] != 0) {
						answer = "Robot " + num + " crashes into robot " + board[info.x][i];
						return true;
					}
				}
				break;
		}

		// 주어진 땅 밖으로 벗어나는 경우 확인
		if (isCrashWall) {
			answer = "Robot " + num + " crashes into the wall";
			return true;
		}

		robotInfo.put(num, info);
		board[x][y] = 0;
		board[info.x][info.y] = num;
		return false;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean isInvalid = false;

		A = Integer.parseInt(st.nextToken()); // 땅 가로 길이
		B = Integer.parseInt(st.nextToken()); // 땅 세로 길이

		board = new int[B][A];
		robotInfo = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 로봇 초기 정보
		int M = Integer.parseInt(st.nextToken()); // 명령 개수

		for (int num = 1; num <= N; num++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = (Integer.parseInt(st.nextToken()) - B) * -1;
			Info info = new Info(x, y);
			String dir = st.nextToken();

			if (dir.equals("N"))
				info.dir = 0;
			else if (dir.equals("W"))
				info.dir = 1;
			else if (dir.equals("S"))
				info.dir = 2;
			else // E
				info.dir = 3;

			robotInfo.put(num, info);
			board[info.x][info.y] = num;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String command = st.nextToken();
			int count = Integer.parseInt(st.nextToken());

			// 문제가 없는 경우
			if (!isInvalid) {
				if (command.equals("F")) { // equals로 해야지만 들어옴
					isInvalid = move(num, count);
				} else {

					if (command.equals("R") && count % 2 == 1) {
						count += 2;
					}

					// 회전
					Info info = robotInfo.get(num);
					info.dir = (info.dir + count) % 4;
					robotInfo.put(num, info);
				}
			}

		}

		br.close();
		bw.write(answer);
		bw.flush();
		bw.close();
	}

}
