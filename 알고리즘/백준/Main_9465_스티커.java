import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9465_스티커 {

// BOJ 9465 120240kb 884ms
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < t; test_case++) {

			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n];
			int maxScore = 0;

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if (n == 1)
				maxScore = Math.max(sticker[0][0], sticker[1][0]);
			else {
				sticker[0][1] = Math.max(sticker[0][0], sticker[1][0] + sticker[0][1]);
				sticker[1][1] = Math.max(sticker[1][0], sticker[0][0] + sticker[1][1]);
				if (n == 2) {
					maxScore = Math.max(maxScore, Math.max(sticker[0][1], sticker[1][1])); // 위, 아래
				} else {
					for (int i = 2; i < n; i++) {
						for (int j = 0; j < 2; j++) {
							if (j == 0) {
								sticker[j][i] = Math.max(sticker[j][i - 1],
										Math.max(sticker[j + 1][i - 1], sticker[j + 1][i - 2]) + sticker[j][i]);

							} else {
								sticker[j][i] = Math.max(sticker[j][i - 1],
										Math.max(sticker[j][i - 2], sticker[j - 1][i - 1]) + sticker[j][i]);

							}
						}
						maxScore = Math.max(maxScore, Math.max(sticker[0][i], sticker[1][i])); // 위, 아래
					}
				}
			}
			answer.append(maxScore + "\n");
		}
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}