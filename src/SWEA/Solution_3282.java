/**
 * 문제 해설: https://entrydeveloper.tistory.com/565
 */
package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_3282 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = stoi(br);

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = stoi(st);
            int k = stoi(st);

            int[][] dp = new int[n + 1][k + 1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int v = stoi(st);
                int c = stoi(st);

                for (int j = 1; j <= k; j++) {
                    if (v > j)
                        dp[i][j] = dp[i - 1][j];
                    else
                        dp[i][j] = Math.max(dp[i - 1][j - v] + c, dp[i - 1][j]);
                }
            }

            sb.append('#')
                    .append(tc)
                    .append(' ')
                    .append(dp[n][k])
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static int stoi(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static int stoi(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

}