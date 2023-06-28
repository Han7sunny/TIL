import java.util.*;
class Solution {
    
    static Map<String, Integer> term;
    
    public int[] dateToArray(String date){
        int[] array = new int[3];
        StringTokenizer st = new StringTokenizer(date, ".");
        
        //  year
        array[0] = Integer.parseInt(st.nextToken());   
        
        //  month
        String month = st.nextToken();
        if(month.charAt(0) == '0')
            array[1] = month.charAt(1) - '0' ; 
        else
            array[1] = Integer.parseInt(month);    
        
        //  day
        String day = st.nextToken();
        if(day.charAt(0) == '0')
            array[2] = day.charAt(1) - '0';
        else
            array[2] = Integer.parseInt(day);
        
        return array;        
    }
    
    public int periodCalculate(String date, String type){
        
        int[] dateArray = dateToArray(date);
        
        dateArray[2]--;
        if(dateArray[2] == 0){
            dateArray[2] = 28;
            dateArray[1]--;
        }
        
        dateArray[1] += term.get(type);
        if(dateArray[1] > 12){
            dateArray[0] += dateArray[1] / 12;
            dateArray[1] %= 12;
        }
        
        return dateArray[0] * 12 * 28 + dateArray[1] * 28 + dateArray[2];
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        
        //  모든 달 28일까지 -> 문제 해결 핵심
        //  유효기간 오늘 날짜 미만이면 파기
        
        int[] answer = {};        
        List<Integer> expire = new ArrayList<>();
        int[] todayArray = dateToArray(today);
        int todayCal = todayArray[0] * 12 * 28 + todayArray[1] * 28 + todayArray[2];
        
        term = new HashMap<>();
        
        StringTokenizer st;
        for(int i = 0; i < terms.length; i++){
            st = new StringTokenizer(terms[i]);
            term.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        for(int num = 0; num < privacies.length; num++){
            st = new StringTokenizer(privacies[num]);
            String date = st.nextToken();
            if(today == date)
                continue;
        
            int dateCal = periodCalculate(date, st.nextToken());
            if(todayCal > dateCal)
                expire.add(num + 1);
            
        }
        
        Collections.sort(expire);
        answer = new int[expire.size()];
        for(int i = 0; i < expire.size(); i++)
            answer[i] = expire.get(i);
        
        //  파기해야 할 개인정보 번호 (오름차순)
        return answer;
    }
}
