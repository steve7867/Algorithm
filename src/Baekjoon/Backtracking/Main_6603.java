/**
 * 로또
 * https://www.acmicpc.net/problem/6603
 */
package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_6603 {
 
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb;
    private static int n;
    private static int[] num;
    private static int[] arr = new int[6];
    private static StringTokenizer st;
 
    public static void main(String[] args) throws IOException {
        while (true) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0)
                return;
            num = new int[n];
 
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
 
            func(0, 0);
            System.out.println(sb);
        }
    }
 
    private static void func(int k, int start) {
        if (k == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
 
        for (int i = start; i < n; i++) {
            arr[k] = num[i];
            func(k + 1, i + 1);
        }
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    private static StringBuilder sb;
//    private static int n;
//    private static int[] num;
//    private static StringTokenizer st;
//
//    public static void main(String[] args) throws IOException {
//        while (true) {
//            sb = new StringBuilder();
//            st = new StringTokenizer(br.readLine());
//            n = Integer.parseInt(st.nextToken());
//            if (n == 0) return;
//            num = new int[n];
//
//            for (int i = 0; i < n; i++) {
//                num[i] = Integer.parseInt(st.nextToken());
//            }
//
//            func(0, 0, "");
//            System.out.println(sb);
//        }
//    }
//
//    private static void func(int k, int start, String s) {
//        if (k == 6) {
//            sb.append(s).append("\n");
//            return;
//        }
//
//        for (int i = start; i < n; i++) {
//            func(k + 1, i + 1, s + num[i] + " ");
//        }
//    }
//}