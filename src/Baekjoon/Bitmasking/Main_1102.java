/**
 * 발전소
 * https://www.acmicpc.net/problem/1102
 */
package Baekjoon.Bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_1102 {
    private static int n;
    private static int[][] cost;
    private static int p;
    private static int state;
    private static int[] dp = new int[1 << 16];
 
    static {
        Arrays.fill(dp, -1);
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];
 
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        String s = br.readLine();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
 
            if (c == 'Y') {
              state = state | (1 << i);
              cnt++;
            }
        }
 
        p = Integer.parseInt(br.readLine());
 
        if (cnt >= p) {
            System.out.println(0);
            return;
        }
 
        if (cnt == 0 && p > 0) {
            System.out.println(-1);
            return;
        }
 
        System.out.println(getMinCost(p - cnt, 0, state));
    }
 
    private static int getMinCost(int target, int fix, int state) {
        if (fix == target)
            return 0;
 
        if (dp[state] > -1)
            return dp[state];
 
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // 고장 안 난 건 패스
            if ((state & (1 << i)) == (1 << i))
                continue;
 
            for (int j = 0; j < n; j++) {
                // 같은 발전소거나, 고장난 발전소면 패스
                if (i == j || (state & (1 << j)) == 0)
                    continue;
 
                int temp = cost[j][i] + getMinCost(target, fix + 1, state | (1 << i));
                minCost = Math.min(minCost, temp);
            }
 
        }
 
        dp[state] = minCost;
 
        return minCost;
    }
}
