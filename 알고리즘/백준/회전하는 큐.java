import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;
public class Main { // 1021
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= n; i++)
			queue.offer(i);
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int pick = Integer.parseInt(st.nextToken());
			int position = queue.indexOf(pick); // indexOf() 문제 풀이의 핵심
			int half_position;
			if(queue.size() % 2 == 0) // 짝수
				half_position = queue.size() / 2 - 1;
			else
				half_position = queue.size() / 2;
			
			if(position <= half_position) { // 2번 연산
				for(int j = 0; j < position; j++) {
					int first = queue.pollFirst();
					queue.offerLast(first);
					answer++;
				}
			}else { // 3번 연산
				for(int j = 0; j < queue.size() - position; j++) {
					int last = queue.pollLast();
					queue.offerFirst(last);
					answer++;
				}
			}
			queue.pollFirst(); // 1번 연산
		}
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}
}
