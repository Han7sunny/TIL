import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//	BOJ_1068 11704kb 76ms 
public class Main_1068 {

	static int removeNode;
	static int root;
	static Node[] nodeList;
	
	public static class Node {
		
		int parent;
		List<Integer> childNodes;
		int childSize;
		
		public Node() {
			this.childNodes = new ArrayList();
		}

		public void addChild(int child) {
			this.childNodes.add(child);
			this.childSize++;
		}
		
		public void setParent(int parent) {
			this.parent = parent;
		}
		
		public int getParent() {
			return this.parent;
		}
		
	}
	
	public static int countLeafNode(int node) {
		
		int totalLeafNode = 0;
		
		//	현재 노드가 제거하려는 노드일 경우
		if(node == removeNode) {
			//	현재 노드가 제거된 후 
			//	부모 노드의 자식 개수가 0일 경우 부모 노드가 리프 노드가 되므로 1
			//	부모 노드의 자식 개수가 0이 아닐 경우 부모 노드의 자식 노드들을 탐색해야하므로 0
			return nodeList[nodeList[node].getParent()].childSize - 1 == 0 ? 1 : 0;
		}
		//	현재 노드가 리프 노드인 경우
		else if(nodeList[node].childSize == 0) {
			return 1;
		}

		for (int i = 0; i < nodeList[node].childSize; i++) {
			totalLeafNode += countLeafNode(nodeList[node].childNodes.get(i));
		}
		return totalLeafNode;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		root = 0;
		nodeList = new Node[N];
		
		for (int i = 0; i < N; i++) {
			nodeList[i] = new Node();
		}

		st = new StringTokenizer(br.readLine());
		for (int node = 0; node < N; node++) {
			int parent = Integer.parseInt(st.nextToken());
			
			nodeList[node].setParent(parent);
			
			if(parent == -1) {
				root = node;
				continue;
			}
			
			nodeList[parent].addChild(node);
		}

		removeNode = Integer.parseInt(br.readLine());
		
		int answer = 0; // 총 리프 노드의 개수
		if(removeNode != root)
			answer = countLeafNode(root);

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

}
