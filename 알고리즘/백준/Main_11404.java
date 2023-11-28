import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//	BOJ_11404 41620kb 352ms
public class Main_11404 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());	//	도시 개수
		int m = Integer.parseInt(br.readLine());	//	버스 개수
		int max = 987654321;
		
		int[][] cost = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			Arrays.fill(cost[i], max);
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			cost[a][b] = Math.min(cost[a][b], c);
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(cost[i][j] > cost[i][k] + cost[k][j]) {
						cost[i][j] = cost[i][k] + cost[k][j];
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(cost[i][j] == max || i == j)
					cost[i][j] = 0;
				answer.append(cost[i][j]).append(" ");
			}
			answer.append("\n");
		}
		
		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
		
	}

}
