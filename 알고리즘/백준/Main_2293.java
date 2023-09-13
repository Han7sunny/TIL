import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//	BOJ_2293 12004kb 88ms
public class Main_2293 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//	동전 개수
		int K = Integer.parseInt(st.nextToken());	//	가치의 합
		
		int[] dp = new int[K + 1];
		dp[0] = 1;
		
		//	동전들을 이용해서 가치의 합을 만들 수 있는 경우의 수
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(br.readLine());
			for (int j = value; j <= K; j++) {
				dp[j] += dp[j - value];
			}			
		}
		
		br.close();
		bw.write(Integer.toString(dp[K]));
		bw.flush();
		bw.close();
		
	}

}
