/**
 * 옥상 정원 꾸미기
 * https://www.acmicpc.net/problem/6198
 * 문제 해설: https://entrydeveloper.tistory.com/202
 */
package Baekjoon.Stack;

import java.io.*;
import java.util.*;

public class Main_6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long cnt = 0;
        Stack<Long> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            Long input = Long.parseLong(br.readLine());

            while (!stack.isEmpty() && stack.peek() <= input)
                stack.pop();

            cnt += stack.size(); //input의 옥상을 볼 수 있는 건물의 수
            stack.push(input);
        }

        System.out.println(cnt);
    }
}