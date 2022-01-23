/**
 * 색상환
 * https://www.acmicpc.net/problem/2482
 * 문제 해설: https://entrydeveloper.tistory.com/556
 */
package Baekjoon.DP._2482;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final int mod = 1_000_000_003;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        dp = new int[n + 1][k + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        if (k == 1) {
            System.out.println(n);
            return;
        }

        if (k > n / 2) {
            System.out.println(0);
            return;
        }

        System.out.println((getNum(n - 3, k - 1) + getNum(n - 1, k)) % mod);
    }

    public static int getNum(int n, int k) {
        if (k == 1)
            return n;

        if (n < k)
            return 0;

        if (dp[n][k] >= 0)
            return dp[n][k];

        int res = 0;
        res += getNum(n - 2, k - 1) % mod;
        res += getNum(n - 1, k) % mod;
        res %= mod;

        return dp[n][k] = res;
    }
}