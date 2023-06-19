import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

//	BOJ_14725 14032kb 128ms
public class Main_14725 {
	
	static StringBuilder answer = new StringBuilder();

	public static class Food {

		TreeMap<String, Food> childList;

		public Food() {
			childList = new TreeMap<>();
		}

	}
	
	public static void print(Food now, int level) {
		for (String info : now.childList.keySet()) {
			for (int l = 0; l < level; l++) {
				answer.append("--"); 
			}
			answer.append(info).append("\n");
			print(now.childList.get(info), level + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		Food entrance = new Food(); // root
		Food now;

		for (int i = 0; i < N; i++) {
			now = entrance;
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				String info = st.nextToken();
				if (!now.childList.containsKey(info)) {
					now.childList.put(info, new Food());
				}
				now = now.childList.get(info);

			}
		}
		
		// 출력		
		print(entrance, 0);

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();

	}

}
