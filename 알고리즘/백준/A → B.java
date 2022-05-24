import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { // 16953
  // 처음에 문제 그대로 A → B로 풀기 위해 A값을 B값에 가까워지도록 조건에 맞는 A값을 계산해가며 PriorityQueue에 넣었다.
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int answer = -1;
        
		PriorityQueue<int[]> q = new PriorityQueue<>((x,y) -> x[1] - y[1]); // b, 연산 개수
		q.add(new int[] {b,1});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(now[0] == a) {
				answer = now[1];
				break;
			}
			
			if(now[0] % 10 == 1 && now[0] / 10 >= a)
				q.add(new int[] {now[0] / 10, now[1] + 1});
			
			if(now[0] % 2 == 0 && now[0] / 2 >= a)
				q.add(new int[] {now[0] / 2, now[1] + 1});

		}
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}
}
