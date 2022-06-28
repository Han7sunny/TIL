import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.HashSet;
import java.util.StringTokenizer;
public class Main { // 11478
	public static void main(String[] args) throws IOException {
    //		 TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Set<String> subString = new HashSet<>();
		String s = br.readLine();
		for(int i = 0; i < s.length(); i++) {
			for(int j = i + 1; j <= s.length(); j++) {
				subString.add(s.substring(i,j));
			}
		}
		br.close();
		bw.write(Integer.toString(subString.size()));
		bw.flush();
		bw.close();
	}
}
