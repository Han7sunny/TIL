import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	SWEA_3304 37,888kb 172ms
public class Solution_3304 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());

			String s1 = st.nextToken();
			String s2 = st.nextToken();

			int s1Length = s1.length();
			int s2Length = s2.length();
			
			int[][] dp = new int[s1Length + 1][s2Length + 1];
			
			for (int i = 1; i <= s1Length; i++) {
				for (int j = 1; j <= s2Length; j++) {
					if(s1.charAt(i-1) != s2.charAt(j-1))
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					else
						dp[i][j] = dp[i-1][j-1] + 1;
				}
			}
			// 최대 공통 부분 수열 길이
			answer.append("#").append(test_case).append(" ").append(dp[s1Length][s2Length]).append("\n");
		}
		
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
