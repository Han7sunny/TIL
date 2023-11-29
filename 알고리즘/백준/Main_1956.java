import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

//	BOJ_1956 59324kb 600ms
public class Main_1956 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int max = 987654321;
		int answer = max;
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] road = new int[V + 1][V + 1];
				
		for (int i = 1; i <= V; i++) {
			Arrays.fill(road[i], 987654321);
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// a -> b
			road[a][b] = c;
		}
		
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if(road[i][j] > road[i][k] + road[k][j]) {
						road[i][j] = road[i][k] + road[k][j];
					}
				}
			}
		}
		
		//	시작점으로 다시 돌아오는 사이클을 이루는 도로의 최소 길이
		for (int i = 1; i <= V; i++) {
			answer = Math.min(answer, road[i][i]);
		}
		
		if(answer == max)
			answer = -1;
		
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
