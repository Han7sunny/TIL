import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ 1197 최소 스패닝 트리 49,116kb 580ms
//kruskal 알고리즘을 사용하여 문제 해결
public class Main_1197_최소스패닝트리 {
	static long result = 0;
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight); // 가중치 양수, 음수
		}
	}
	
	static int[] parents;
	static int V,E; // 정점, 간선 개수
	static Edge[] edgeList;
	
	static void make() { // 크기가 1인 서로소 집합 생성
		parents = new int[V+1];
		for (int i = 1; i <= V; i++) { // 모든 노드가 자신을 부모로 하는 ( 대표자  ) 집합 만든다.
			parents[i] = i;
		}
	}
	
	static int find(int a) { // a의 대표자 찾기
		if(parents[a] == a)
			return a;
		return parents[a] =  find(parents[a]); // 우리의 대표자를 나의 부모로 : path compression
	}
	
	static boolean union(int a, int b) { // true : union 성공
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	public static void kruskal() {
		make();
		Arrays.sort(edgeList);
		
		int cnt = 0;
		for (Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++cnt == V - 1)
					break;
			}
		}
	}
	public static void prim() {
		
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken()); // 양수 / 음수
			
			edgeList[i] = new Edge(A,B,C); // kruskal
		}
		
		kruskal();
//		prim();
		
		bw.write(Long.toString(result));
		br.close();
		bw.flush();
		bw.close();
	}

}
