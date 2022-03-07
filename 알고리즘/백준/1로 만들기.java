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
		if(N == 1)
			bw.write(0+"\n");
		else {
			int[] cal = new int[N + 1];
			for(int i = 1; i <= N; i++) {
				if(i == 1) {
					cal[i] = 0;
					continue;
				}
				
				if(i % 3 == 0 &&  i % 2 == 0)
					cal[i] = Math.min(cal[i/3], cal[i/2]) + 1;
				else if (i % 3 == 0)
					cal[i] = Math.min(cal[i/3], cal[i-1]) + 1;
				else if (i % 2 == 0)
					cal[i] = Math.min(cal[i/2], cal[i-1]) + 1;
				else
					cal[i] = cal[i-1] + 1;
			}
			bw.write(cal[N] + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
