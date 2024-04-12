import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//	BOJ_3687	12236kb	84ms
public class Main_3687 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();

		String[] minStr = { "1", "7", "4", "2", "0", "8" };

		long[] min = new long[101]; // 성냥개비 개수에 해당하는 가장 작은 수
		Arrays.fill(min, Long.MAX_VALUE);

		min[2] = 1;
		min[3] = 7;
		min[4] = 4;
		min[5] = 2;
		min[6] = 6; // 숫자 0으로 시작할 수 없음
		min[7] = 8;
		min[8] = 10;

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		int[] number = new int[T];
		int maxNum = 0;

		for (int t = 0; t < T; t++) {
			number[t] = Integer.parseInt(br.readLine()); // 성냥개비 개수
			maxNum = Math.max(maxNum, number[t]);
		}

		// min
		for (int i = 9; i <= maxNum; i++) {

			for (int j = 2; j <= 7; j++) {
				min[i] = Math.min(min[i], Long.parseLong(String.valueOf(min[i - j] + minStr[j - 2])));
			}

		}

		for (int i = 0; i < T; i++) {

			// max
			// 1과 7로 이루어짐
			
			StringBuilder m = new StringBuilder();
			if (number[i] % 2 == 0)
				m.append("1");
			else
				m.append("7");

			for (int j = 0; j < number[i] / 2 - 1; j++) {
				m.append("1");
			}

			answer.append(min[number[i]]).append(" ").append(m).append("\n");
		}

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
