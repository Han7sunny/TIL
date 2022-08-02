import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_2805_농작물수확하기 {
	static int[][] farm;
	static int n;

	public static int valueSum(int x, int y, int idx) {
		int sum = 0;
		if (0 <= y - idx && y + idx < n) {
			for (int i = y - idx; i <= y + idx; i++)
				sum += farm[x][i];
			
			if(x == n - 1)
				return sum;
						
			if (x < n / 2)
				sum += valueSum(x + 1, y, idx + 1);
			else
				sum += valueSum(x + 1, y, idx - 1);
		}
		return sum;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			farm = new int[n][n];
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					farm[i][j] = s.charAt(j) - 48;
				}
			}
			int answer = valueSum(0, n / 2, 0);
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
