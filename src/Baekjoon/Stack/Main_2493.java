/**
 * 탑
 * https://www.acmicpc.net/problem/2493
 * 문제 해설: https://entrydeveloper.tistory.com/201
 */
package Baekjoon.Stack;

import java.io.*;
import java.util.*;

public class Main_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Tower> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().height < cur)
                stack.pop();
            
            if (stack.isEmpty())
                sb.append("0 ");
            else 
                sb.append(stack.peek().order + " ");
            
            stack.push(new Tower(cur, i));
        }
        System.out.println(sb.toString());
        br.close();
    }
}

class Tower {
    int height;
    int order;

    public Tower(int height, int order) {
        this.height = height;
        this.order = order;
    }
}