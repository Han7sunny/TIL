import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main_14889_스타트와링크 {
	static int[][] team;
	static int answer = Integer.MAX_VALUE;

	public static int[] otherTeam(int[] team, int[] picked) {
		boolean[] checkedTeam = new boolean[team.length];
		int[] otherTeam = new int[picked.length];
		int idx = 0;
		for (int i = 0; i < team.length && idx < picked.length; i++) {
			if (team[i] == picked[idx]) {
				checkedTeam[i] = true;
				idx++;
			}
		}

		idx = 0;
		for (int i = 0; i < team.length && idx < picked.length; i++) {
			if (!checkedTeam[i]) {
				otherTeam[idx++] = team[i];
			}
		}
		return otherTeam;
	}

	public static int synergy(int[] teamComb, int[] picked, int k, int preIdx) {
		// 2개
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

	public static void teamComb(int[] myTeam, int[] picked, int k, int idx, int length) {
		if (k == length) {
			int teamA = synergy(picked, new int[2], 0, 0);
			int teamB = synergy(otherTeam(myTeam, picked), new int[2], 0, 0);
			answer = Math.min(answer, Math.abs(teamA - teamB));
			return;
		}
		int len = myTeam.length;
		if (k == 0) {
			len = 1;
		}
		for (int i = idx; i < len; i++) {
			picked[k] = myTeam[i];
			teamComb(myTeam, picked, k + 1, i + 1, length);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		team = new int[N][N];
		int[] teamNum = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			teamNum[i] = i;
			for (int j = 0; j < N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		teamComb(teamNum, new int[N / 2], 0, 0, N / 2);
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}
}
