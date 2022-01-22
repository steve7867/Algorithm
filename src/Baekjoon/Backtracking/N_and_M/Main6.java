/**
 * N과 M (6)
 * https://www.acmicpc.net/problem/15655
 */
package Baekjoon.Backtracking.N_and_M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main6 {
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
 
        backtrack(0, 0);
        System.out.println(sb);
    }
 
    private static void backtrack(int idx, int start) {
        if (idx == m) {
            for (int i = 0; i < arr.length; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
 
        for (int i = start; i < num.length; i++) {
            arr[idx] = num[i];
            backtrack(idx + 1, i + 1);
        }
    }
 
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int n, m;
//    static int[] arr, num;
//    static StringBuilder sb = new StringBuilder();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        num = new int[n];
//        arr = new int[m];
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++)
//            num[i] = Integer.parseInt(st.nextToken());
//
//        Arrays.sort(num);
//
//        backtrack(0, 0);
//        System.out.println(sb);
//    }
//
//    private static void backtrack(int i, int idx) {
//        if (idx == m) {
//            for (int j = 0; j < arr.length; j++)
//                sb.append(arr[j]).append(" ");
//            sb.append("\n");
//            return;
//        }
//
//        if (i == n)
//            return;
//
//        arr[idx] = num[i];
//        backtrack(i + 1, idx + 1);
//
//        backtrack(i + 1, idx);
//    }
//}