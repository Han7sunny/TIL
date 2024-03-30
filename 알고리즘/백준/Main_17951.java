import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//	BOJ_17951	21612kb	228ms
public class Main_17951 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//	시험지 개수
		int K = Integer.parseInt(st.nextToken());	//	시험지를 나눌 그룹의 수
		
		int answer = 0;

		int[] score = new int[N];
		int[] sum = new int[N + 1];
		
		//	K개 그룹으로 나누기
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			score[i - 1] = Integer.parseInt(st.nextToken());
			sum[i] += sum[i - 1] + score[i - 1];
		}
		
		if(N == K) {
			Arrays.sort(score);
			answer = score[0];
		}
		else {
			
			int l = 0;
			int r = sum[N];
			
			while(l <= r) {
				
				int m = (l + r) / 2;	//	그룹의 최소 시험 점수
				int pre = 0;
				int cnt = 1;
				
				//	그룹 개수 count
				for (int i = 1; i <= N; i++) {
					if(sum[i] - sum[pre] >= m) {
						cnt++;
						pre = i;
					}
				}
				
				//	그룹 개수 확인
				if(cnt > K)
					l = m + 1;
				else
					r = m - 1;
				
			}
			
			answer = r;
			
		}
		
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
