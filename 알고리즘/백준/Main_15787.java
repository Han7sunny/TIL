import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//	BOJ_15787 37836kb 356ms
public class Main_15787 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] train = new int[N + 1];

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			String comm = st.nextToken();
			int trainNum = Integer.parseInt(st.nextToken());

			switch (comm) {

			case "1":
				int in = Integer.parseInt(st.nextToken()) - 1;
				train[trainNum] = train[trainNum] | (1 << in);
				break;

			case "2":
				int out = Integer.parseInt(st.nextToken()) - 1;
				train[trainNum] = train[trainNum] & ~(1 << out);
				break;

			case "3":
				train[trainNum] = train[trainNum] << 1;
				train[trainNum] &= ((1 << 20) - 1);
				break;

			case "4":
				train[trainNum] = train[trainNum] >> 1;
				break;
			}

		}

		Set<Integer> pass = new HashSet<>();

		for (int i = 1; i <= N; i++) {
			pass.add(train[i]);
		}

		br.close();
		bw.write(Integer.toString(pass.size()));
		bw.flush();
		bw.close();
	}

}
