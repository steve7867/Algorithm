/**
 * 괄호의 값
 * https://www.acmicpc.net/problem/2504
 */
package Baekjoon.Stack_Parenthesis;

import java.io.*;
import java.util.*;
 
public class Main_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean Impossible = false;
        int result = 0;
        
        Deque<Character> stk = new ArrayDeque<>();
        int temp = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                temp *= 2;
                stk.offer(c);
            } else if (c == '[') {
                temp *= 3;
                stk.offer(c);
            } else if (c == ')') {
                if (stk.isEmpty() || stk.pollLast() != '(') {
                    Impossible = true;
                    break;
                }
                
                if (s.charAt(i - 1) == '(')
                    result += temp;
                
                temp /= 2;
            } else if (c == ']') {
                if (stk.isEmpty() || stk.pollLast() != '[') {
                    Impossible = true;
                    break;
                }
                
                if (s.charAt(i - 1) == '[')
                    result += temp;
                
                temp /= 3;
            }
        }
        
        System.out.println(Impossible || !stk.isEmpty() ? 0 : result);
        
    }
}
