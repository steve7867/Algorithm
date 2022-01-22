/**
 * N과 M (2)
 * https://www.acmicpc.net/problem/15650
 */
package Baekjoon.Backtracking.N_and_M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main2 {
    static int n, m;
    static int[] arr;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
 
        backtrack(0, 1);
    }
 
    private static void backtrack(int idx, int start) {
        if (idx == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++)
                sb.append(arr[i]).append(" ");
 
            System.out.println(sb);
            return;
        }
 
        for (int i = start; i <= n; i++) {
            arr[idx] = i;
            backtrack(idx + 1, i + 1);
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
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        arr = new int[m];
//
//        backtrack(1, 0);
//    }
//
//    private static void backtrack(int num, int idx) {
//        if (idx == m) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < arr.length; i++)
//                sb.append(arr[i]).append(" ");
//
//            System.out.println(sb);
//            return;
//        }
//
//        if (num == n + 1)
//            return;
//
//        arr[idx] = num;
//        backtrack(num + 1, idx + 1);
//
//        backtrack(num + 1, idx);
//    }
//}