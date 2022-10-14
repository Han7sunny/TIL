import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// BOJ 22871 12920kb 192ms
public class Main_22871_징검다리_건너기_large {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		long[] stones = new long[N + 1];
		long[] power = new long[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			stones[i] = Long.parseLong(st.nextToken());
			power[i] = Long.MAX_VALUE; // i 까지의 최소값
			
			if (i == 1) {
				power[i] = 0;
				continue;
			}
			
			for (int j = 1; j < i; j++) {
				long p = Math.max(power[j], (i - j) * (1 + Math.abs(stones[j] - stones[i])));
				power[i] = Math.min(power[i], p);
			}
		}

		bw.write(Long.toString(power[N])); // 돌을 한 번 건너갈 때마다 쓸 수 있는 최대 힘 K의 최소값
		br.close();
		bw.flush();
		bw.close();
	}

}