/**
 * 수 이어 쓰기 1
 * https://www.acmicpc.net/problem/1748
 */
package Baekjoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main_1748 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
 
        int ans = 0;
        for (int start = 1, len = 1; start <= n; start *= 10, len++) {
            int end = start * 10 - 1;
            if (end > n) {
                end = n;
            }
            ans += (end - start + 1) * len;
        }
 
        System.out.println(ans);
    }
}