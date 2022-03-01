import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static String[][] p;
	static BufferedWriter bw;
	public static void tree(int x, int y, int length) throws IOException {
		if(length == 1)  {
			bw.write(p[x][y]);
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
			int newLength = length / 2;
			bw.write("(");
			tree(x, y, newLength);
			tree(x, y + newLength, newLength);
			tree(x + newLength, y, newLength);
			tree(x + newLength, y + newLength, newLength);
			bw.write(")");
		}else {
			bw.write(p[x][y]);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		p = new String[N][N];
		for(int i = 0; i < N; i++) {
			p[i] = br.readLine().split("");			
		}	
		tree(0,0,N);
		br.close();
		bw.flush();
		bw.close();
	}
}
