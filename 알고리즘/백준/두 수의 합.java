import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main { // 3273
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int answer = 0;
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(num);
		
		int start = 0;
		int end = num.length - 1;
		int sum = 0;
		while(start < end) {
			sum = num[start] + num[end];
			if(sum == x) {
				answer++;
				start++;
				end--;
			}
			else if(sum < x)
				start++;
			else
				end--;
		}
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}
}
