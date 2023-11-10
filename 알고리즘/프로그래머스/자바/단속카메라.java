import java.util.*;
class Solution {
    public int solution(int[][] routes) {    
        
        //  모든 차량 카메라 한 번은 만나야 함 -> 진입 또는 진출 지점
        //  진출 기준 오름차순 정렬
        Arrays.sort(routes, (r1, r2) -> (r1[1] - r2[1]));
        
        //  제일 첫번째 진출 지점에 카메라 설치
        int answer = 1;
        int camera = routes[0][1];
        
        for(int i = 1; i < routes.length; i++){
            
            //  다음 진입 지점과 카메라가 만나지 않는다면
            //  다음 진출 지점에 카메라 추가 설치
            if(camera < routes[i][0]){
                camera = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}
