/**
 * 플로이드
 * https://www.acmicpc.net/problem/11404
 */
package Baekjoon.Floyd_Warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_11404 {
    static final int NONE = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] d = new int[n + 1][n + 1];
 
        for (int i = 1; i <= n; i++) {
            Arrays.fill(d[i], NONE);
            d[i][i] = 0;
        }
 
        for (int k = 0; k < m; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            d[i][j] = Math.min(d[i][j], cost);
        }
 
        for (int target = 1; target <= n; target++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++)
                    d[i][j] = Math.min(d[i][j],  d[i][target] + d[target][j]);
            }
        }
 
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                sb.append(d[i][j] == NONE ? 0 : d[i][j]).append(" ");
            sb.append("\n");
        }
 
        System.out.println(sb);
    }
}
