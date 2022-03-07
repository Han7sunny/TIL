import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] house = new int[N][3];
		int[][] dp = new int[N][3];
		int answer= Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			String[] rgb = br.readLine().split(" "); // 빨0 초1 파2 색깔
			house[i][0] = Integer.parseInt(rgb[0]);
			house[i][1] = Integer.parseInt(rgb[1]);
			house[i][2] = Integer.parseInt(rgb[2]);
			if(i == 0) {
				dp[i][0] = house[i][0];
				dp[i][1] = house[i][1];
				dp[i][2] = house[i][2];
			}
			else {
				dp[i][0] = house[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
				dp[i][1] += house[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
				dp[i][2] += house[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
			}
			if(i == N - 1) {
				for(int j = 0; j < 3; j++)
					answer = answer > dp[i][j] ? dp[i][j] : answer;
			}
		}
		br.close();
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}
}
