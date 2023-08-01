import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//	BOJ_2458 36496kb 500ms
//	각 학생이 모든 학생과 연결되어 있는지 확인
//	->	모든 노드에서 모든 노드로 탐색하는 플로이드 와샬
public class Main_2458 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 두 학생 키 비교한 횟수 (N명 전부가 아닌 일부)

		int[][] check = new int[N + 1][N + 1];
		int[] count = new int[N + 1];

		int answer = 0; // 자신의 키가 몇 번째인지 알 수 있는 학생 수
		
		int INF = 987654321;
		
		for (int i = 1; i <= N; i++) {
			Arrays.fill(check[i], INF);
		}
		
		for (int i = 0; i < M; i++) {
		
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// a 학생이 b 학생보다 키가 작다
			check[a][b] = 1;	// (연결)
			// 나보다 뒤인 사람 개수랑 나보다 앞인 사람 개수가 N - 1이면 answer++

		}
		
		for (int k = 1; k <= N; k++) {	//	경유지
			for (int i = 1; i <= N; i++) {	//	출발지
				for (int j = 1; j <= N; j++) {	//	도착지
						check[i][j] = Math.min(check[i][j], check[i][k] + check[k][j]);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				//	정방향, 역방향 확인
				if(check[i][j] != INF || check[j][i] != INF) {
					count[i]++;
				}
			}
			if(count[i] == N - 1)
				answer++;
		}

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
