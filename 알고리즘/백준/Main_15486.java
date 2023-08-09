import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_15486 343920kb 764ms
public class Main_15486 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] info = new int[N][2];
		int[] cost = new int[N + 1];
		int max = 0;
		
		for (int day = 0; day < N; day++) {
			st = new StringTokenizer(br.readLine());

			info[day][0] = Integer.parseInt(st.nextToken());	//	상담 기간
			info[day][1] = Integer.parseInt(st.nextToken());	//	상담비
			
			//	현재까지의 max 구하기 ... cost 오늘 일자에 안 적혀있을 수 있으니까
			max = Math.max(max, cost[day]);
			
			int next = day + info[day][0];
			if(next <= N) {
				cost[next] = Math.max(cost[next], max + info[day][1]);
			}
		}
		
		br.close();
		bw.write(Integer.toString(Math.max(max, cost[N])));
		bw.flush();
		bw.close();
	}

}
