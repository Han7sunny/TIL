import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//	BOJ_5582	75160kb	204ms
public class Main_5582 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int answer = 0;
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int str1Len = str1.length();
		int str2Len = str2.length();
		
		int[][] dp = new int[str1Len + 1][str2Len + 1];
		
		for (int i = 1; i <= str1Len; i++) {
			for (int j = 1; j <= str2Len; j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					answer = Math.max(answer, dp[i][j]);
				}
			}
		}
		
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
