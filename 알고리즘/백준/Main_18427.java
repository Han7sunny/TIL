import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//	BOJ_18427 16608kb 148ms
public class Main_18427 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//	학생 수
		int M = Integer.parseInt(st.nextToken());	//	최대 블록 개수
		int H = Integer.parseInt(st.nextToken());	//	탑의 높이
		
		List<Integer>[] blockHeight = new ArrayList[N + 1];
		int[][] dp = new int[N + 1][H + 1];
		
		for (int i = 1; i <= N; i++) {
			blockHeight[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				blockHeight[i].add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(blockHeight[i]);
		}
		
		dp[0][0] = 1;
		
		for (int i = 1; i <= N; i++) {
			
			dp[i][0] = 1;
			for (int j = 1; j < blockHeight[i].get(0); j++)
				dp[i][j] = dp[i - 1][j];
			
			for (int j = blockHeight[i].get(0); j <= H; j++) {
				for(int h : blockHeight[i]) {
					if(j < h)
						break;
					dp[i][j] += dp[i - 1][j - h] % 10007;
				}
				dp[i][j] += dp[i - 1][j] % 10007;
			}
			

		}
		
		br.close();
		bw.write(Integer.toString(dp[N][H] % 10007));
		bw.flush();
		bw.close();
	}

}
