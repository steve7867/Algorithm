/**
 * 플로이드 2
 * https://www.acmicpc.net/problem/11780
 */
package Baekjoon.Floyd_Warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_11780 {
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] d = new int[n + 1][n + 1];
        int[][] next = new int[n + 1][n + 1];
 
        for (int i = 1; i <= n; i++) {
            Arrays.fill(d[i], INF);
            d[i][i] = 0;
            Arrays.fill(next[i], -1);
        }
 
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            d[i][j] = Math.min(d[i][j], cost);
            next[i][j] = j;
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
 
        // print minimum cost
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                sb.append(d[i][j] == INF ? 0 : d[i][j]).append(" ");
            sb.append("\n");
        }
 
        // print minimum path
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (next[i][j] == -1)
                    sb.append(0).append("\n");
                else {
                    StringBuilder temp = new StringBuilder();
                    int cur = i;
                    int cnt = 0;
                    while (cur != j) {
                        cnt++; // 도시 추가할 때마다 cnt++
                        temp.append(cur).append(" ");
                        cur = next[cur][j];
                    }
                    cnt++;
                    temp.append(cur).append("\n");
 
                    sb.append(cnt).append(" ").append(temp);
                }
            }
        }
 
        System.out.println(sb);
    }
}
