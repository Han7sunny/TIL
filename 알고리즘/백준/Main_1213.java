import java.io.*;

//  BOJ_1213    11612kb 80ms
public class Main_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String answer = "";
        StringBuilder left = new StringBuilder();
        String mid = "";
        int[] count = new int[26];    //  A-Z의 개수
        int oddCount = 0; // 홀수 개수 가지는 알파벳 개수

        String name = br.readLine();

        int length = name.length();
        for (int i = 0; i < length; i++) {
            count[name.charAt(i) - 65]++;
        }

        //  홀수개 가지는 알파벳 1개 초과면 팰린드롬 만들 수 없음
        for (int i = 0; i < 26; i++) {
            if(count[i] % 2 != 0) {
                oddCount++;
                mid = String.valueOf((char)(i + 65));
            }
        }

        if(oddCount <= 1) {

            //  A부터 개수의 절반만큼 넣기
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < count[i] / 2; j++) {
                    left.append((char) (i + 65));
                }
            }

            answer += left.toString();

            if(oddCount == 1)
                answer += mid;

            answer += left.reverse().toString();

        }

        br.close();
        bw.write(answer.isEmpty() ? "I'm Sorry Hansoo" : answer);
        bw.flush();
        bw.close();
    }
}
