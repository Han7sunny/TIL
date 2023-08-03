import java.util.*;
import java.io.*;
class Solution {
    
    int[][] aroundTwoDist = 
    {
        {-1,-1}, {-1, 1}, {1, 1}, {1, -1},
        {-2, 0}, {0, 2}, {2, 0}, {0, -2}
    };
    int[][] cross = {{0, -1}, {-1, 0},{0, 1},{1, 0},{0, -1}};
    int[][] next = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public class Loc{
        
        int x, y;
        
        Loc(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    public int checkDist (Queue<Loc> q, char[][] room) {
        
        //  1. 2 이하의 거리에 응시자 있는지 확인
            //  1-1. 응시자 있을 경우
            //  1-2. 사이에 빈칸 하나라도 있으면 0 반환 (거리두기 실패)
        int check = 1;
        
        while(!q.isEmpty()){
            
            Loc now = q.poll();
            
            //  1 거리에 응시자 있는지 확인
            for(int i = 0; i < 4; i++){
                int nx = now.x + next[i][0];
                int ny = now.y + next[i][1];
                
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || room[nx][ny] != 'P') continue;
                
                return 0;
            }
            
            //  대각선에 응시자 있는지 확인
            for(int i = 0; i < 4; i++){
                
                int nx = now.x + aroundTwoDist[i][0];
                int ny = now.y + aroundTwoDist[i][1];
                
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || room[nx][ny] != 'P') continue;
                
                for(int j = i; j <= i + 1; j++){
                    int nx2 = now.x + cross[j][0];
                    int ny2 = now.y + cross[j][1];
                    
                    if(nx2 < 0 || ny2 < 0 || nx2 >= 5 || ny2 >= 5 || room[nx2][ny2] == 'X') continue;
                    
                    return 0;
                }
            }
            
            //  가로/세로에 응시자 있는지 확인
            for(int i = 4; i < 8; i++){
                int nx = now.x + aroundTwoDist[i][0];
                int ny = now.y + aroundTwoDist[i][1];
                
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || room[nx][ny] != 'P') continue;
                
                int nx2 = now.x + next[i - 4][0];
                int ny2 = now.y + next[i - 4][1];
                
                if(nx2 < 0 || ny2 < 0 || nx2 >= 5 || ny2 >= 5 || room[nx2][ny2] == 'X') continue;
                
                return 0;   
                
            }
            
        }
        
        return check;
    }
    public int[] solution(String[][] places) {
        
        int[] answer = new int[5];
        for(int p = 0; p < places.length; p++){
            Queue<Loc> q = new ArrayDeque<>();
            char[][] room = new char[5][5];
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    room[i][j] = places[p][i].charAt(j);
                    if(room[i][j] == 'P')
                        q.offer(new Loc(i,j));
                }
            }
            answer[p] = checkDist(q, room);
        }
        return answer;
    }
}
