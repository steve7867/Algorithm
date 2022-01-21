/**
 * GCD 합
 * https://www.acmicpc.net/problem/9613
 */
package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
 
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
 
            sb.append(getGCDSum(arr)).append('\n');
        }
 
        System.out.println(sb);
    }
 
    private static long getGCDSum(int[] arr) {
        long sum = 0;
        int n = arr.length;
 
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                sum += getGCD(arr[i], arr[j]);
 
        return sum;
    }
 
    private static int getGCD(int a, int b) {
        if (b == 0)
            return a;
 
        return getGCD(b, a % b);
    }
 
}
