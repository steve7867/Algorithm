/**
 * 합승 택시 요금
 * https://programmers.co.kr/learn/courses/30/lessons/72413
 */
package Kakao.Blind_2021.합승_택시_요금;

import java.util.Arrays;
 
class Solution {
    private static final int INF = 100000000;
 
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] d = new int[n + 1][n + 1];
 
        for (int i = 1; i <= n; i++) {
            Arrays.fill(d[i], INF);
            d[i][i] = 0;
        }
 
        for (int i = 0; i < fares.length; i++) {
            int[] fare = fares[i];
            d[fare[0]][fare[1]] = fare[2];
            d[fare[1]][fare[0]] = fare[2];
        }
 
        for (int target = 1; target <= n; target++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (d[i][j] > d[i][target] + d[target][j]) {
                        d[i][j] = d[i][target] + d[target][j];
                    }
                }
            }
        }
 
        //따로 가는 경우
        int ans = d[s][a] + d[s][b];
 
        //같이 가는 경우
        for (int target = 1; target <= n; target++) {
            if (ans > d[s][target] + d[target][a] + d[target][b])
                ans = d[s][target] + d[target][a] + d[target][b];
        }
 
        return ans;
    }
}
