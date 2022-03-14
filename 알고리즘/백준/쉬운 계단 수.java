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
		int n = Integer.parseInt(br.readLine());
		long mod = 1000000000;
		long answer = 0;
		long[][] stair = new long[n][10];
		for(int i = 0; i < n; i++) {
			if(i == 0) {
				for(int j = 1; j < 10; j++)
					stair[i][j] = 1;
			}
			else {
				for(int j = 0; j < 10; j++) {
					if (j == 0)
						stair[i][j] = stair[i-1][1] % mod;
					else if(j == 9)
						stair[i][j] = stair[i-1][8] % mod;
					else
						stair[i][j] = (stair[i-1][j-1] % mod + stair[i-1][j+1] % mod) % mod; // 모듈러 연산
				}
					
			}
			if(i == n - 1)
				for(int j = 0; j < 10; j++)
					answer += stair[i][j];
		}
		br.close();
		bw.write(answer % mod+"\n");
		bw.flush();
		bw.close();
	}
}
