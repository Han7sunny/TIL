import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// BOJ 10844 11656kb 76ms
public class Main_10844_쉬운계단수 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		long answer = 0;
		long mod = 1000000000;
		long[][] num = new long[N + 1][10]; // 0-9

		if (N == 1)
			answer = 9;
		else {
			Arrays.fill(num[1], 1);
			num[1][0] = 0;
			for (int i = 2; i <= N; i++) {
				num[i][0] = num[i-1][1] % mod;
				for (int j = 1; j < 9; j++) {
					num[i][j] = (num[i-1][j-1] % mod + num[i-1][j+1] % mod ) % mod;
				}
				num[i][9] = num[i-1][8] % mod;
			}

			for (int i = 0; i < 10; i++) {
				answer += num[N][i];
				answer %= mod;
			}
		}
		bw.write(Long.toString(answer % mod));
		br.close();
		bw.flush();
		bw.close();
	}

}
