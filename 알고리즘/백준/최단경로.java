import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine()); 
		Map<Integer, Integer> minRoute = new HashMap<>(); // 1에서 해당 노드까지의 최소 거리
		Map<Integer,ArrayList<int[]>> node = new HashMap<>();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			if(!node.containsKey(u)) 
				node.put(u, new ArrayList<>());
			node.get(u).add(new int[] {v,w});
		}
		br.close();
		
		Queue<Integer> q = new LinkedList<>(); // add start node
		q.add(K); // 시작 정점
		minRoute.put(K, 0);
		while(!q.isEmpty()) {
			int s = q.poll();
			for(int i = 0; i < node.get(s).size(); i++) { // ㅋㅋ ㅅ발 왜 여기서 2면 end 2,3나옴? -> 응 s를 start로 잘못 작성^^짜증나~! 반성 끝^^
				int e = node.get(s).get(i)[0];
				int w = node.get(s).get(i)[1];
				if(!minRoute.containsKey(e)) {
					minRoute.put(e, minRoute.get(s) + w);
					if(node.containsKey(e))
						q.add(e);
				}
				else {
					if(minRoute.get(e) > minRoute.get(s) + w) {
						minRoute.put(e, minRoute.get(s) + w);
						if(node.containsKey(e))
							q.add(e);
					}
				}
                // ^무조건 넣지 말고^ 더 좋아질 수 있으면 넣기
				// 이미 좋아졌으면 넣지 않기 -> 이후의 값들은 어차피 더 추가되는 값이니까
			}
		}
		for(int i = 1; i <= V; i++) {
			if(minRoute.get(i) == null)
				bw.write("INF\n");
			else
				bw.write(minRoute.get(i)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
