/**
 * 균형잡힌 세상
 * https://www.acmicpc.net/problem/4949
 */
package Baekjoon.Stack_Parenthesis;

import java.io.*;
import java.util.*;

public class Main_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while (true) {
            String input = br.readLine();
            
            if (input.equals("."))
                break;
            
            bw.write(isBalanced(input));
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

//배열을 활용한 풀이
//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        while (true) {
//            String input = br.readLine();
//
//            if (input.equals("."))
//                break;
//
//            bw.write(isBalanced(input));
//        }
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    public static String isBalanced(String s) {
//        char[] stk = new char[101];
//        int top = 0;
//        for (char c : s.toCharArray()) {
//            switch (c) {
//                case '(':
//                case '[':
//                    stk[top++] = c;
//                    break;
//                case ')':
//                    if (top == 0 || stk[(top--) - 1] != '(')
//                        return "no\n";
//                    break;
//                case ']':
//                    if (top == 0 || stk[(top--) - 1] != '[')
//                        return "no\n";
//                    break;
//            }
//        }
//
//        return top == 0 ? "yes\n" : "no\n";
//    }
//}