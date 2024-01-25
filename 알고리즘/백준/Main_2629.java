import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_2629	14300kb	116ms
public class Main_2629 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());	//	추 개수
		boolean[][] checked = new boolean[N][40001];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			//	추 무게 (오름차순)
			int w = Integer.parseInt(st.nextToken());
			checked[i][w] = true;
			if(i == 0) continue;
			for (int j = 1; j <= 40000; j++) {
				if(checked[i - 1][j]) {
					checked[i][j] = true;
					checked[i][w + j] = true;
					checked[i][Math.abs(w - j)] = true;
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());	//	확인할 구슬 개수
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int w = Integer.parseInt(st.nextToken());	//	최대 40000
			if(checked[N - 1][w])
				answer.append("Y");
			else
				answer.append("N");
			
			if(i < M - 1)
				answer.append(" ");
		}
		
		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
