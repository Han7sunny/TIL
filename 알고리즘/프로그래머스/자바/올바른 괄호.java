import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean answer = true;
        if(s.charAt(0) == '(')
            stack.push(s.charAt(0));
        else
            return false;
        
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push(s.charAt(0));
            else{
                if(stack.isEmpty())
                    return false;
                else
                    stack.pop();
            } 
        }
        
        if(!stack.isEmpty())
            answer = false;
        return answer;
    }
}
