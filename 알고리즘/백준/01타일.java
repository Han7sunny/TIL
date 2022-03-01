import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		if(N < 4) {
			br.close();
			bw.write(Long.toString(N));
			bw.flush();
			bw.close();
		}
		else {
			long[] bin = new long[N+1];
			bin[1] = 1; // 1
			bin[2] = 2; // 00, 11
			bin[3] = 3; // 100, 001, 111
			for(int i = 4; i <= N; i++)
				bin[i] = (bin[i-2]+bin[i-1]) % 15746;
			br.close();
			bw.write(Long.toString(bin[N]));
			bw.flush();
			bw.close();
		}
	}
}
