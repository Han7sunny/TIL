import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int N;
	static int[][] team;
	static int answer = Integer.MAX_VALUE;

	public static int[] otherTeam(boolean[] picked) {
		int[] otherTeam = new int[N/2];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if(picked[i] == false)
				otherTeam[idx++] = i;
		}
		return otherTeam;
	}

	public static int synergy(int[] teamComb, int[] picked, int k, int preIdx) {
		int sum = 0;
		if (k == 2) {
			return sum += team[picked[0]][picked[1]];
		}

		for (int i = 0; i < teamComb.length; i++) {
			if (k == 0) {
				picked[k] = teamComb[i];
				sum += synergy(teamComb, picked, k + 1, i);
			} else {
				if (i != preIdx) {
					picked[k] = teamComb[i];
					sum += synergy(teamComb, picked, k + 1, i);
				}
			}
		}
		return sum;
	}

	public static void teamComb(int[] myTeam, boolean[] picked, int k, int idx) {
		if (k == N/2) {
			int teamA = synergy(myTeam, new int[2], 0, 0);
			int teamB = synergy(otherTeam(picked), new int[2], 0, 0);
			answer = Math.min(answer, Math.abs(teamA - teamB));
			return;
		}
        int len = N;
		if (k == 0) {
			len = 1;
		}
		for (int i = idx; i < len; i++) {
			myTeam[k] = i;
			picked[i] = true;
			teamComb(myTeam, picked, k + 1, i + 1);
			picked[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		team = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		teamComb(new int[N/2], new boolean[N], 0, 0);
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

}
