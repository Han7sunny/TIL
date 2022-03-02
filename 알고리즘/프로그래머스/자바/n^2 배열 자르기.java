class Solution {
    public int[] solution(int n, long left, long right) {
		long l1 = left / n;
		long l2 = left % n;
		long r1 = right / n;
		long r2 = right % n;
    int arrayLength = (int) ((r1-l1-1)*n + n-l2+r2+1);
		int[] answer = new int[arrayLength];
    l1++;   l2++;   r1++;   r2++;
		int idx = 0;
		for(long i = l1; i <= r1; i++) {
			for(long j = 1; j <= n; j++) {
			  if((i == l1 && j < l2) || (i == r1 && j > r2))
					continue;
				if(j <= i)
					answer[idx++] = (int) i;
				else
					answer[idx++] = (int) j;
			}
		}
		return answer;
    }
}
