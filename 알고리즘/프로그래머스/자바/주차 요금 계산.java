import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map.Entry;
class Solution {
    public int time_cal(String time) { // 분(minute) 계산
		String[] t = time.split(":");
		return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
	}
    public int[] solution(int[] fees, String[] records) {
        HashMap<String,Integer> list = new HashMap<>();
        TreeMap<String,Integer> total_time = new TreeMap<>();

        for(int i = 0; i < records.length; i++) { 

          String[] record = records[i].split(" ");
          // record[0] : 시간
          // record[1] : 차번호
          // record[2] : IN / OUT

          // 들어온 차 목록
          if (!list.containsKey(record[1]))
            list.put(record[1], time_cal(record[0])); // IN
          else // OUT
          {
            total_time.put(record[1], total_time.getOrDefault(record[1], 0) +  time_cal(record[0]) - list.get(record[1]));
            list.remove(record[1]);
          }

        }

        // 23:59 처리
        for(Entry<String,Integer> last : list.entrySet()) {
          total_time.put(last.getKey(), total_time.getOrDefault(last.getKey(), 0) + time_cal("23:59") - last.getValue());
        }

        int[] answer = new int[total_time.size()];
        int idx = 0;
        for(Entry<String,Integer> e : total_time.entrySet()) {
          int p = fees[1];
          if(e.getValue() > fees[0])
            p+= (int)Math.ceil((double)(e.getValue()-fees[0])/fees[2]) * fees[3];
          answer[idx++] = p;
        }
            return answer;
    }
}
