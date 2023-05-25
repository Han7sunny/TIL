import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_11052 12452kb 112ms
public class Main_11052 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
				
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			dp[i] = Integer.parseInt(st.nextToken());

			//	i까지의 최대값
			for (int j = 1; j < i; j++) {

				if(i % j == 0) 
					dp[i] = Math.max(dp[j] * i / j, dp[i]);
				else 
					dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
				
			}
		}
		//	N가지 가질 수 있는 경우 중 최대값
		
		br.close();
		bw.write(Integer.toString(dp[N]));
		bw.flush();
		bw.close();
		
	}

}
