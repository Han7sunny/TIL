import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11660_구간합구하기5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][n];
		int[][] sum = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum[i][j] = arr[i][j];
				if(j != 0) {
					sum[i][j] += sum[i][j - 1];
				}
			}
		}

		
		for (int i = 0; i < m; i++) {
			int result = 0;
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			
			if (x1 == x2 && y1 == y2)
				result = arr[x1][y1];
            else{
			    for(int j = x1; j <= x2 ; j++) {
				    if(y1 == 0)
					    result += sum[j][y2];
				    else
					    result += sum[j][y2] - sum[j][y1 - 1];
			    }
            }
			bw.write(result + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
