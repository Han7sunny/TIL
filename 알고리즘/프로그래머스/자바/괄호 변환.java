import java.util.*;

class Solution {
    
    public boolean checkString(String u){
        
        Stack<Character> s = new Stack<>();
        
        for(int i = 0; i < u.length(); i++){
            if(u.charAt(i) == '(')
                s.push('(');
            else {
                if(s.isEmpty())
                    return false;
                else
                    s.pop();
            }
        }
        
        return true;
    }
    
    public String seperate(String p){
        
        //  1
        if(p.isEmpty())
            return p;
        
        //  2
        String u = "";
        String v = "";
        
        int count = 0;
        
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(')
                count++;
            else 
                count--;
            
            u += p.charAt(i);
            
            if(count == 0){
                v = p.substring(i + 1);
                break;
            }
        }
        
        //  3
        if(checkString(u)){
            
            //  3-1
            return u += seperate(v);
        }
        //  4
        else {
            
            //  4-1
            String s = "(";
            
            //  4-2
            s += seperate(v);
            
            //  4-3
            s += ")";
            
            //  4-4
            u = u.substring(1, u.length() - 1);
            for(int i = 0; i < u.length(); i++){
                if(u.charAt(i) == '(')
                    s += ")";
                else
                    s += "(";
            }
            
            //  4-5
            return s;
            
        }
        
    }
    
    public String solution(String p) {
        if(checkString(p))
            return p;
        return seperate(p);
        
    }
   
}
