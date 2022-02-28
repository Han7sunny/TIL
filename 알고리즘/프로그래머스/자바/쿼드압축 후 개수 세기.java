class Solution {
    int[] answer = new int[2];
    public void check(int x, int y, int n, int[][] arr) {
      boolean diff = false;
      if (n == 1) {
        answer[arr[x][y]]++;
        return;
      }

      for(int i = x; i < x + n; i++) {
        for(int j = y; j < y + n; j++) {
          if(arr[x][y] != arr[i][j]) {
            diff = true;
            break;
          }
        }
        if(diff)
          break;
      }

      if(diff) {
        check(x, y, n/2, arr);
        check(x + n/2, y, n/2, arr);
        check(x,y + n/2, n/2, arr);
        check(x + n/2, y + n/2, n/2, arr);
      }else {
        answer[arr[x][y]]++;
      }
	}
    public int[] solution(int[][] arr) {
        check(0,0,arr.length,arr);
        return answer;
    }
}
