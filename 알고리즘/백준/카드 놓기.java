import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main { // 18115

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
    Deque<Integer> d = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());
		String[] skills = br.readLine().split(" ");

		for(int card = 1; card <= n; card++) {
			switch(skills[n - card]) {
				case "1":
					d.offerFirst(card);
					break;
				case "2":
					int top = d.pollFirst();
					d.offerFirst(card);
					d.offerFirst(top);
					break;
				case "3":
					d.offerLast(card);
					break;
			}
		}

    StringBuilder sb = new StringBuilder();
		while(!d.isEmpty()) {
			sb.append(d.pollFirst());
			if(!d.isEmpty())
				sb.append(" ");
		}
		br.close();
		bw.write(sb.toString()); // 또는 trim()
		bw.flush();
		bw.close();
	}

}
