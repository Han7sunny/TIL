import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// BOJ 1780 316096kb 808ms
public class Main_1780_종이의개수 {

	static int[][] papers;
	static int[] paperCount = new int[3];

	public static void paper(int size, int x, int y) {

		if (size == 1) {
			if (papers[x][y] == -1)
				paperCount[0]++;
			else if (papers[x][y] == 0)
				paperCount[1]++;
			else
				paperCount[2]++;
			return;
		} else {
			int comp = 0;
			boolean isSame = true;

			out: for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (i == 0 && j == 0) {
						comp = papers[x][y];
						continue;
					}

					if (papers[x + i][y + j] != comp) {
						isSame = false;
						break out;
					}

				}
			}

			if (isSame) {
				if (papers[x][y] == -1)
					paperCount[0]++;
				else if (papers[x][y] == 0)
					paperCount[1]++;
				else
					paperCount[2]++;
			} else {
				int s = size / 3;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						paper(s, x + s * i, y + s * j);
					}
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		papers = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				papers[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		paper(N,0,0);

		StringBuilder answer = new StringBuilder();
		for (int cnt : paperCount) {
			answer.append(cnt).append("\n");
		}

		bw.write(answer.toString()); // -1, 0, 1로만 채워진 종이의 개수
		br.close();
		bw.flush();
		bw.close();
	}

}
