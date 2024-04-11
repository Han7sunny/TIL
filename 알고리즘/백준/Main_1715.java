import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

//	BOJ_1715	24268kb	364ms
public class Main_1715 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());	//	√÷¥Î 10∏∏
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		while(pq.size() > 1) {
			int sum = pq.poll() + pq.poll();
			answer += sum;
			pq.add(sum);
		}
		
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
		
	}

}
