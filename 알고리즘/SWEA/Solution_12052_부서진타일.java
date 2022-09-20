import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_12052_부서진타일 {
	static int N, M;
	static Character[][] tiles;
	static int brokeCnt;

	public static int checkTiles(int x, int y) {
		if (x + 1 < N && y + 1 < M) {
			if (tiles[x][y] == '#' && tiles[x][y + 1] == '#' && tiles[x + 1][y] == '#'
					&& tiles[x + 1][y + 1] == '#') {
				tiles[x][y] = '.';
				tiles[x][y + 1] = '.';
				tiles[x + 1][y] = '.';
				tiles[x + 1][y + 1] = '.';
				brokeCnt -= 4;
				if (brokeCnt % 4 != 0)
					return -1;
				else if (brokeCnt == 0)
					return 1;
				else
					return 0;
			} else
				return -1;
		} else
			return -1;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean isPossible = false;
			brokeCnt = 0;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			tiles = new Character[N][M];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < M; j++) {
					tiles[i][j] = input.charAt(j);
					if (tiles[i][j] == '#') {
						brokeCnt++;
					}
				}
			}
			if(brokeCnt == 0)
				isPossible = true;
			else if (brokeCnt % 4 == 0) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						// brokeCnt가 0이면 true하고 break;
						// brokeCnt가 4로 나누어 떨어지지 않으면 false하고 break;
						if (tiles[i][j] == '#') {
							int check = checkTiles(i, j);
							if(check == 1) {
								isPossible = true;
								break;
							}else if(check == -1) {
								break;
							} // 0이면 계속 탐색
							
						}

					}
				}
			}
			answer.append("#").append(test_case).append(" ").append(isPossible ? "YES" : "NO").append("\n");
		}
		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}
}
