import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1210_Ladder1 {
	static int[][] move = { { 0, -1 }, { 0, 1 }, { -1, 0 } };
	static int[][] map;
	static int answer = 0;

	public static void start(int x, int y) {
		if (x == 0) {
			answer = y;
			return;
		}
		
		map[x][y] = 0;
		
		int nextX;
		int nextY;
		boolean side = false;
		for (int i = 0; i < 2; i++) {
			nextX = x + move[i][0];
			nextY = y + move[i][1];
			if (0 <= nextX && nextX < 100 && 0 <= nextY && nextY < 100) {
				if (map[nextX][nextY] != 0) {
					start(nextX, nextY);
					side = true;
				}
			}
		}
		
		if(!side) {
			start(x - 1, y); // 위로
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(
				new FileReader("C:\\SSAFY\\workspace\\workshop\\Algorithm\\0802\\src\\input2.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int t = Integer.parseInt(br.readLine());
			map = new int[100][100];
			int startY = 0;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						startY = j;
					}
						
				}
			}
			start(99, startY);

			bw.write("#" + t + " " + answer + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
