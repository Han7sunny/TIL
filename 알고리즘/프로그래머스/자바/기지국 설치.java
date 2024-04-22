class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int answer = 0;
        int pre = 1;
        int spread = 2 * w + 1;
      
        for(int i = 0; i < stations.length; i++){
            if(pre < stations[i] - w){  //  조건 추가해줘야 정답
                int dist = stations[i] - w - pre;
                answer += dist % spread == 0 ? dist / spread : dist / spread + 1;
            }
            pre = stations[i] + w + 1;
        }
            
        if(pre <= n){
            int dist = n - pre + 1;
            answer += dist % spread == 0 ? dist / spread : dist / spread + 1;
        }

        return answer;
      
    }
}
