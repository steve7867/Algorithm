/**
 * N과 M (7)
 * https://www.acmicpc.net/problem/15656
 */
package Baekjoon.Backtracking.N_and_M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main7 {
    static int n, m;
    static int[] arr, num;
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        arr = new int[m];
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());
 
        Arrays.sort(num);
 
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
 
        for (int i = 0; i < num.length; i++) {
            arr[idx] = num[i];
            backtrack(idx + 1);
        }
    }
 
}
