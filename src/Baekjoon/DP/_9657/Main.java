/**
 * 돌 게임 3
 * https://www.acmicpc.net/problem/9657
 */
package Baekjoon.DP._9657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main {
    private static int[][] dp;
    private static final int[] stones = {1, 3, 4};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][2];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i] , -1);
 
        System.out.println(getWinner(n, 1) == 1 ? "SK" : "CY");
    }
 
    /**
     *
     * @param r 남은 돌의 개수
     * @param p 현재 플레이어(1:상근, 0:창영)
     * @return r개의 돌이 남아있고 플레이어가 p일 때 누가 이길지(1:상근, 0:창영)
     */
    private static int getWinner(int r, int p) {
        if (r == 1 || r == 3 || r == 4)
            return p;
 
        if (dp[r][p] >= 0)
            return dp[r][p];
 
        for (int stone : stones) {
            if (r < stone)
                break;
 
            int winner = getWinner(r - stone, 1 - p);
            if (winner == p) {
                return dp[r][p] = p;
            }
        }
 
        return dp[r][p] = 1 - p;
    }
}
