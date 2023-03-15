import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_10726 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int allOnlastNBit = (1 << N) - 1;
			
			String check;
			
			if(allOnlastNBit == ( M & allOnlastNBit ))
				check = "ON";
			else
				check = "OFF";
			
			answer.append("#").append(test_case).append(" ").append(check).append("\n");
		}
		
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();
		
	}

}
