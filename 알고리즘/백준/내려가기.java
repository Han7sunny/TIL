import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main { // 2096
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] maxPoint = new int[n][3];
		int[][] minPoint = new int[n][3];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
			if(i == 0) {
				maxPoint[i] = new int[] {n1,n2,n3};
				minPoint[i] = new int[] {n1,n2,n3};
			}
			else {
				maxPoint[i][0] = Math.max(maxPoint[i-1][0], maxPoint[i-1][1]) + n1;
				maxPoint[i][1] = Math.max(Math.max(maxPoint[i-1][0], maxPoint[i-1][1]), maxPoint[i-1][2]) + n2;
				maxPoint[i][2] = Math.max(maxPoint[i-1][1], maxPoint[i-1][2]) + n3;
				
				minPoint[i][0] = Math.min(minPoint[i-1][0], minPoint[i-1][1]) + n1;
				minPoint[i][1] = Math.min(Math.min(minPoint[i-1][0], minPoint[i-1][1]), minPoint[i-1][2]) + n2;
				minPoint[i][2] = Math.min(minPoint[i-1][1], minPoint[i-1][2]) + n3;
			}
		}
		int answer1 =  Math.max(Math.max(maxPoint[n-1][0], maxPoint[n-1][1]), maxPoint[n-1][2]);
		int answer2 = Math.min(Math.min(minPoint[n-1][0], minPoint[n-1][1]), minPoint[n-1][2]);
		
		br.close();
		bw.write(answer1 + " " + answer2 + "\n");
		bw.flush();
		bw.close();
	}
}
