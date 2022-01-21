/**
 * 쇠막대기
 * https://www.acmicpc.net/problem/10799
 * 문제 해설: https://entrydeveloper.tistory.com/211
 */
package Baekjoon.Stack_Parenthesis;

import java.io.*;
import java.util.*;
 
public class Main_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
 
        int sum = 0, barCnt = 0;
        boolean isRazor = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (s.charAt(i + 1) == '(')
                    barCnt++;
                else
                    isRazor = true;
            } else {
                if (isRazor) {
                    sum += barCnt;
                    isRazor = false;
                } else {
                    sum++;
                    barCnt--;
                }
            }
        }
 
        System.out.println(sum);
    }
}