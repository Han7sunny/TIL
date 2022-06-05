import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main { // 2559
  // 처음에 n개의 정수들의 값이 -100 이상인 것을 간과하고 answer을 0으로 설정해서 틀림
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] temp = new int[n];
		int[] sum = new int[n];
		int answer = Integer.MAX_VALUE * -1;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
			if(i != 0)
				temp[i] += temp[i-1];
			if(i + 1 >= k) {
				sum[i] = temp[i];
				if(i - k >= 0)
					sum[i] -= temp[i-k];
				answer = Math.max(answer, sum[i]);					
			}
		}
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}
}
