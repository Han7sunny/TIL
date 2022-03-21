import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] loc = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == k) {
				bw.write(loc[now] + "\n");
				break;
			}
			for(int nxt = 0; nxt < 3; nxt++) {
				int next = now;
				switch(nxt) {
					case 0:
						next -= 1;
						break;
					case 1:
						next += 1;
						break;
					case 2:
						next *= 2;
						break;
				}
				if(0 <= next && next < loc.length) {
					if(loc[next] == 0) {
						loc[next] = loc[now] + 1;
						q.offer(next);
					}
				}
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
