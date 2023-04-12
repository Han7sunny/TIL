import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

//	BOJ 12873 106,812kb 212ms
public class Main_12873 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // BOJ 캠프 참가자 수 최대 5000
		int answer = 1;

		if (N != 1) {
			
			Deque<Integer> dq = new ArrayDeque<>();
			
			for (int num = 2; num <= N; num++) {
				dq.offer(num);
			}

			long stage = 2;
			
			while (dq.size() != 1) {

				long index =  (long) (Math.pow(stage, 3) % dq.size());
				if (index == 0)
					dq.pollLast();
				else {
					int cnt = 1;
					while (cnt <= index) {
						int peek = dq.pollFirst();
						if (cnt != index)
							dq.offerLast(peek);
						cnt++;
					}
				}
				stage++;
			}
			answer = dq.poll(); // 원에 한 명이 남을 때까지 진행하며 마지막 한 사람이 기념품 가져감
		}
		
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}

}
