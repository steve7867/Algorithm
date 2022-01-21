/**
 * 스택 수열
 * https://www.acmicpc.net/problem/1874
 */
package Baekjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
 
        // 스택을 선언하고 0을 push
        int top = -1;
        int[] stack = new int[n + 1];
        stack[++top] = 0;
        StringBuilder sb = new StringBuilder();
        int next = 1; //스택에 push할 수
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            // 스택의 top에 있는 수가 target보다 작으면 같아질 때까지 push
            while (target > stack[top]) {
                stack[++top] = next++;
                sb.append('+').append('\n');
            }
 
            // 스택의 top에 있는 수가 target과 같으면 pop
            if (target == stack[top]) {
                top--;
                sb.append('-').append('\n');
                continue;
            }
 
            // 스택의 top에 있는 수가 target보다 크면 만들 수 없는 수열
            if (target < stack[top]) {
                System.out.println("NO");
                return;
            }
        }
 
        System.out.println(sb);
    }
}
