import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main { // 14501
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] day = new int[n+2];
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
        
		// day : 현재 일 까지의 최대 수익 총합
    // N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대 수익
		for(int i = 1; i <= n; i++) {
			if(i + t[i] <= n + 1) {
				day[i + t[i]] = Math.max(day[i + t[i]], p[i] + day[i]);
			}
			day[i+1] = Math.max(day[i+1], day[i]); // p[i]는 i+t[i]에만 적용되는 것이 아닌 i부터 i+t[i]까지 적용
		}
		br.close();		
    bw.write(day[n+1] + "\n");
		bw.flush();
		bw.close();
	}
}
