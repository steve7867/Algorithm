/**
 * 나머지 합
 * https://www.acmicpc.net/problem/10986
 */
package Baekjoon.Prefix_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_10986 {
    private static int n, m;
    private static int[] arr;
    private static long[] pSum;
    private static int[] remainder;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
 
        arr = new int[n];
        pSum = new long[n];
        remainder = new int[m];
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
 
        pSum[0] = arr[0];
        for (int i = 1; i < n; i++)
            pSum[i] = pSum[i - 1] + arr[i];
 
        for (int i = 0; i < n; i++) {
            int r = (int) (pSum[i] % m);
            remainder[r]++;
        }
 
        long ans = remainder[0];
        ans += summation(remainder[0]);
 
        for (int i = 1; i < m; i++)
            ans += summation(remainder[i]);
 
        System.out.println(ans);
    }
 
    private static long summation(int n) {
        return (long) n * (n - 1) / 2;
    }
}
