import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//	BOJ_15683 93728kb 428ms
public class Main_15683 {

	static Map<Integer, List<List<Loc>>> watchList;
	static int N, M;

	public static class Loc {
		private int x;
		private int y;

		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static class Info implements Comparable<Info> {

		private int[][] office;
		private int count; // 사각지대 개수

		public Info(int[][] office, int count) {
			this.office = office;
			this.count = count;
		}
		
		public int[][] clone(){
			int[][] cloneOffice = new int[N][M];
			for (int i = 0; i < N; i++) {
				cloneOffice[i] = this.office[i].clone();
			}
			return cloneOffice;
		}
		
		@Override
		public int compareTo(Info other) {
			return this.count - other.count;
		}
	}

	public static void initCamera() {
		watchList = new HashMap<>();

		watchList.put(1, new ArrayList<>());
		watchList.get(1).add(new ArrayList<>());
		watchList.get(1).get(0).add(new Loc(0, 1));
		watchList.get(1).add(new ArrayList<>());
		watchList.get(1).get(1).add(new Loc(1, 0));
		watchList.get(1).add(new ArrayList<>());
		watchList.get(1).get(2).add(new Loc(0, -1));
		watchList.get(1).add(new ArrayList<>());
		watchList.get(1).get(3).add(new Loc(-1, 0));

		watchList.put(2, new ArrayList<>());
		watchList.get(2).add(new ArrayList<>());
		watchList.get(2).get(0).add(new Loc(0, 1));
		watchList.get(2).get(0).add(new Loc(0, -1));
		watchList.get(2).add(new ArrayList<>());
		watchList.get(2).get(1).add(new Loc(-1, 0));
		watchList.get(2).get(1).add(new Loc(1, 0));

		watchList.put(3, new ArrayList<>());
		watchList.get(3).add(new ArrayList<>());
		watchList.get(3).get(0).add(new Loc(-1, 0));
		watchList.get(3).get(0).add(new Loc(0, 1));
		watchList.get(3).add(new ArrayList<>());
		watchList.get(3).get(1).add(new Loc(0, 1));
		watchList.get(3).get(1).add(new Loc(1, 0));
		watchList.get(3).add(new ArrayList<>());
		watchList.get(3).get(2).add(new Loc(1, 0));
		watchList.get(3).get(2).add(new Loc(0, -1));
		watchList.get(3).add(new ArrayList<>());
		watchList.get(3).get(3).add(new Loc(0, -1));
		watchList.get(3).get(3).add(new Loc(-1, 0));

		watchList.put(4, new ArrayList<>());
		watchList.get(4).add(new ArrayList<>());
		watchList.get(4).get(0).add(new Loc(0, -1));
		watchList.get(4).get(0).add(new Loc(-1, 0));
		watchList.get(4).get(0).add(new Loc(0, 1));
		watchList.get(4).add(new ArrayList<>());
		watchList.get(4).get(1).add(new Loc(-1, 0));
		watchList.get(4).get(1).add(new Loc(0, 1));
		watchList.get(4).get(1).add(new Loc(1, 0));
		watchList.get(4).add(new ArrayList<>());
		watchList.get(4).get(2).add(new Loc(0, 1));
		watchList.get(4).get(2).add(new Loc(1, 0));
		watchList.get(4).get(2).add(new Loc(0, -1));
		watchList.get(4).add(new ArrayList<>());
		watchList.get(4).get(3).add(new Loc(1, 0));
		watchList.get(4).get(3).add(new Loc(0, -1));
		watchList.get(4).get(3).add(new Loc(-1, 0));

		watchList.put(5, new ArrayList<>());
		watchList.get(5).add(new ArrayList<>());
		watchList.get(5).get(0).add(new Loc(0, -1));
		watchList.get(5).get(0).add(new Loc(-1, 0));
		watchList.get(5).get(0).add(new Loc(0, 1));
		watchList.get(5).get(0).add(new Loc(1, 0));
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 사무실 세로 크기
		M = Integer.parseInt(st.nextToken()); // 사무실 가로 크기
		int total = N * M; // 검사 가능한 곳
		
		PriorityQueue<Info> pq = new PriorityQueue<>();
		Queue<Loc> cctvList = new ArrayDeque<>();
		int[][] office = new int[N][M];
		
		initCamera();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				
				//	cctv & 벽
				if (office[i][j] > 0) {
					if(office[i][j] < 6)
						cctvList.offer(new Loc(i, j));
					total--;
				}
			}
		}
		
		pq.offer(new Info(office, total));
		
		allWatch : while (!cctvList.isEmpty()) {
			
			Loc now = cctvList.poll();
			List<List<Loc>> list = watchList.get(office[now.x][now.y]);
			List<Info> infoList = new ArrayList<>(); 
			
			// 넣은 정보 (사무실 정보, 사각지대 개수)
			while (!pq.isEmpty()) {
				
				Info info = pq.poll(); // office, total
				int min = info.count;
				
				//	현재 cctv 위치에서 사무실의 감시 개수 확인하기
				for (int i = 0; i < list.size(); i++) {
					int[][] ofc = info.clone();
					
					int count = info.count; // 사각지대 개수
					
					for (int j = 0; j < list.get(i).size(); j++) {
						Loc loc = now;
						int nx = loc.x;
						int ny = loc.y;
						
						// 해당 방향으로 벽 만날 때까지 진행해야 함
						while (true) {
							
							nx += list.get(i).get(j).x;
							ny += list.get(i).get(j).y;
																					
							if (nx < 0 || ny < 0 || nx >= N || ny >= M || ofc[nx][ny] == 6)
								break;
							
							if (ofc[nx][ny] == 0) {
								ofc[nx][ny] = -1; // 감시한 곳
								count--;
							}
							
						}
						
					}
					if(count == 0) {
						total = count;
						break allWatch;
					}
					else if (min >= count) {
						min = count;
					}
					infoList.add(new Info(ofc, count));
				}
				total = Math.min(total, min);
			}
			
			for (int i = 0; i < infoList.size(); i++) {
				pq.add(infoList.get(i));
			}
		}

		br.close();
		bw.write(Integer.toString(total));
		bw.flush();
		bw.close();
	}

}
