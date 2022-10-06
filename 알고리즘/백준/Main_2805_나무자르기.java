import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805_나무자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long[] height = new long[N];
		long max = -1;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			height[i] = Long.parseLong(st.nextToken());
			max = Math.max(max, height[i]);
		}

		long start = 0;
		long end = max;

		long answer = 0;
		while (start <= end) {
			long sum = 0;
			long maxHeight = (start + end) / 2;

			for (int i = 0; i < N; i++) {
				if (height[i] > maxHeight)
					sum += height[i] - maxHeight;
			}

			if (sum >= M) {
				start = maxHeight + 1;
				answer = maxHeight;
			} else {
				end = maxHeight - 1;
			}
		}

		bw.write(Long.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}
}
