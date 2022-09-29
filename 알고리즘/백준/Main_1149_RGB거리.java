import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// BOJ 1149 RGB거리 12,204kb 92ms
public class Main_1149_RGB거리 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] color = new int[N][3];
		int[][] sum = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0)
					sum[i][j] = color[i][j];
			}
			if(i > 0) {
				sum[i][0] = Math.min(sum[i-1][1], sum[i-1][2]) + color[i][0];
				sum[i][1] = Math.min(sum[i-1][0], sum[i-1][2]) + color[i][1];
				sum[i][2] = Math.min(sum[i-1][0], sum[i-1][1]) + color[i][2];
			}
		}
		bw.write(Math.min(sum[N-1][0], Math.min(sum[N-1][1], sum[N-1][2])) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
