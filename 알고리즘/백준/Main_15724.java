import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_15724 125016kb 1308ms
public class Main_15724 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] rows = new int[N + 1][M + 1]; // 가로 합
		int[][] cols = new int[N + 1][M + 1]; // 세로 합

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				int people = Integer.parseInt(st.nextToken());
				rows[i][j] += rows[i][j - 1] + people;
				cols[i][j] += cols[i - 1][j] + people;
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			if (x1 == x2) {
				answer.append(rows[x1][y2] - rows[x1][y1 - 1]).append("\n");
			} else if (y1 == y2) {
				answer.append(cols[x2][y1] - cols[x1 - 1][y1]).append("\n");
			}else {
				
				int sum = 0;
				for (int j = x1; j <= x2; j++) {
					sum += rows[j][y2] - rows[j][y1 - 1];
				}
				answer.append(sum).append("\n");
			}

		}

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
