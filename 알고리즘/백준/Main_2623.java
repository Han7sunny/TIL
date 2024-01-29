import java.io.*;
import java.util.*;

//	BOJ_2623	12480kb	104ms
public class Main_2623 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());	//	가수의 수
		int M = Integer.parseInt(st.nextToken());	//	보조 PD의 수
		
		Map<Integer, Boolean> notVisited = new HashMap<>();	//	모든 가수의 순서 정했는지 유무
		Queue<Integer> q = new ArrayDeque<>();
		int[] degree = new int[N + 1];
		List<Integer>[] seq = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			seq[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());	//	보조 PD가 담당한 가수의 수
			int pre = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < n - 1; j++) {
				int num = Integer.parseInt(st.nextToken());
				degree[num]++;
				seq[pre].add(num);
				pre = num;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(degree[i] == 0)
				q.add(i);
			else
				notVisited.put(i, true);
		}
		
		while(!q.isEmpty()) {
			
			int now = q.poll();
			answer.append(now).append("\n");
			
			for (int next : seq[now]) {
				degree[next]--;
				if(degree[next] == 0) {
					q.add(next);
					notVisited.remove(next);
				}
			}
		}
		
		br.close();
		bw.write(notVisited.size() == 0 ? answer.toString() : "0");
		bw.flush();
		bw.close();
	}

}
