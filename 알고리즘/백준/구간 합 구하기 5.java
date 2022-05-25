import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main { // 11660
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] num = new int[n][n];
		int[][] sum = new int[n][n];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			sum[i][0] = 0;
			for(int j = 0; j < n; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
				sum[i][j] += num[i][j];
				if(j > 0)
					sum[i][j] += sum[i][j - 1];
			}
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int answer = 0;
			for(int j = x1 - 1; j <= x2 - 1 ; j++) {
				if(y1 == 1)
					answer += sum[j][y2 - 1];
				else
					answer += sum[j][y2 - 1] - sum[j][y1 - 1 - 1];
			}
			bw.write(Integer.toString(answer) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
