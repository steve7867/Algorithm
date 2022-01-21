/**
 * 배열 합치기
 * https://www.acmicpc.net/problem/11728
 */
package Baekjoon.Sort1.MergeSort;

import java.io.*;
import java.util.StringTokenizer;
 
public class Main_11728 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int N, M;
    private static int[] a, b, c;
            
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N];
        b = new int[M];
        c = new int[N + M];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            a[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            b[i] = Integer.parseInt(st.nextToken());
        
        int aIdx = 0, bIdx = 0;
        for (int i = 0; i < N + M; i++) {
            if (aIdx == N) c[i] = b[bIdx++];
            else if (bIdx == M) c[i] = a[aIdx++];
            else if (a[aIdx] <= b[bIdx]) c[i] = a[aIdx++];
            else c[i] = b[bIdx++];
        }
        
        for (int i = 0; i < c.length; i++)
            sb.append(c[i]).append(" ");
        
        System.out.println(sb);
    }   
    
}