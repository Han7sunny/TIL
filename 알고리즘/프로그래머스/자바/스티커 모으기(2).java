class Solution {
    public int solution(int sticker[]) {

        //  선택할 수도 있고 안 할 수도 있고
        int N = sticker.length;
        
        if(N == 1)
            return sticker[0];
        
        int[][] dp = new int[N][2]; //  현재까지 최댓값
        
        dp[0][0] = sticker[0];  //  첫번째 선택
        dp[1][0] = dp[0][0];
        
        dp[1][1] = sticker[1];  //  첫번째 선택 안 함
        
        for(int i = 2; i < N - 1; i++){
            dp[i][0] = Math.max(dp[i - 2][0]  + sticker[i], dp[i - 1][0]);
        }
        
        for(int i = 2; i < N; i++){
            dp[i][1] = Math.max(dp[i - 2][1] + sticker[i], dp[i - 1][1]);
        }
        
        return Math.max(dp[N - 2][0], dp[N - 1][1]);
    }
}
