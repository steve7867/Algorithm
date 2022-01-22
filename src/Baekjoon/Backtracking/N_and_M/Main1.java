/**
 * N과 M (1)
 * https://www.acmicpc.net/problem/15649
 */
package Baekjoon.Backtracking.N_and_M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main1 {
 
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static boolean[] isUsed;
    private static int[] arr;
 
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isUsed = new boolean[N + 1];
        arr = new int[M];
        
        func(0);
//        func2("");
        
        System.out.println(sb);
    }
 
    // k번째 자리에 수를 채우고, 다 찼을 경우 출력하는 함수.
    private static void func(int k) {
        if (k == M) {
            for (int i : arr)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(k + 1);
                isUsed[i] = false;
            }
        }
    }
    
    private static void func2(String s) {
        if (s.length() == M) {
            for (char c : s.toCharArray())
                sb.append(c).append(" ");
            sb.append("\n");
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                func2(s + i);
                isUsed[i] = false;
            }
        }
    }
}
