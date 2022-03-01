import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static String[][] p;
	static int minusOne = 0;
	static int zero = 0;
	static int one = 0;
	public static void paper(int x, int y, int length){
		if(length == 1)  {
			if (p[x][y].equals("-1"))
				minusOne++;
			else if (p[x][y].equals("0"))
				zero++;
			else // "1"
				one++;
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
			int newLength = length / 3;
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					paper(x + newLength * j, y + newLength * i, newLength);
                }
            }
		}else {
			if (p[x][y].equals("-1"))
				minusOne++;
			else if (p[x][y].equals("0"))
				zero++;
			else // "1"
				one++;		
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		p = new String[N][N];
		for(int i = 0; i < N; i++) {
			p[i] = br.readLine().split(" ");			
		}	
		paper(0,0,N);
		bw.write(minusOne + "\n");		
		bw.write(zero + "\n");
		bw.write(one + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
