import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//	BOJ_1766 47252kb 444ms
public class Main_1766 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> lists = new ArrayList<>();
		int[] priorCnt = new int[N+1];
		
		for (int i = 0; i <= N ; i++) {
			lists.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// A 문제를 B 문제보다 먼저 풀어야 한다.
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			lists.get(A).add(B);
			
			//	B의 선행 문제 개수
			priorCnt[B]++;

		}
		
		//	선행 문제 없는 문제 넣기
		for (int i = 1; i <= N; i++) {
			if(priorCnt[i] == 0)
				pq.offer(i);
		}

		while (!pq.isEmpty()) {
			int now = pq.poll();
			
			for(Integer next : lists.get(now)) {
				priorCnt[next]--;
				
				//	선행 문제 없는 경우
				if(priorCnt[next] == 0)
					pq.offer(next);
				
			}
			answer.append(now).append(" ");
		}

		br.close();
		bw.write(answer.deleteCharAt(answer.length() - 1).toString());
		bw.flush();
		bw.close();

	}
}
