import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] triangle = new int[N][];
		int answer= Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			String[] t = br.readLine().split(" ");
			triangle[i] = new int[i+1];
			for(int j = 0; j < t.length; j++) {
				triangle[i][j] = Integer.parseInt(t[j]);
				if(i == 0) {
					if(N == 1)
						answer = triangle[i][j];
					continue;
				}
                
				if(j == 0)
					triangle[i][j] += triangle[i-1][j];
				else if(j == i)
					triangle[i][j] += triangle[i-1][j-1];
				else
					triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
					
				if(i == N-1)
					answer = answer < triangle[i][j] ? triangle[i][j] : answer;
			}
		}
		br.close();
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}
}
