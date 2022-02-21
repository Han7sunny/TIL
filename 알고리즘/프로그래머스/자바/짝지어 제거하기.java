import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> alpList = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(!alpList.isEmpty()){
                if(alpList.peek() == s.charAt(i))
                    alpList.pop();
                else
                    alpList.push(s.charAt(i));
            }
            else
                alpList.push(s.charAt(i));
        }
        return (alpList.isEmpty()) ? 1 : 0;
    }
}
