import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_1954_달팽이숫자 {
	static int[][] move = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int n;
	static int[][] snail;

	public static void snailDraw(int n) {
		// 0인 경우에만 넘어가도록
		// 오른쪽 아래 왼쪽 위 반복
		int cnt = 1;
		int x = 0;
		int y = 0;
		int dir = 0;
		boolean end = false;
		while (cnt <= n*n) {
			snail[x][y] = cnt++;
			
			int nextX = x + move[dir][0];
			int nextY = y + move[dir][1];
			
			if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n)
				end = true;
			else if(snail[nextX][nextY] != 0)
				end = true;
			
			if (end) {
				dir++;
				dir %= 4;
				end = false;
			}
			x = x + move[dir][0];
			y = y + move[dir][1];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			n = Integer.parseInt(br.readLine());
			snail = new int[n][n];
			snailDraw(n);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append("\n");
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					sb.append(snail[i][j]);
					if(j < n - 1)
						sb.append(" ");
				}
				sb.append("\n");
			}
			bw.write(sb.toString());
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
