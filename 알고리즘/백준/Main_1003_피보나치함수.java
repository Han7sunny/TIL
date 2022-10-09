import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// BOJ 1003 11600kb 76ms
public class Main_1003_피보나치함수 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[][] fibo = new int[41][2]; // 0, 1 호출 횟수
		int beforeN = -1;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			for (int i = beforeN + 1; i <= N; i++) {
				if (i == 0)
					fibo[i][0] = 1;
				else if (i == 1)
					fibo[i][1] = 1;
				else {
					fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
					fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
				}
			}
			answer.append(fibo[N][0]).append(" ").append(fibo[N][1]).append("\n");
			beforeN = Math.max(beforeN, N);
		}

		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
