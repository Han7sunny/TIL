import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main_1302_베스트셀러 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int max = 0;
		
		Map<String, Integer> bookTitleList = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String t = br.readLine();
			bookTitleList.put(t, bookTitleList.getOrDefault(t, 0) + 1);
			max = Math.max(max, bookTitleList.get(t));
		}
		
		ArrayList<String> list = new ArrayList<>();
		
		for (Entry<String, Integer> bookTitle : bookTitleList.entrySet()) {
			if(bookTitle.getValue() == max) {
				list.add(bookTitle.getKey());
			}
		}
		
		Collections.sort(list);
		
		bw.write(list.get(0));
		br.close();
		bw.flush();
		bw.close();
	}

}
