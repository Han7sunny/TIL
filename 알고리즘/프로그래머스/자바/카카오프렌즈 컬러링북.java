import java.util.Queue;
import java.util.LinkedList;
class Solution {
  int M;
	int N;
	int[] x = {0,0,-1,1};
	int[] y = {-1,1,0,0};
    
	public int areaSize(int a, int b, int color, int[][] picture) {
		int answer = 1;
    Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a,b});
    picture[a][b] = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i < x.length; i++) {
				int locX = x[i] + now[0];
				int locY = y[i] + now[1];
				if(0 <= locX && locX < M && 0 <= locY && locY < N) {
					if(color == picture[locX][locY]) {
						answer++;
						q.add(new int[] {locX,locY});
						picture[locX][locY] = 0;
					}
				}
			}
		}
		return answer;
	}
  public int[] solution(int m, int n, int[][] picture) {
    int[][] p = new int[m][n];
    for(int i = 0; i < m; i++) // 복사
      for(int j = 0; j < n; j++)
        p[i][j] = picture[i][j];
    M = m; N = n;
		int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
        
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(p[i][j] != 0) {
          numberOfArea++;     		
        	int size = areaSize(i,j,p[i][j],p);
        	maxSizeOfOneArea = maxSizeOfOneArea < size ? size : maxSizeOfOneArea;
       	}
     	}
    }
		return new int[] {numberOfArea, maxSizeOfOneArea};
    }
}
