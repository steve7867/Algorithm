/**
 * 외판원 순회
 * https://www.acmicpc.net/problem/2098
 */
package Baekjoon.Bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_2098 {
    static int n;
    static int[][] w;
    static int[][] dp = new int[16][1 << 16];
    static final int IMPOSSIBLE = 1000000000;
 
    static {
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
 
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                w[i][j] = Integer.parseInt(st.nextToken());
        }
 
        System.out.println(backtrack(0, 1));
    }
 
    private static int backtrack(int cur, int state) {
        if (dp[cur][state] != -1)
            return dp[cur][state];
 
        if (state == (1 << n) - 1) {
            if (w[cur][0] != 0)
                return w[cur][0];
            else
                return IMPOSSIBLE;
        }
 
        dp[cur][state] = IMPOSSIBLE;
        for (int i = 0; i < n; i++) {
            if (w[cur][i] == 0 || (state & (1 << i)) != 0)
                continue;
 
            int temp = backtrack(i, state | (1 << i)) + w[cur][i];
 
            if (dp[cur][state] > temp)
                dp[cur][state] = temp;
        }
 
        return dp[cur][state];
    }
}
