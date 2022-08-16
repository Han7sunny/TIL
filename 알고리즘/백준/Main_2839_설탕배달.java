import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//BOJ 2839 설탕배달 14,288kb 136ms
//5로 나뉘지 않을 경우 5로 나뉠때까지 3을 감소시켜가며 풀었습니다.
public class Main_2839_설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
	
		if (N % 5 == 0) {
			answer = N / 5;
		}else { // 5로 나뉠 수 있도록
			while(N % 5 != 0) {
				N -= 3;
				answer++;
			}
			if(N % 5 == 0 && N >= 0)
				answer += N / 5;
			else
				answer = -1;
		}
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

}
