import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ 1449 11704kb 84ms
public class Main_1449_수리공항승 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 물이 새는 곳 개수
		int L = Integer.parseInt(st.nextToken()); // 테이프 길이
		int[] pos = new int[N];
		int answer = 1;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pos[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(pos);
		
		double end =  pos[0] + L - 0.5;
		for (int i = 1; i < N; i++) {
			if(pos[i] < end)
				continue;
			
			answer++;
			end = pos[i] +  L - 0.5;
		}
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}
}