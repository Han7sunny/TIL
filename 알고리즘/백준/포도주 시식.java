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
		int[] wine = new int[N];
		int[] answer = new int[N];
		for(int i = 0; i < N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
			if(i == 0)
				answer[i] = wine[i];
			else if(i == 1)
				answer[i] = answer[i-1] + wine[i];
			else if(i == 2)
				answer[i] = Math.max(answer[i-1], Math.max(wine[i-1], wine[i-2]) + wine[i]);
			else
				answer[i] = Math.max(answer[i-1], Math.max(answer[i-2], answer[i-3] + wine[i-1])+ wine[i]);
		}
		br.close();
		bw.write(answer[N-1] + "\n");
		bw.flush();
		bw.close();
	}
}
