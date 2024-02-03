import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

//	BOJ_2253	99840kb	508ms
public class Main_2253 {
	
	public static class Info {
		
		private int pos;	//	돌 번호
		private int jump;	//	이전에서 점프해온 값
		private int count;	//	현재까지 점프한 횟수
		
		public Info(int pos, int jump, int count) {
			this.pos = pos;
			this.jump = jump;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 돌 개수
		int M = Integer.parseInt(st.nextToken()); // 크기가 작아 올라갈 수 없는 돌의 개수

		int answer = N;

		Map<Integer, Boolean>[] jump = new HashMap[N + 1];
		Map<Integer, Boolean> small = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			jump[i] = new HashMap<>();
		}
		jump[1].put(0, true);

		for (int i = 0; i < M; i++) {
			small.put(Integer.parseInt(br.readLine()), true);
		}

		if (!small.containsKey(N)) {
			
			Queue<Info> q = new ArrayDeque<>();
			q.add(new Info(1, 0, 0));
			
			while(!q.isEmpty()) {
				Info now = q.poll();
				
				if(now.pos == N) {
					answer = Math.min(answer, now.count);
					break;
				}
				
				for(int j = now.jump - 1; j <= now.jump + 1; j++) {
					if(1 <= j && now.pos + j <= N && !small.containsKey(now.pos + j) && !jump[now.pos + j].containsKey(j)) {
						q.add(new Info(now.pos + j , j, now.count + 1));
						jump[now.pos + j].put(j, true);
					}
				}
			}
			
		}

		br.close();
		bw.write(Integer.toString(answer == N ? -1 : answer));
		bw.flush();
		bw.close();
	}

}
