import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 11403 15108kb 144ms
public class Main_11403_경로찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;
        
        Queue<Integer> q = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        // 방향 그래프
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        for (int start = 0; start < N; start++) {
        	boolean[] visited = new boolean[N];
			q.offer(start);
			while(!q.isEmpty()) {
				int now = q.poll();
				for (int i = 0; i < N; i++) {
					if(!visited[i] && graph[now][i] == 1) {
						visited[i] = true;
						graph[start][i] = 1;
						q.offer(i);
					}
				}
			}
		}
        
        // print graph
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer.append(graph[i][j]).append(" ");
			}
			answer.append("\n");
		}
        
        bw.write(answer.toString());
        br.close();
        bw.flush();
        bw.close();
	}

}
