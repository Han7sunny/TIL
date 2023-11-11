import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//	BOJ_9251 16160kb 116ms
public class Main_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input1 = br.readLine();
		String input2 = br.readLine();
		
		int length1 = input1.length();
		int length2 = input2.length();

		char[] str1 = new char[length1 + 1];
		char[] str2 = new char[length2 + 1];
		
		for (int i = 1; i <= length1; i++) {
			str1[i] = input1.charAt(i - 1);
		}
		
		for (int i = 1; i <= length2; i++) {
			str2[i] = input2.charAt(i - 1);
		}
		
		int[][] dp = new int[length1 + 1][length2 + 1];
		
		for (int i = 1; i <= length1; i++) {
			for (int j = 1; j <= length2; j++) {
				if(str1[i] == str2[j])
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		
		br.close();
		bw.write(Integer.toString(dp[length1][length2]));
		bw.flush();
		bw.close();
	}

}
