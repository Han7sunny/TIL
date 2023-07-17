import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

//	BOJ_7432 23720kb 248ms
public class Main_7432 {

	static StringBuilder answer = new StringBuilder();

	public static class Directory {

		TreeMap<String, Directory> children;

		public Directory() {
			this.children = new TreeMap<>();
		}

	}

	public static void print(Directory root, int level) {

		if (!root.children.isEmpty()) {

			for (Entry<String, Directory> dir : root.children.entrySet()) {
				for (int i = 0; i < level; i++) {
					answer.append(" ");
				}
				answer.append(dir.getKey()).append("\n");
				print(dir.getValue(), level + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		Directory root = new Directory();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			
			Directory dRoot = root;
			st = new StringTokenizer(br.readLine(), "\\");
			
			while (st.hasMoreTokens()) {
				
				String dir = st.nextToken();

				if (!dRoot.children.containsKey(dir))
					dRoot.children.put(dir, new Directory());

				dRoot = dRoot.children.get(dir);
			}

		}

		print(root, 0);

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
