import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { // 1043
  // 처음 풀 때 Party, People 클래스를 생성해서 진실을 아는 사람이 적은 파티 순으로 PriorityQueue를 통해 뽑아내서 진행했는데
  // 굳이 클래스 객체를 생성하지 않아도 간단하게 풀 수 있다는 점을 깨달음.
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer = m;

		st = new StringTokenizer(br.readLine());
		int truthPeople = Integer.parseInt(st.nextToken());
		if(truthPeople != 0) {
			ArrayList<Integer> truth = new ArrayList<>();
			boolean[] partyCheck = new boolean[m];
			ArrayList<Integer>[] party = new ArrayList[m];
			Queue<Integer> q = new LinkedList<>();

			for(int i = 0; i < truthPeople; i++) {
				truth.add(Integer.parseInt(st.nextToken()));
				q.add(truth.get(i));
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				party[i] = new ArrayList<>();
				int partySize = Integer.parseInt(st.nextToken());
				for(int j = 0; j < partySize; j++)
					party[i].add(Integer.parseInt(st.nextToken()));
			}
			
			while(!q.isEmpty()) { // truth
				int now = q.poll();
				for(int i = 0; i < party.length; i++) {
					if(partyCheck[i]) continue;
					if(!party[i].contains(now)) continue;
					for(int j = 0; j < party[i].size(); j++) { // now 출석한 파티
						if(party[i].get(j) != now && !truth.contains(party[i].get(j))) {
							truth.add(party[i].get(j));
							q.add(party[i].get(j));
						}
					}
					partyCheck[i] = true;
					answer--;
				}
			}
			bw.write(Integer.toString(answer));
		}else {
			bw.write(Integer.toString(answer));
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
