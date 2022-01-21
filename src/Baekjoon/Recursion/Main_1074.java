/**
 * Z
 * https://www.acmicpc.net/problem/1074
 */
package Baekjoon.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        System.out.println(func(n, r, c));
    }
    // (2^n)*(2^n) 배열에서 r, c를 방문하는 순서를 반환하는 함수
    private static int func(int n, int r, int c) {
        if (n == 0) return 0;
        int half = 1 << (n - 1);
        if (r < half && c < half) return func(n - 1, r, c);
        if (r < half && c >= half) return half * half + func(n - 1, r, c - half);
        if (r >= half && c < half) return 2 * half * half + func(n - 1, r - half, c);
        return 3 * half * half + func(n - 1, r - half, c - half); 
    }
}