import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {
	static int[][] move = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	static int[][] arr;
	static int N, M;

	public static void spin(int[][] arr, int N, int M, int R) {
		while (R > 0) {
			int cnt = 0;
			if (N < M)
				cnt = N / 2;
			else
				cnt = M / 2;

			for (int s = 0; s < cnt; s++) {
				Deque<Integer> temp = new ArrayDeque<>();
				temp.add(arr[s][s]);
				for (int i = s; i + 1 < M - s; i++) {
					arr[s][i] = arr[s][i + 1];
				}

				temp.add(arr[N - 1 - s][s]);
				for (int i = N - 1 - s; i - 1 > s; i--) {
					arr[i][s] = arr[i - 1][s];
				}
				arr[s + 1][s] = temp.poll();

				temp.add(arr[N - 1 - s][M - 1 - s]);
				for (int i = M - 1 - s; i - 1 > s; i--) {
					arr[N - 1 - s][i] = arr[N - 1 - s][i - 1];
				}
				arr[N - 1 - s][s + 1] = temp.poll();

				for (int i = s; i + 1 < N - 1 - s; i++) {
					arr[i][M - 1 - s] = arr[i + 1][M - 1 - s];
				}
				arr[N - 1 - 1 - s][M - 1 - s] = temp.poll();

			}
			R--;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken()); // 회전 수
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		spin(arr, N, M, R);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer.append(arr[i][j]);
				if (j != M - 1)
					answer.append(" ");
			}
			answer.append("\n");

		}
		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
