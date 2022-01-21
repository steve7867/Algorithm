/**
 * 단어 뒤집기2
 * https://www.acmicpc.net/problem/17413
 */
package Baekjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main_17413 {
    private static Deque<Character> stack = new ArrayDeque<>();
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String s = br.readLine();
        boolean tag = false;
        for (char c : s.toCharArray()) {
            if (c == '<') {
                addStackToSB();
                sb.append(c);
                tag = true;
            } else if (c == '>') {
                sb.append(c);
                tag = false;
            } else if (tag) {
                sb.append(c);
            } else {
                if (c == ' ') {
                    addStackToSB();
                    sb.append(c);
                }
                else {
                    stack.push(c);
                }
            }
        }
 
        addStackToSB();
 
        System.out.println(sb);
    }
 
    private static void addStackToSB() {
        while (!stack.isEmpty())
            sb.append(stack.pop());
    }
 
}
