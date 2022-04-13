import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		int n = Integer.parseInt(br.readLine());
		int[] budget = new int[n];
		int answer = 0;
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			sum += budget[i];
		}
		Arrays.sort(budget);
		int m = Integer.parseInt(br.readLine());
		if(sum <= m)
			bw.write(budget[budget.length - 1] + "\n");
		else {
			sum = 0;
			int left = 0;
			int right = budget[budget.length - 1];
			while(left <= right) {
				int mid = (left + right) / 2;
				for(int i = 0; i < budget.length; i++) {
					if(mid >= budget[i])
						sum += budget[i];
					else
						sum += mid;
				}
				if(sum > m)
					right = mid - 1;
				else {
					left = mid + 1;
					answer = mid;
				}
				sum = 0;
			}
			bw.write(answer + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
