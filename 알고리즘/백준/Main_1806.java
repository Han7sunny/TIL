import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_1806 22788kb 232ms
public class Main_1806 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 100000;	//	부분 합이 S이상인 최소 길이
		
		int N = Integer.parseInt(st.nextToken());	//	수열 길이
		int S = Integer.parseInt(st.nextToken());	//	부분 합 최소값
		int[] sum = new int[N + 1];	//	누적합 배열
		int startIdx = -1;	//	시작 포인터
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sum[i] += sum[i - 1] + Integer.parseInt(st.nextToken());;
			while(sum[i] - sum[startIdx + 1] >= S) {
				startIdx++;
				answer = Math.min(answer, i - startIdx);
			}
		}
		
		br.close();
		bw.write(Integer.toString(answer == 100000 ? 0 : answer));
		bw.flush();
		bw.close();
	}

}
