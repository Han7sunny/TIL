import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// SWEA 26360kb 130ms
public class Solution_3282 {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 믈건 개수
			int K = Integer.parseInt(st.nextToken()); // 가방 부피
			
			// 고려해야할 변수 2개 -> 2차원 배열
			int[][] input = new int[N+1][2];
			int[][] dp = new int[N+1][K+1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				input[i][0] = Integer.parseInt(st.nextToken()); // 부피
				input[i][1] = Integer.parseInt(st.nextToken());	// 가치
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= K; j++) {
					//	j : 가방의 부피
					
					// 물건의 부피가 현재 가방의 부피보다 같거나 작으면 다른 물건과 배낭에 같이 들어갈 수 있음
					if(j >= input[i][0]) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - input[i][0]] + input[i][1]);
					}
					else
						dp[i][j] = dp[i-1][j];
				}
			}
			answer.append("#").append(test_case).append(" ").append(dp[N][K]).append("\n");
		}
		
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
