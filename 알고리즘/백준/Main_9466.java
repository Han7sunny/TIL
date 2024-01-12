import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9466 {
	
	static int[] pickNumber;
	static boolean[] visited;
	static boolean[] done;
	static int N, result;
	
	public static void findTeam(int num) {
		
		if(done[num]) return;
		
		if(visited[num]) {
			result++;
			done[num] = true;
		}
		
		visited[num] = true;
		findTeam(pickNumber[num]);	//	next
		done[num] = true;	// return, 검사 끝
		visited[num] = false;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			int N = Integer.parseInt(br.readLine()); // 학생의 수
			pickNumber = new int[N + 1];
			visited = new boolean[N + 1];
			done = new boolean[N + 1];
			result = 0;
			
			st = new StringTokenizer(br.readLine());

			// 선택된 학생들의 번호
			for (int i = 1; i <= N; i++) {
				pickNumber[i] = Integer.parseInt(st.nextToken());
				//	사이클 형성, done
				if(i == pickNumber[i]) {
					done[i] = true;
					result++;
				}
			}

			for (int i = 1; i <= N; i++) {
				if(!done[i]) {
					System.out.println("start : " + i);
					findTeam(i);
					
				}
			}

			answer.append(N - result).append("\n");
		}

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}

//	findTeam 흐름 예제 1)

//	num			4 -> 7 -> 6 -> 4 ->	7 -> 6 -> 4 (return, end)
//	visited		t	 t    t    t +  t +  t +  t
//	done					   t    t    t    t  