import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

//	BOJ_2252 49836kb 452ms
public class Main_2252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());	//	학생 수
		int M = Integer.parseInt(st.nextToken());	//	키 비교 횟수
		
		Deque<Integer> q = new ArrayDeque<>();
		
		int[] degree = new int[N + 1];
		Map<Integer, Integer> check = new HashMap<>();
		List<Integer>[] order = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			check.put(i, 1); // 키 쟀는지 확인
			order[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			//	A < B
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			order[A].add(B); // A -> B
			degree[B]++;
		}
		
		for (int i = 1; i <= N; i++) {
			if(degree[i] == 0)
				q.offer(i);
		}
		
		while(!q.isEmpty()) {
			
			int now = q.poll();
			check.remove(now);
			answer.append(now).append(" ");
			
			for (int next : order[now]) {
				degree[next]--;
				if(degree[next] == 0)
					q.offer(next);
			}
		}
		
		if(check.size() != 0) {	//	확인 안 한 키 있으면
			for(Entry<Integer,Integer> n : check.entrySet()) {
				answer.append(n.getKey()).append(" ");
			}
		}

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
