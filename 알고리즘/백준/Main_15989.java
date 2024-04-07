import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//	BOJ_15989	12196kb	88ms
public class Main_15989 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int[][] dp = new int[10001][4];
		dp[1][1] = 1; // 1
		dp[2][1] = 1; // 1 + 1
		dp[2][2] = 1; // 2
		dp[3][1] = 1; // 1 + 1 + 1
		dp[3][2] = 1; // 1 + 2
		dp[3][3] = 1; // 3

		int pre = 3;

		for (int tc = 0; tc < T; tc++) {

			
			int n = Integer.parseInt(br.readLine()); // ÃÖ´ë 10000

			if (pre < n) {
				for (int i = pre + 1; i <= n; i++) {
					dp[i][1] = dp[i - 1][1];
					dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
					dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
				}
				pre = n;
			}

			answer.append(dp[n][1] + dp[n][2] + dp[n][3]).append("\n");
		}

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
