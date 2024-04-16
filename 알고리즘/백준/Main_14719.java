import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_14719	11676kb	84ms
public class Main_14719 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());	//	√÷¥Î 500

		int answer = 0;
		
		int[] block = new int[W];
		int preIdx = 0;
		int maxIdx = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
			if(block[preIdx] <= block[i]) {
				for (int j = preIdx + 1; j < i; j++) {
					answer += block[preIdx] - block[j];
				}
				
				maxIdx = i;
				preIdx = i;
			}
		}
				
		preIdx = W - 1;
		for (int i = W - 2; i >= maxIdx; i--) {
			if(block[preIdx] <= block[i]) {
				for (int j = preIdx - 1; j > i; j--) {
					answer += block[preIdx] - block[j];
				}
				preIdx = i;
			}
		}

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
