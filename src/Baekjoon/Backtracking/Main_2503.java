/**
 * 숫자 야구
 * https://www.acmicpc.net/problem/2503
 */
package Baekjoon.Backtracking;

import java.io.*;
import java.util.*;
 
public class Main_2503 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int n;
    private static List<Answer> list = new LinkedList<Answer>();
    private static List<Integer> list2 = new LinkedList<Integer>();
    private static boolean[] isUsed = new boolean[10];
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            Answer answer = new Answer(query, strike, ball);
            list.add(answer);
        }
        
        func(0, "");
        
        int ans = list2.size();
        System.out.println(ans);
    }
    
    private static void func(int k, String s) {
        if (k == 3) {
            int num = Integer.parseInt(s);
            if (isPossible(num)) list2.add(num);
            return;
        }
        
        for (int i = 1; i <= 9; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                func(k + 1, s + i);
                isUsed[i] = false;
            }
        }
    }
 
    private static boolean isPossible(int num) {
        for (Answer answer : list)
            if(!match(num, answer)) return false;
        return true;
    }
    
    private static boolean match(int num, Answer answer) {
        int query = answer.query;
        int strike = answer.strike;
        int ball = answer.ball;
        
        int[] d1 = new int[3], d2 = new int[3];
        for (int i = 0; i < 3; i++) {
            d1[i] = num % 10;
            d2[i] = query % 10;
            num /= 10;
            query /= 10;
        }
        
        int s = 0, b = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (d1[i] == d2[j]) {
                    if (i == j) s++;
                    else b++;
                }
            }
        }
        
        return s == strike && b == ball;
    }
    
}
 
class Answer {
    int query;
    int strike;
    int ball;
    
    Answer(int query, int strike, int ball) {
        this.query = query;
        this.strike = strike;
        this.ball = ball;
    }
}
