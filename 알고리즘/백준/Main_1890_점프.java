
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// BOJ 1890 11900kb 84ms
public class Main_1890_점프 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 4 - 100
		int[][] board = new int[N][N];
		long[][] total = new long[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		total[0][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j] == 0 || (i == N - 1 && j == N - 1))
					continue;
				
				
				
				if (i + board[i][j] < N)
					total[i + board[i][j]][j] += total[i][j];

				if (j + board[i][j] < N)
					total[i][j + board[i][j]] += total[i][j];
			}
		}

		bw.write(Long.toString(total[N - 1][N - 1]));
		br.close();
		bw.flush();
		bw.close();

	}
}
