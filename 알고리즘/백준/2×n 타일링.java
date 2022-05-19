import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	static int[] answer;
	public static int tile(int width) { // Memoization
		if(width == 1)
			return 1;
		
		if(width == 2)
			return 2;
		
		if(answer[width] != 0)
			return answer[width];
		else
			answer[width] = (tile(width - 2) + tile(width - 1)) % 10007;
		return answer[width];
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		answer = new int[n+1];
		br.close();
		bw.write(Integer.toString(tile(n) % 10007)); // Memoization
    
    // DP
//     for(int i = 1; i <= n; i++) {
// 			if(i == 1)
// 				answer[i] = 1;
// 			else if (i == 2)
// 				answer[i] = 2;
// 			else
// 				answer[i] = (answer[i-2] + answer[i-1] ) % 10007;
// 		}
//     bw.write(Integer.toString(answer[n] % 10007));

		bw.flush();
		bw.close();
	}
}
