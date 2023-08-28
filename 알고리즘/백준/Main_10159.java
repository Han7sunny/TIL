import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_10159 13580kb 132ms
public class Main_10159 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
				
		boolean[][] light = new boolean[N][N];
		boolean[][] heavy = new boolean[N][N];
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			//	a > b
			light[a][b] = true;
			
			//	b < a
			heavy[b][a] = true;

		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if(light[i][k] && light[k][j]) 
						light[i][j] = true;
					
					
					if(heavy[i][k] && heavy[k][j])
						heavy[i][j] = true;
					
				}
			}
		}	
				
		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = 0; j < N; j++) {
				
				light[i][j] = (light[i][j] || heavy[i][j]);
				
				if(!light[i][j] && i != j)
					count++;
			}
			answer.append(count).append("\n");
		}
		
		
		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
