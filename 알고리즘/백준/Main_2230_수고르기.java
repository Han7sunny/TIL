import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ 2230 23604kb 280ms
public class Main_2230_수고르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] A = new long[N];
		long answer = Long.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(A);

		int start = 0;
		int end = 0;
		// 투 포인터
		while (end < N) {
			if(A[end] - A[start] < M)
				end++;
			else if(A[end] - A[start] == M) {
				answer = M;
				break;
			}else {
				answer = Math.min(answer, A[end] - A[start]);
				start++;
			}
			
			
		}
		bw.write(Long.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

}
