/**
 * 문제 해설: https://entrydeveloper.tistory.com/375
 */
 package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution_1247 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int[] company;
    static int[] home;
    static int[][] cus;
    static int[][] dp;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());
            company = new int[2];
            home = new int[2];
            cus = new int[n][2];
            dp = new int[n][1 << n];

            for (int i = 0; i < n; i++)
                Arrays.fill(dp[i] , -1);

            StringTokenizer st = new StringTokenizer(br.readLine());
            company[0] = Integer.parseInt(st.nextToken());
            company[1] = Integer.parseInt(st.nextToken());
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                cus[i][0] = Integer.parseInt(st.nextToken());
                cus[i][1] = Integer.parseInt(st.nextToken());
            }


            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int totalDist = getDist(company[0], company[1], cus[i][0], cus[i][1])
                        + backtrack(i, 1 << i);

                if (ans > totalDist)
                    ans = totalDist;
            }

            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static int backtrack(int cur, int state) {
        if (dp[cur][state] != -1)
            return dp[cur][state];

        if (state == (1 << n) - 1)
            return getDist(cus[cur][0], cus[cur][1], home[0], home[1]);

        dp[cur][state] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if ((state & (1 << i)) != 0)
                continue;

            int dist = getDist(cus[cur][0], cus[cur][1], cus[i][0], cus[i][1])
                    + backtrack(i, state | (1 << i));

            if (dp[cur][state] > dist)
                dp[cur][state] = dist;
        }

        return dp[cur][state];
    }

    private static int getDist(int a, int b, int c, int d) {
        return Math.abs(a - c) + Math.abs(b - d);
    }

}