import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드 {
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // U D L R
	static char[][] map;
	static int H, W;

	public static void shoot(int x, int y, int moveIdx) {
		// 현재 방향에서 앞에 벽이 아무것도 없다면 포탄 걍 사라짐(끝까지 나가니까)
		int start = 0;
		int end = 0;

		switch (moveIdx) {
		case 0: // U
			start = x + move[moveIdx][0];
			for (int i = start; i >= 0; i--) {
				if (map[i][y] == '*') { // 벽돌 벽
					map[i][y] = '.';
					break;
				} else if (map[i][y] == '#') // 강철 벽
					break;
			}
			break;
		case 1: // D
			start = x + move[moveIdx][0];
			end = H;
			for (int i = start; i < end; i++) {
				if (map[i][y] == '*') { // 벽돌 벽
					map[i][y] = '.';
					break;
				} else if (map[i][y] == '#') // 강철 벽
					break;
			}
			break;
		case 2:// L
			start = y + move[moveIdx][1];
			for (int i = start; i >= 0; i--) {
				if (map[x][i] == '*') { // 벽돌 벽
					map[x][i] = '.';
					break;
				} else if (map[x][i] == '#') // 강철 벽
					break;
			}
			break;
		case 3: // R
			start = y + move[moveIdx][1];
			end = W;
			for (int i = start; i < end; i++) {
				if (map[x][i] == '*') { // 벽돌 벽
					map[x][i] = '.';
					break;
				} else if (map[x][i] == '#') // 강철 벽
					break;
			}
			break;
		}
	}

	public static boolean isMove(int x, int y, int moveIdx) {
		int nextX = x + move[moveIdx][0];
		int nextY = y + move[moveIdx][1];
		if (0 <= nextX && nextX < H && 0 <= nextY && nextY < W) {
			if (map[nextX][nextY] == '.') // 평지
				return true;
		}
		return false;
	}

	public static void main(String args[]) throws Exception {

//		BufferedReader br = new BufferedReader(
//				new FileReader("C:\\SSAFY\\workspace\\workshop\\Algorithm\\0803\\src\\input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T;
		T = Integer.parseInt(br.readLine());

		int moveIdx = 0;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()); // 높이
			W = Integer.parseInt(st.nextToken()); // 너비
			map = new char[H][W];
			int x = 0;
			int y = 0;
			for (int i = 0; i < H; i++) {
				String input = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = input.charAt(j);
					if (map[i][j] != '.' && map[i][j] != '*' && map[i][j] != '#' && map[i][j] != '-') {

						if (map[i][j] == '^')
							moveIdx = 0;
						else if (map[i][j] == 'v')
							moveIdx = 1;
						else if (map[i][j] == '<')
							moveIdx = 2;
						else // map[i][j] == '>'
							moveIdx = 3;
						x = i;
						y = j;
					}
				}
			}
			map[x][y] = '.'; // 현재 위치 평지로 바꿔주기
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			for (int i = 0; i < N; i++) {
				switch (str.charAt(i)) {
				// 방향 먼저 바꾸고 다음이 평지면 이동, 회전이 아니라 그냥 바로 그 위치를 향하도록
				case 'U':
					moveIdx = 0;
					if (isMove(x, y, moveIdx))
						x += move[moveIdx][0];
					break;
				case 'D':
					moveIdx = 1;
					if (isMove(x, y, moveIdx))
						x += move[moveIdx][0];
					break;
				case 'L':
					moveIdx = 2;
					if (isMove(x, y, moveIdx))
						y += move[moveIdx][1];
					break;
				case 'R':
					moveIdx = 3;
					if (isMove(x, y, moveIdx))
						y += move[moveIdx][1];
					break;
				case 'S':
					// 현재 바라보고 있는 방향을 향해 포탄 발사
					shoot(x, y, moveIdx);
					break;
				}
			}

			StringBuilder result = new StringBuilder();
			result.append("#").append(test_case).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(i == x && j == y) {
						switch(moveIdx) {
						case 0: // U 
							map[i][j] = '^';
							break;
						case 1: // D
							map[i][j] = 'v';
							break;
						case 2: // L
							map[i][j] = '<';
							break;
						case 3: // R
							map[i][j] = '>';
							break;
						}
					}
					result.append(map[i][j]);
				}
				if(i < H - 1)
					result.append("\n");
			}
			bw.write(result.toString() + "\n");

		}
		br.close();
		bw.flush();
		bw.close();
	}

}
