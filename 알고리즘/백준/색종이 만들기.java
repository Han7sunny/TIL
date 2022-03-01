import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] count = new int[2];
	public static void paper(int x, int y, int length, String[][] p) {
		if(length == 1) {
			count[Integer.parseInt(p[x][y])]++;
			return;
		}
		boolean diff = false;
		for(int i = x; i < x + length; i++) {
			for(int j = y; j < y + length; j++) {
				if(!p[x][y].equals(p[i][j])) {
					diff = true;
					break;
				}
			}
			if (diff)
				break;
		}
		
		if(diff) {
			paper(x, y, length / 2, p);
			paper(x + length / 2, y, length / 2, p);
			paper(x, y + length / 2, length / 2, p);
			paper(x + length / 2, y + length / 2, length / 2, p);
		}else {
			count[Integer.parseInt(p[x][y])]++;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[][] p = new String[N][N];
		for(int i = 0; i < N; i++) {
			p[i] = br.readLine().split(" ");			
		}	
		paper(0,0,N,p);
		for(int cnt:count) {
			bw.write(cnt+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
