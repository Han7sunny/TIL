import java.util.Map;
import java.util.HashMap;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];
		Map<String,String> parent = new HashMap<>(); // 자식 : 부모
		Map<String, Integer> income = new HashMap<>(); // 이름 : 값
		income.put("root", 0);
		for(int i = 0; i < enroll.length; i++){
			income.put(enroll[i], 0);
      if(referral[i].equals("-")) // 부모 == 루트
        parent.put(enroll[i], "root");
      else
        parent.put(enroll[i], referral[i]);
    }
		
		for(int i = 0; i < seller.length; i++) {
			String now = seller[i];
			String p = parent.get(now);
			int parentIncome = amount[i] * 10;	// amount[i] * 100 * 0.1
			int nowIncome = amount[i] * 100 - parentIncome;
			
			while(true) { // !now.equals("root")
				income.put(now, income.get(now) + nowIncome);
				if(parentIncome < 10 || p.equals("root")) {
					income.put(p, income.get(p) + parentIncome);	
					break;
				}
				now = p;
				p = parent.get(now);
				nowIncome = parentIncome - (int)(parentIncome * 0.1);
				parentIncome = (int)(parentIncome * 0.1);
			}
		}
		
		for(int i = 0; i < answer.length; i++)
			answer[i] = income.get(enroll[i]);
		return answer;
    }
}
