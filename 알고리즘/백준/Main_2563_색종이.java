import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2563_색종이 {
//	BOJ 2563 색종이 14,280kb 124ms
//	배열을 사용하여 색종이에 해당하는 부분을 체크해준 뒤 나중에 체크된 부분의 개수를 구하였습니다.
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] paper = new int[100][100];
		for (int p = 0; p < n; p++) { // 10*10 크기의 정사각형
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					paper[x+i][y+j] = 1;
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(paper[i][j] == 1)
					answer++;
			}
		}
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
		
	}

}
