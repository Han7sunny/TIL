import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = (long) n * (long) times[times.length - 1]; // 최악의 경우
        long answer = right;
        while(left <= right){
            long mid = (left + right) / 2; // 심사 받는데 걸리는 시간 -> 이것을 탐색해서 인원(target,,고정값) 비교
            long sum = 0;
            for(int i = 0; i < times.length; i++){
                sum += mid / times[i];
                if(sum >= n)
                    break;
            }
            if(sum < n)
                left = mid + 1;
            else{ // 최소 시간 찾을 때까지..
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
