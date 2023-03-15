import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// BOJ 14888 13520kb 84ms
public class Main_14888 {

	static int N, min, max;
	static int[] num;

	public static void solution(int result, int[] op, int k) {
		
		if (k == N) {
			min = Math.min(result, min);
			max = Math.max(result, max);
			return;
		}

		// 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수
		for (int i = 0; i < 4; i++) {
			if (op[i] == 0)
				continue;

			op[i]--;

			if (i == 0)
				solution(result + num[k], op, k + 1);
			else if (i == 1)
				solution(result - num[k], op, k + 1);
			else if (i == 2)
				solution(result * num[k], op, k + 1);
			else
				solution(result / num[k], op, k + 1);
			op[i]++;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		num = new int[N];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE; // 0으로 설정하면 틀림

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 수열 A1, A2, ..., AN
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		// 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수
		int[] op = new int[4];
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		solution(num[0], op, 1);
		
		// 식의 최대 최소 구하기
		answer.append(max).append("\n").append(min);
		
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
