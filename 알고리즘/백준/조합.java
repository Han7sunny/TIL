import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;
public class Main { // 2407
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		BigInteger a = BigInteger.ONE; // 숫자 범위 제한 없음
		BigInteger b = BigInteger.ONE;
		
		for(int i = 1; i <= m; i++) {
			a = a.multiply(new BigInteger(String.valueOf(n - i + 1))); // 곱셈
			b = b.multiply(new BigInteger(String.valueOf(i))); // 곱셈
		}
		
		br.close();
		bw.write(a.divide(b) + "\n"); // 나눗셈
		bw.flush();
		bw.close();
	}
}
