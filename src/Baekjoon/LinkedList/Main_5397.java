/**
 * 키로거
 * https://www.acmicpc.net/problem/5397
 * 문제 해설: https://entrydeveloper.tistory.com/196?category=1185243
 */
package Baekjoon.LinkedList;

import java.io.*;
import java.util.*;

public class Main_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            String input = br.readLine();
            for (char c : input.toCharArray()) {
                switch (c) {
                case '<':
                    if (!left.isEmpty())
                        right.push(left.pop());
                    break;
                case '>':
                    if (!right.isEmpty())
                        left.push(right.pop());
                    break;
                case '-':
                    if (!left.isEmpty())
                        left.pop();
                    break;
                default:
                    left.push(c);
                    break;
                }
            }

            while (!right.isEmpty())
                left.push(right.pop());
            
            for (char c : left)
                bw.write(c);
            
            bw.write("\n");
            bw.flush();
        }

        bw.close();
        br.close();
    }
}