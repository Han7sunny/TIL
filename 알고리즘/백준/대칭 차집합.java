import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main { // 1269
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashSet<Integer> setA = new HashSet<>();
		HashSet<Integer> setB = new HashSet<>();
		HashSet<Integer> set = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
        
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < a; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}
        
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < b; i++){
			setB.add(Integer.parseInt(st.nextToken()));
		}
		
		set.addAll(setA); // set에 setA 복사
		setA.removeAll(setB); // setA - setB // 차집합
		setB.removeAll(set); // setB - 복사된 setA // 차집합

		br.close();
		bw.write(Integer.toString(setA.size()+setB.size()));
		bw.flush();
		bw.close();
	}
}
