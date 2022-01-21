/**
 * 먹을 것인가 먹힐 것인가
 * https://www.acmicpc.net/problem/7795
 */
package Baekjoon.Sort2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_7795 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static int tc;
    private static int[] A, B;
    
    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int aLen = Integer.parseInt(st.nextToken());
            int bLen = Integer.parseInt(st.nextToken());
            
            A = new int[aLen];
            B = new int[bLen];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < aLen; i++)
                A[i] = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < bLen; i++)
                B[i] = Integer.parseInt(st.nextToken());
            
            Arrays.sort(A);
            Arrays.sort(B);
            
            int cnt = 0;
            int bIdx = 0;
            for (int a : A) {
                while (bIdx < bLen && B[bIdx] < a) bIdx++;
                cnt += bIdx;
            }
            
            sb.append(cnt).append("\n");
        }
        
        System.out.println(sb);
    }
    
}