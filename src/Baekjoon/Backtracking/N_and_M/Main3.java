/**
 * N과 M (3)
 * https://www.acmicpc.net/problem/15651
 */
package Baekjoon.Backtracking.N_and_M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main3 {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
 
        backtrack(0);
        System.out.println(sb);
    }
 
    private static void backtrack(int idx) {
        if (idx == m) {
            for (int i = 0; i < arr.length; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
 
        for (int i = 1; i <= n; i++) {
            arr[idx] = i;
            backtrack(idx + 1);
        }
    }
 
}