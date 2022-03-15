import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] w = new int[k+1];
		int[] v = new int[k+1];
		int[][] bagValue = new int[n+1][k+1];
    // Knapsack Problem
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
			for(int j = 1; j <= k; j++) {
				bagValue[i][j] = bagValue[i-1][j];
				// bagValue[i-1][j] // 현재 물건 넣지 않음 (선택x)
				// bagValue[i-1][j-w[i]] + v[i] // 현재 물건 넣음 (선택O) 현재 무게 뺴고 남은 무게의 최대가치 + 현재 물건의 가치
				if(j - w[i] >= 0)
				bagValue[i][j] = Math.max(bagValue[i-1][j], bagValue[i-1][j-w[i]] + v[i]);
			}
		}
		br.close();
		bw.write(bagValue[n][k] +"\n");
		bw.flush();
		bw.close();
	}
}
