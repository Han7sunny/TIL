import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_20040 244232kb 680ms
public class Main_20040 {
	
	static int[] parent;
	
	public static void init(int size) {
		parent = new int[size];
		
		//	초기 상태 : 본인의 부모 = 본인
		for (int i = 0; i < size; i++) {
			parent[i] = i;
		}
	}
	
	//	그래프에서 루트 노드 찾아주는 함수
	public static int find(int x) {
		
		//	집합의 루트 노드가 자기 자신이라면 반환
		if(parent[x] == x)
			return x;
		
		//	아니라면 x 부모의 루트 노드 찾기
		return parent[x] = find(parent[x]);
	}
	
	//	그래프 사이클 확인 및 합치기
	public static boolean union(int x, int y) {
		
		x = find(x);
		y = find(y);
		
		if(x == y)
			return false;
		
		parent[y] = x;		
		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int answer = 0;
		boolean isCycle = false;
		
		int N = Integer.parseInt(st.nextToken());	//	점의 개수
		int M = Integer.parseInt(st.nextToken());	//	진행된 차례의 수
				
		init(N);
		
		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			if(isCycle)
				continue;
			
			//	사이클 완성
			if(!union(num1, num2)) {
				isCycle = true;
				answer = i + 1;
			}
				
		}
		
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
