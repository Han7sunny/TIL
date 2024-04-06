import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//	BOJ_21921	53500kb	444ms
public class Main_21921 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()); // 블로그 시작하고 지난 일수
		int X = Integer.parseInt(st.nextToken()); // 방문자 수 확인 기간

		Map<Integer, Integer> visitor = new HashMap<>();
		int[] sum = new int[N + 1];	//	누적합 배열
		int max = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
			if (i >= X) {
				int visitorSum = sum[i] - sum[i - X];
				visitor.put(visitorSum, visitor.getOrDefault(visitorSum, 0) + 1);
				max = Math.max(max, visitorSum);
			}
		}

		if (max == 0)
			answer.append("SAD");
		else
			answer.append(max).append("\n").append(visitor.get(max));
		

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
