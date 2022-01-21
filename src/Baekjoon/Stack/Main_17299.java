/**
 * 오등큰수
 * https://www.acmicpc.net/problem/17299
 */
package Baekjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
 
public class Main_17299 {
    private static int n;
    private static int[] a;
    private static int[] f = new int[10000001];
    private static int[] nge;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        nge = new int[n];
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            f[a[i]]++;
        }
 
        Deque<Integer> stack = new ArrayDeque<>();
 
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && f[a[stack.peek()]] < f[a[i]])
                nge[stack.pop()] = a[i];
            stack.push(i);
        }
 
        while (!stack.isEmpty())
            nge[stack.pop()] = -1;
 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(nge[i]).append(' ');
 
        System.out.println(sb);
    }
}
