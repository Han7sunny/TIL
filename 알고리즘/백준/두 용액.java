import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 2470
	
	public static void main(String[] args) throws IOException {
//		 TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] water = new int[n];
		int start = 0;
		int end = water.length - 1;
		
		for(int i = 0; i < n; i++) {
			water[i] = Integer.parseInt(st.nextToken());
		}
        
		Arrays.sort(water);
		
		int sum = 0;
		int mix = Integer.MAX_VALUE;
		int ans1 = 0;
		int ans2 = 0;
		while(start < end) {
			sum = water[start] + water[end];
			if(sum == 0) {
				mix = sum;
				ans1 = water[start];
				ans2 = water[end];
				break;
			}
			else if(Math.abs(sum) < mix) {
				mix = Math.abs(sum);
				ans1 = water[start];
				ans2 = water[end];
			}
			
			if(sum < 0)
				start++;
			else
				end--;
		}		
		br.close();
		bw.write(ans1 + " " + ans2 + "\n");
		bw.flush();
		bw.close();
	}
}
