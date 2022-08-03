import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(
//				new FileReader("C:\\SSAFY\\workspace\\workshop\\Algorithm\\0803\\src\\input2.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] fly = new int[n][n];
			int[][] flySum = new int[n][n];
			int answer = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());
					flySum[i][j] = fly[i][j];
					if(j > 0)
						flySum[i][j] += flySum[i][j-1];
				}
				
				
			}
			for (int i = 0; i <= n - m ; i++) {
				for (int j = 0; j <= n - m; j++) {
					int sum = 0;
					for(int k = 0; k < m; k++) { // 가로 기준 m번
						if(j == 0)
							sum += flySum[i + k][j + m - 1];
						else
							sum += flySum[i + k ][j + m - 1]- flySum[i + k][j - 1];
					}
					answer = Math.max(answer, sum);
				}
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}