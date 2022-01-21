/**
 * 괄호
 * https://www.acmicpc.net/problem/9012
 */
package Baekjoon.Stack_Parenthesis;

import java.io.*;

public class Main_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String input = br.readLine();
            
            bw.write(isBalanced(input).toUpperCase());
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
 
    public static String isBalanced(String s) {
        char[] stk = new char[101];
        int top = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
            case '(':
            case '[':
                stk[top++] = c;
                break;
            case ')':
                if (top == 0 || stk[(top--) - 1] != '(')
                    return "no\n";
                break;
            case ']':
                if (top == 0 || stk[(top--) - 1] != '[')
                    return "no\n";
                break;
            }
        }
        
        return top == 0 ? "yes\n" : "no\n";
    }
}