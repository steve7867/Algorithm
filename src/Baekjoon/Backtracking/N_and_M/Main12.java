/**
 * N과 M (12)
 * https://www.acmicpc.net/problem/15666
 */
package Baekjoon.Backtracking.N_and_M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main12 {
    static int n, m;
    static int[] arr;
    static boolean[] occur;
    static int max = 1;
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        occur = new boolean[10001];
        arr = new int[m];
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int n = Integer.parseInt(st.nextToken());
            occur[n] = true;
 
            max = Math.max(max, n);
        }
 
        backtrack(0, 1);
        System.out.println(sb);
    }
 
    private static void backtrack(int idx, int start) {
        if (idx == m) {
            for (int i = 0; i < arr.length; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
 
        for (int i = start; i <= max; i++) {
            if (!occur[i])
                continue;
            arr[idx] = i;
            backtrack(idx + 1, i);
        }
    }
 
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int n, m;
//    static int[] arr;
//    static boolean[] occur;
//    static int max = 1;
//    static StringBuilder sb = new StringBuilder();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        occur = new boolean[10001];
//        arr = new int[m];
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            int n = Integer.parseInt(st.nextToken());
//            occur[n] = true;
//
//            max = Math.max(max, n);
//        }
//
//        backtrack(1, 0);
//        System.out.println(sb);
//    }
//
//    private static void backtrack(int num, int idx) {
//        if (idx == m) {
//            for (int j = 0; j < arr.length; j++)
//                sb.append(arr[j]).append(" ");
//            sb.append("\n");
//            return;
//        }
//
//        if (num == max + 1)
//            return;
//
//        if (occur[num]) {
//            arr[idx] = num;
//            backtrack(num, idx + 1);
//        }
//
//        backtrack(num + 1, idx);
//    }
//}