import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

//	BOJ_14267 79864kb 624ms
public class Main_14267 {
	
	static List<Integer>[] junior;
	static int[] score;
	
	public static void compliment(int num, int cScore) {

		score[num] += cScore;
		
		for(int j : junior[num]) {
			compliment(j, cScore);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 회사 직원 수
		int M = Integer.parseInt(st.nextToken()); // 최초 칭찬 횟수
		
		Map<Integer, Integer> complimentScore = new HashMap<>();
		junior = new ArrayList[N + 1];
		score = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			junior[i] = new ArrayList<>();
		}
			
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			//	직속 상사 번호
			int superior = Integer.parseInt(st.nextToken());
			if(superior == -1)
				superior++;
			junior[superior].add(i); // 상사의 직속 부하 = i
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			complimentScore.put(num, complimentScore.getOrDefault(num, 0) + Integer.parseInt(st.nextToken()));
		}
		
		for(Entry<Integer, Integer> info : complimentScore.entrySet()) {
			// 직원 번호, 칭찬 점수
			compliment(info.getKey(), info.getValue());
		}

		//	출력
		for (int i = 1; i <= N; i++) {
			answer.append(score[i]).append(" ");
		}
		
		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
