import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// BOJ 1080 11888kb 80ms
public class Main_1080_행렬 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;

		char[][] A = new char[N][M];
		for (int i = 0; i < N; i++) {
			A[i] = br.readLine().toCharArray();
		}

		char[][] B = new char[N][M];
		breakPoint: for (int i = 0; i < N; i++) {
			B[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					if (i + 2 < N && j + 2 < M) {
						answer++;
						for (int k = 0; k < 3; k++) {
							for (int l = 0; l < 3; l++) {
								if (A[i + k][j + l] == '0')
									A[i + k][j + l] = '1';
								else
									A[i + k][j + l] = '0';
							}
						}
					} else {
						answer = -1;
						break breakPoint;
					}
				}
			}
		}
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();

	}

}
