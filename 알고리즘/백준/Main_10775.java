import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//	BOJ_10775	21740kb	208ms
public class Main_10775 {

	static int[] candidate;

	public static int find(int x) {
		if (candidate[x] == x)
			return x;
		return candidate[x] = find(candidate[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y)
			candidate[x] = y;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int answer = 0;
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		candidate = new int[G + 1];
		
		for (int i = 1; i <= G; i++) {
			candidate[i] = i;
		}

		boolean isClosed = false; // 공항 폐쇄 여부

		for (int p = 0; p < P; p++) {

			int gNum = Integer.parseInt(br.readLine()); // 1번 ~ gNum번 게이트 중 하나
			
			if (isClosed)
				continue;

			int gate = find(gNum);
			
			if (gate == 0) {
				isClosed = true;
				continue;
			}

			union(gate, gate - 1);
			answer++;

		}

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
