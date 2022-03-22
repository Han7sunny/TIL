import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		String input = br.readLine();
		String[] number = input.split("[+-]");
		String[] op = input.split("[0-9]+");
		
		int sum = Integer.parseInt(number[0]); // 가장 처음과 마지막 문자는 숫자이다.
		int minusIdx = Integer.MAX_VALUE;
		for(int i = 1; i < number.length; i++) {
			if(op[i].equals("-")) {
				minusIdx = i;
				sum += Integer.parseInt(number[i]) * -1;
			}else { // +
				if(minusIdx < i)
					sum += Integer.parseInt(number[i]) * -1;
				else
					sum += Integer.parseInt(number[i]);
			}
		}
		br.close();
		bw.write(sum + "\n");
		bw.flush();
		bw.close();
	}
}
