import java.util.*;
import java.io.*;
class Solution {

    int N;
    List<String>[] idList;
    Map<String, Integer> userIdx;
    Set<Integer> result;
    
    //  순서 달라도 같은 것으로 인식 : 조합
    public void comb(int idx, int picked){
        
        if(idx == N){
            result.add(picked);
            return;
        }
        
        for(int i = 0; i < idList[idx].size(); i++){
            int idIdx = userIdx.get(idList[idx].get(i));
            if((picked & (1 << idIdx)) == 0){ // picked에서 안 뽑은 아이디
                comb(idx + 1, picked | (1 << idIdx));
            }
            
        }
        
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        
        N = banned_id.length;
        idList = new ArrayList[N];
        userIdx = new HashMap<>();
        result = new HashSet<>();
        
        for(int i = 0; i < N; i++){
            idList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < user_id.length; j++){
                userIdx.put(user_id[j], j);
                
                if(banned_id[i].length() != user_id[j].length()) continue;
                
                boolean isCorrect = true;
                for(int k = 0; k < banned_id[i].length(); k++){
                    if(banned_id[i].charAt(k) != user_id[j].charAt(k) && banned_id[i].charAt(k) != '*'){
                            isCorrect = false;
                            break;
                    }
                }
                
                //  불량 사용자에 해당하는 아이디 리스트
                if(isCorrect){
                    idList[i].add(user_id[j]);
                }
                
            }

        }

        comb(0, 0);
        
        return result.size();
    }
}
