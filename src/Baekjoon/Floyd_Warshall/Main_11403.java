/**
 * 경로 찾기
 * https://www.acmicpc.net/problem/11403
 */
package Baekjoon.Floyd_Warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_11403 {
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[n + 1][n + 1];
        int[][] next = new int[n + 1][n + 1];
 
        for (int i = 1; i <= n; i++) {
            Arrays.fill(next[i], -1);
        }
 
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1)
                    d[i][j] = num;
                else
                    d[i][j] = INF;
 
                if (d[i][j] == 1)
                    next[i][j] = j;
            }
        }
 
        for (int target = 1; target <= n; target++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (d[i][j] > d[i][target] + d[target][j]) {
                        d[i][j] = d[i][target] + d[target][j];
                        next[i][j] = next[i][target];
                    }
                }
            }
        }
 
 
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (next[i][j] == -1)
                    sb.append(0).append(" ");
                else
                    sb.append(1).append(" ");
            }
            sb.append("\n");
        }
 
        System.out.println(sb);
    }
}