import java.util.HashMap;
import java.util.ArrayList;
public class Solution {
	public String[] solution(String[] record) {
        HashMap<String,String> user = new HashMap<>();
	    ArrayList<String> result = new ArrayList<>();
	
	    for(String r : record) {
		    String[] cmd = r.split(" "); // ""아닌 " "
            switch(cmd[0]) {
            case "Enter":
                user.put(cmd[1], cmd[2]); // 기존의 값 존재한다면 변경됨
                result.add(cmd[1] + "님이 들어왔습니다."); 
                break;
            case "Leave":
                result.add(cmd[1] + "님이 나갔습니다.");
                break;
            default: // "Change"
                user.replace(cmd[1], cmd[2]);
                break;
            }
	    }
        String[] answer = new String[result.size()];
        int i = 0;
        for(String r : result) {
            int idx = r.indexOf('님');
            String uid = r.substring(0,idx);
            answer[i++]=user.get(uid)+r.substring(idx);
        }
        return answer;
    }
}
