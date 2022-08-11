import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// SWEA 5215 햄버거 다이어트 20,316kb 163ms
// StringBuilder를 사용할 때 마지막에 /n 까먹지 말자^^^^^
public class Solution_5215_햄버거다이어트 {
	static int total;
	static int N, L;
	static int[] taste;
	static int[] calorie;

	public static void combCal(int sumTaste, int sumCalorie, int k) {
		
//		if(k == N) {
//			total = Math.max(total, sumTaste);
//			return;
//		}
		
		for (int i = k; i < N; i++) {
			if(sumCalorie + calorie[i] <= L) {
				total = Math.max(total, sumTaste + taste[i]);
				combCal(sumTaste + taste[i] , sumCalorie + calorie[i], i + 1);
			}
		}
		
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder answer;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer = new StringBuilder();
			total = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			taste = new int[N];
			calorie = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(st.nextToken()); // 점수
				calorie[i] = Integer.parseInt(st.nextToken()); // 칼로리
			}
			
			combCal(0,0,0);
			
			answer.append("#").append(test_case).append(" ").append(total).append("\n"); // ㅋㅋ;
			bw.write(answer.toString());

		}
		br.close();
		bw.flush();
		bw.close();
	}
}
