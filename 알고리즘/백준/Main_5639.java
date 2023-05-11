import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// BOJ_5639 16132kb 452ms
public class Main_5639 {
	
	static StringBuilder answer;
	
	public static class Node {
		int num;
		Node leftChild;
		Node rightChild;
		
		Node(int num){
			this.num = num;
		}
		
		void insert(int node) {
			if(this.num > node) {
				if(this.leftChild == null)
					this.leftChild = new Node(node);
				else
					this.leftChild.insert(node);
			}
			else {
				if(this.rightChild == null)
					this.rightChild = new Node(node);
				else
					this.rightChild.insert(node);
			}
		}
		
	}
	
	public static void searchNode(Node node) {
		if(node == null)
			return;
		
		searchNode(node.leftChild);
		searchNode(node.rightChild);
		answer.append(node.num).append("\n");
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		answer = new StringBuilder();

		Node root = new Node(Integer.parseInt(br.readLine()));
		String input;
		while (true) {
			input = br.readLine();
			if (input == null || input.equals(""))
				break;

			root.insert(Integer.parseInt(input));
		}

		searchNode(root);

		answer.deleteCharAt(answer.length() - 1);
		
		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
