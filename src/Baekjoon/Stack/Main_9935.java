/**
 * 문자열 폭발
 * https://www.acmicpc.net/problem/9935
 * 문제 해설: https://entrydeveloper.tistory.com/289
 */
package Baekjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9935 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String origin;
    private static String remove;
    private static final char[] st = new char[1000001];
    private static int top = 0;

    public static void main(String[] args) throws IOException {

        origin = br.readLine();
        remove = br.readLine();

        for (char c : origin.toCharArray()) {
            st[++top] = c;

            if (top >= remove.length()) {
                if (isSame()) {
                    for (int j = 0; j < remove.length(); j++)
                        top--;
                }
            }
        }
        
        if (top == 0)
            System.out.println("FRULA");
        else {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= top; i++)
            sb.append(st[i]);
            System.out.println(sb);
        }

    }

    private static boolean isSame() {
        for (int j = 0; j < remove.length(); j++) {
            if (st[top - remove.length() + j + 1] != remove.charAt(j))
                return false;
        }
        
        return true;
    }
}