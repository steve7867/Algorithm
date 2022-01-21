/**
 * 오아시스 재결합
 * https://www.acmicpc.net/problem/3015
 * 문제 해설: https://entrydeveloper.tistory.com/447?category=1255793
 */
package Baekjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
 
public class Main_3015 {
    static class People {
        int height;
        int count;
 
        People(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }
 
    private static int n;
    private static long ans;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
 
        Deque<People> stack = new ArrayDeque<>();
        while (n-- > 0) {
            int cur = Integer.parseInt(br.readLine());
 
            while (!stack.isEmpty() && stack.peek().height < cur)
                ans += stack.pop().count;
 
            int temp = 0;
            if (!stack.isEmpty() && stack.peek().height == cur)
                temp = stack.pop().count;
            ans += temp;
 
            if (!stack.isEmpty())
                ans++;
 
            stack.push(new People(cur, temp + 1));
        }
 
        System.out.println(ans);
    }
}