import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_22945	22908kb	228ms
public class Main_22945 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		int[] power = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			power[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0;
		int e = N - 1;
		
		while(s < e) {
			
			answer = Math.max(answer, (e - s - 1) * Math.min(power[s], power[e]));
			
			if(power[s] < power[e])
				s++;
			else
				e--;
		}
		
		
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
