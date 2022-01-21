package Kakao.Blind_2020.괄호_변환;

import java.util.*;
 
class Others {
    public String solution(String p) {
        if (p.isEmpty()) return "";
        
        int flag = separate(p);
        String u = p.substring(0, flag);
        String v = p.substring(flag);
        
        if (isRight(u)) return u + solution(v);
        else {
            String temp = "(";
            temp += solution(v);
            temp += ")";
            u = u.substring(1, u.length() - 1);
            for (char c : u.toCharArray()) {
                if (c == '(') temp += ")";
                else temp += "(";
            }
            return temp;
        }
    }
    
    private static boolean isRight(String p) {
        Stack<Character> st = new Stack<Character>();
        
        for (char c : p.toCharArray()) {
            if (c == '(') st.push(c);
            else {
                if (!st.empty()) st.pop();
                else return false;
            }
        }
        
        if (!st.empty()) return false;
        return true;
    }
    
    private static int separate(String p) {
        int flag = 0;
        int open = 0, close = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') open++;
            else close++;
            
            if (open == close) {
                flag = i + 1;
                break;
            }
        }
        
        return flag;
    }
}
