import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기 {

//	SWEA 1225 암호생성기 20,404kb 122ms
//	Queue를 사용하여 풀었습니다.
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			Queue<Integer> q = new ArrayDeque<>();
			int cycle = 1;
			boolean finish = false;
			int t = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			while(true) {
				int now = q.poll() - cycle;
				if(now <= 0) {
					now = 0;
					finish = true;
				}
				q.add(now);
				
				if(finish)
					break;
				
				if(cycle % 5 == 0)
					cycle = 1;
				else
					cycle++;
				
			}
			
			StringBuilder answer = new StringBuilder();
			answer.append("#").append(test_case).append(" ");
			for (int i = 0; i < 8; i++)
				answer.append(q.poll()).append(" ");
			bw.write(answer.toString().trim() + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
}
