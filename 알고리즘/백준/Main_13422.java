import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_13422 118716kb 620ms
public class Main_13422 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 집 개수
			int M = Integer.parseInt(st.nextToken()); // 연속된 집 개수
			int K = Integer.parseInt(st.nextToken()); // 최소 돈의 양

			int[] sum = new int[N + 1];
			int count = 0;

			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= N; i++) {
				sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());

				if (i >= M && sum[i] - sum[i - M] < K)
					count++;
			}
			
			// 첫 번째 집과 마지막 집 이웃 확인
			if (M < N) {
				for (int i = 1; i < M; i++) {
					if (sum[i] + sum[N] - sum[N - M + i] < K)
						count++;
				}
			}
			
			answer.append(count).append("\n");
		}

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
