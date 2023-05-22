import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// BOJ_11723 325576kb 952ms
public class Main_11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		int M = Integer.parseInt(br.readLine());
		int S = 0;	//	비어있는 공집합
		
		for (int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			
			if (input.startsWith("add")) {
				//	0이면 1, 1이면 1
				S = S | (1 << (Integer.parseInt(st.nextToken()) - 1));
			} else if (input.startsWith("remove")) {
				// 1이면 0, 0이면 0
				S = S & ~(1 << (Integer.parseInt(st.nextToken()) - 1)); 
			} else if (input.startsWith("check")) {
				//	x번째 자리가 1이면 1, 0이면 0
				int check = 1 << (Integer.parseInt(st.nextToken()) - 1); 
				if((S & check) > 0)
					answer.append(1).append("\n");
				else
					answer.append(0).append("\n");

			} else if (input.startsWith("toggle")) {
				//	1이면 0, 0이면 1
				S = S ^ (1 << (Integer.parseInt(st.nextToken())) - 1);	//	x자리가 모두 1인 이진수
			} else if (input.startsWith("all")) {
				//	모두 1로 변환
				S = ((1 << 21) - 1);
			} else if(input.startsWith("empty")) {
				S = 0;
			}
		}

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
