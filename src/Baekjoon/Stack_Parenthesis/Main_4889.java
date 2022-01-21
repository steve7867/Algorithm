/**
 * 안정적인 문자열
 * https://www.acmicpc.net/problem/4889
 */
package Baekjoon.Stack_Parenthesis;

import java.io.*;
import java.util.*;
 
public class Main_4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int idx = 1;
        
        while (true) {
            Deque<Character> stk = new ArrayDeque<>();
            String input = br.readLine();
            if (input.contains("-"))
                break;
            
            for (char c : input.toCharArray()) {
                if (c == '{') stk.add(c);
                else if (c == '}') {
                    if (stk.isEmpty() || stk.peekLast() != '{')
                        stk.add(c);
                    else 
                        stk.pollLast();
                }
            }
            
            int cnt = 0;
            while (!stk.isEmpty()) {
                if (stk.pollLast() == stk.pollLast()) cnt++;
                else cnt += 2;
            }
            
            bw.write((idx++) + ". " + cnt + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
