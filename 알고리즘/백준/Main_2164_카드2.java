import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2164_카드2 {
//	BOJ 2164 카드 2 37,164kb 220ms
//	Queue를 사용하여 풀었습니다.
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new ArrayDeque();
		for(int card = 1; card <= n; card++)
			q.add(card);
		while(q.size() > 1) {
			int first = q.poll();
			int second = q.poll();
			q.add(second);
		}
		br.close();
		bw.write(q.poll() + "\n");
		bw.close();
	}

}
