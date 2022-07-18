import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main { // 7662

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			TreeMap<Integer,Integer> data = new TreeMap<>();
			int k = Integer.parseInt(br.readLine());
			for(int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if(op.equals("I")) {
					data.put(num, data.getOrDefault(num, 0) + 1);
				}
				else { // D
					if(data.isEmpty())
						continue;
					int n;
					if(num == 1) { // 최댓값 삭제
						n = data.lastKey();
					}else {
						n = data.firstKey();
					}
					
					if(data.get(n) == 1)
						data.remove(n);
					else
						data.put(n, data.get(n) - 1);
				}
			}
			if(data.isEmpty())
				bw.write("EMPTY\n");
			else
				bw.write(data.lastKey() + " " + data.firstKey() + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
