import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {  // 1197
	// 크루스칼 
	static int[] parent;
	public static int find(int x) {
		if(parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y)
			parent[y] = x;
	}
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y)
			return true;
		else
			return false;	
	}
	public static void main(String[] args) throws IOException {
//		 TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);

		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new int[] {a,b,c});
		}
		
		parent = new int[v+1];
		for(int i = 1; i <= v; i++)
			parent[i] = i;
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int to = find(now[0]);
			int from = find(now[1]);
			
			if(!isSameParent(to,from)) { // 사이클 발생하지 않는 경우에만 집합에 포함
				answer += now[2];
				union(to, from); 
			}
		}
		
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}
}
