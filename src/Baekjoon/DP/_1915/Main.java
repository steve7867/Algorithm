/**
 * 가장 큰 정사각형
 * https://www.acmicpc.net/problem/1915
 *
 * 문제 해설: https://entrydeveloper.tistory.com/490
 */
package Baekjoon.DP._1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                board[i][j] = input.charAt(j - 1) - '0';
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] == 0)
                    dp[i][j] = 0;
                else {
                    if (board[i][j - 1] == 1 && board[i - 1][j - 1] == 1 && board[i - 1][j] == 1) {
                        dp[i][j] = getMin(dp, i, j) + 1;
                    } else
                        dp[i][j] = 1;
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max * max);
    }

    private static int getMin(int[][] dp, int i, int j) {
        return Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
    }
}