/**
 * 돌 게임
 * https://www.acmicpc.net/problem/9655
 *
 * 문제 해설: https://entrydeveloper.tistory.com/502?category=1150482
 */
package Baekjoon.DP._9655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static String[][] dp;
    static String[] names = {"SK", "CY"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new String[n + 1][2];

        System.out.println(getWinner(n, 0));
    }

    private static String getWinner(int r, int turn) {
        if (r == 0)
            return names[1 - turn];

        if (dp[r][turn] != null)
            return dp[r][turn];

        String name = names[turn];

        for (int i = 1; i <= 3; i += 2) {
            if (r < i)
                continue;

            String result = getWinner(r - i, 1 - turn);
            if (result.equals(name)) {
                return dp[r][turn] = name;
            }
        }

        return dp[r][turn] = names[1 - turn];
    }
}