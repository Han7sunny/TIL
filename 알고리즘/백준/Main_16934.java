import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

//	BOJ_16934	111812kb	644ms
public class Main_16934 {
	
	public static class TrieNode {
		
		private Map<Character, TrieNode> child;
		private Map<Character, Integer> count;
		private boolean isLast;	//	해당 단어의 마지막 여부
		
		public TrieNode() {
			this.child = new HashMap<>();
			this.count = new HashMap<>();
			this.isLast = false;
		}
	}
	
	public static class Trie {
		
		private TrieNode root;
		
		public Trie() {
			this.root = new TrieNode();
		}
		
		//	가입과 동시에 별칭 반환
		public String register(String nickname) {
			
			TrieNode node = root;
			int length = nickname.length();
			int idx = length - 1;
			
			for (int i = 0; i < length; i++) {
				char c = nickname.charAt(i);
				
				if(!node.child.containsKey(c)) {
					node.child.put(c, new TrieNode());
					if(idx == length - 1)
						idx = i;
				}
				
				if(i < length - 1)
					node = node.child.get(c);
				else {
					node.isLast = true;
					node.count.put(c, node.count.getOrDefault(c, 0) + 1);
				}
			}

			//	이전에 가입한 닉네임 prefix 존재할 경우
			if(idx == length - 1) {
				return nickname + (node.count.get(nickname.charAt(idx)) == 1 ? "" : node.count.get(nickname.charAt(idx)));
			}
			else {
				return nickname.substring(0, idx + 1);
			}
			
			
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Trie root = new Trie();
		
		for (int i = 0; i < N; i++) {
			String alias = root.register(br.readLine());
			answer.append(alias).append("\n");
		}
		
		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
		
	}

}
