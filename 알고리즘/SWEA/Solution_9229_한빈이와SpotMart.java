import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart {
//	SWEA 9229 한빈이와 Spot Mart 24,076kb 139ms
//	투 포인터를 사용하여 풀었습니다.
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] weight = new int[N];
			st = new StringTokenizer(br.readLine());			
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(weight);
			int start = 0;
			int end = N - 1;
			int answer = -1;
			while(start < end) {
				if(weight[start] + weight[end] <= M) {
					answer = Math.max(answer, weight[start] + weight[end]);
					start++;
				}
				else
					end--;
			}
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
