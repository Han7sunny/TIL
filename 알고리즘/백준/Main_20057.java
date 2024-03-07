import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_20057	35924kb	460ms
public class Main_20057 {

	static int N;
	static int[][] sand;
	static int[][] tMove = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } }; // 토네이도 이동
	static int[][][] sMove = {
			{ { -1, 0 }, { 1, 0 }, { -1, -1 }, { 1, -1 }, { -1, -2 }, { 1, -2 }, { -2, -1 }, { 2, -1 }, { 0, -3 },
					{ 0, -2 } },
			{ { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 1 }, { 2, -1 }, { 2, 1 }, { 1, -2 }, { 1, 2 }, { 3, 0 }, { 2, 0 } },
			{ { -1, 0 }, { 1, 0 }, { -1, 1 }, { 1, 1 }, { -1, 2 }, { 1, 2 }, { -2, 1 }, { 2, 1 }, { 0, 3 }, { 0, 2 } },
			{ { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { -3, 0 },
					{ -2, 0 } }

	}; // 모래 이동, [dir][이동 x][이동 y]
	static double[] ratio = { 0.01, 0.01, 0.07, 0.07, 0.1, 0.1, 0.02, 0.02, 0.05 };
	
	static int dir = 0; // 토네이도 방향
	static int count = 1; // 이동하는 칸의 수
	static int answer = 0; // 격자 밖으로 나간 모래 양

	public static void moveTornado(int x, int y) {

		while (true) {

			for (int cnt = 0; cnt < count; cnt++) {

				if (x == 0 && y == 0)
					return;
				// 토네이도 (0,0)까지 이동한 뒤 소멸

				int nx, ny;
				int currentSand = sand[x + tMove[dir][0]][y + tMove[dir][1]]; // y의 모래 양
				// 다음으로 이동 (y로 이동)
				for (int i = 0; i < 9; i++) {

					int s = (int) (currentSand * ratio[i]);

					nx = x + sMove[dir][i][0];
					ny = y + sMove[dir][i][1];

					// 격자 밖으로 나간 모래
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						answer += s;
					} else {
						sand[nx][ny] += s;
					}

					sand[x + tMove[dir][0]][y + tMove[dir][1]] -= s;

				}

				int ax = x + sMove[dir][9][0];
				int ay = y + sMove[dir][9][1];

				if (ax < 0 || ay < 0 || ax >= N || ay >= N) {
					answer += sand[x + tMove[dir][0]][y + tMove[dir][1]];
				} else {
					sand[ax][ay] += sand[x + tMove[dir][0]][y + tMove[dir][1]];
				}

				sand[x + tMove[dir][0]][y + tMove[dir][1]] = 0;

				// 토네이도 한 칸 이동
				x += tMove[dir][0];
				y += tMove[dir][1];
			}

			if (dir % 2 == 1) {
				count++;
			}

			dir = (dir + 1) % 4;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 모래밭 크기 N*N

		sand = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				sand[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// startX, startY
		moveTornado(N / 2, N / 2);

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
