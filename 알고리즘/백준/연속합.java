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
		String[] numbers = br.readLine().split(" ");
		int[] num = new int[N];
		int[] sum = new int[N];
		int answer = Integer.MIN_VALUE;
		for(int i = 0; i< N; i++) {
			num[i] = Integer.parseInt(numbers[i]);
			if(i == 0)
				sum[i] = num[i];
			else
				sum[i] = Math.max(sum[i-1] + num[i], num[i]);
			answer = answer < sum[i] ? sum[i] : answer;
		}
		br.close();
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}
}
