import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int maxSum = 0;
		int[][] triangle = new int[n][];
		
		for (int i = 0; i < n; i++) {
			triangle[i] = new int[i+1];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
				
				if(i == 0)
					continue;
				
				if(j == 0)
					triangle[i][j] += triangle[i-1][j];
				else if (j == i)
					triangle[i][j] += triangle[i-1][j-1];
				else
					triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);

				if(i == n - 1)
					maxSum = Math.max(maxSum, triangle[i][j]);
			}
		}

		bw.write(Integer.toString(n == 1 ? triangle[0][0] : maxSum));
		br.close();
		bw.flush();
		bw.close();
	}
}