import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_14567 130800kb 580ms
public class Main_14567 {

	public static class Info {
		private int num;
		private int semester;
		
		public Info(int num, int semester) {
			this.num = num;
			this.semester = semester;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 과목의 수
		int M = Integer.parseInt(st.nextToken()); // 선수 조건의 수
		
		Queue<Info> q = new ArrayDeque<>();
		int[] degree = new int[N + 1];	//	진입차수
		int[] semester = new int[N + 1];
		List<Integer>[] next = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			next[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			next[A].add(B);
			degree[B]++;
		}
		
		for (int i = 1; i <= N; i++) {
			if(degree[i] == 0)
				q.add(new Info(i, 1));
		}
		
		while(!q.isEmpty()) {
			Info now = q.poll();
			semester[now.num] = now.semester;

			for (int i = 0; i < next[now.num].size(); i++) {
				degree[next[now.num].get(i)]--;
				
				if(degree[next[now.num].get(i)] == 0)
					q.add(new Info(next[now.num].get(i), now.semester + 1));
				
			}
			
		}

		for (int i = 1; i <= N; i++) {
			answer.append(semester[i]).append(" ");
		}
		
		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
		
	}

}
