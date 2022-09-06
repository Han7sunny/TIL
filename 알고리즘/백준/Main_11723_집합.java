import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_11723_집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();
		StringTokenizer st;
		
		HashMap<String, Integer> S = new HashMap<>();
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "add":
				String addX = st.nextToken();
				if(!S.containsKey(addX))
					S.put(addX, 1);
				break;
			case "remove":				
				String removeX = st.nextToken();
				if(S.containsKey(removeX))
					S.remove(removeX);
				break;
			case "check":
				if(S.containsKey(st.nextToken()))
					result.append("1\n");
				else
					result.append("0\n");
				break;
			case "toggle":
				String toggleX = st.nextToken();
				if(S.containsKey(toggleX))
					S.remove(toggleX);
				else
					S.put(toggleX, 1);
				break;
			case "all":
				S.clear();
				for (int x = 1; x <= 20; x++) {
					S.put(Integer.toString(x), 1);
				}
				break;
			case "empty":
				S.clear();
			}
		}
		bw.write(result.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
