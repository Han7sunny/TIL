import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//	BOJ_1253	12936kb	136ms
public class Main_1253 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int answer = 0;

		int N = Integer.parseInt(br.readLine());
		long[] num = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(num);
		
		for (int i = 0; i < N; i++) {	
			
			int left = 0;
			int right = N - 1;
			
			while(left < right) {
				
				long sum = num[left] + num[right];
				
				if(sum == num[i]) {
					if(left == i)
						left++;
					else if(right == i)
						right--;
					else {
						answer++;
						break;
					}
				}
				else if(sum < num[i]) {
					left++;
				}
				else
					right--;
			}
		
		}



		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
