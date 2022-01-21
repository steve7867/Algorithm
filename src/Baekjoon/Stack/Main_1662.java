/**
 * 압축
 * https://www.acmicpc.net/problem/1662
 */
package Baekjoon.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
 
class Main_1662 {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Deque<Integer> len = new ArrayDeque<>(); // stack
        Deque<Integer> mul = new ArrayDeque<>(); // stack
 
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
 
            if (c == '(') {
                int mulNum = s.charAt(i - 1) - '0';
                mul.add(mulNum);
                cnt--;
                len.add(cnt);
                cnt = 0;
            } else if (c == ')') {
                int val = mul.pop();
                val *= cnt;
                int plus = len.pop();
                cnt = plus + val;
            } else
                cnt++;
        }
 
        System.out.print(cnt);
    }
}
