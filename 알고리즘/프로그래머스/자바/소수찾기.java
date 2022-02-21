import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    HashMap<Integer,Integer> prime = new HashMap<>();
    boolean[] check;
    public boolean isPrime(int number){
        if (number == 0 || number == 1)
            return false;
        for(int i = 3; i <= (int)Math.sqrt(number); i += 2){
            if (number % i == 0)
                return false;
        }
        return true;
    }
    public void pick(String number, String pick_result, int length){
        // 2 = 소수
        if (pick_result.length() > 0 && !prime.containsKey(Integer.parseInt(pick_result))){
            int result_number = Integer.parseInt(pick_result);
            if (result_number == 2)
                prime.put(result_number,1);
            else if (result_number % 2 != 0){
                if (isPrime(result_number))
                    prime.put(result_number,1);
            }
        }
        else if (pick_result.length() == length)
            return;
        
        for (int i = 0; i < number.length(); i++){
            if(!check[i]){
                check[i] = true;
                pick_result += number.charAt(i);
                pick(number,pick_result,length);
                check[i] = false;
                pick_result = pick_result.substring(0,pick_result.length()-1);
            }
        }
    }
    public int solution(String numbers) {
        check = new boolean[numbers.length()];
        pick(numbers,"",numbers.length());
        return prime.size();
    }
}
