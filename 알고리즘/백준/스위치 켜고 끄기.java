import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		int[] switchStatus = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++)
			switchStatus[i] = Integer.parseInt(st.nextToken());
		int student = Integer.parseInt(br.readLine());
		for (int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			switch (s) {
				case 1:
					for(int j = n - 1; j < num; j+=n) 
						switchStatus[j] = (switchStatus[j] == 0) ? 1 : 0;
					break;
                    
				case 2:
					switchStatus[n - 1] = (switchStatus[n - 1] == 0) ? 1 : 0;
					int idx = 1;
					while(n - 1 - idx >= 0 && n - 1 + idx < num) {
						if(switchStatus[n - 1- idx] != switchStatus[n - 1 + idx])
							break;
						else {
							switchStatus[n - 1 - idx] = (switchStatus[n - 1 - idx] == 0) ? 1 : 0;
							switchStatus[n - 1 + idx] = (switchStatus[n - 1 + idx] == 0) ? 1 : 0;						
						}
						idx++;
					}
					break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= num; i++) { // 한 줄에 20개씩
			sb.append(switchStatus[i-1]);
			if(i % 20 != 0)
				sb.append(" ");
			else
				sb.append("\n");
		}
		br.close();
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}

}
