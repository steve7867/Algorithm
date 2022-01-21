/**
 * Line Friends (Small)
 * https://www.acmicpc.net/problem/14588
 */
package Baekjoon.Floyd_Warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_14588 {
    private static final int INF = 1000000000;
 
    static class Line {
        int x, y;
 
        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[n + 1][n + 1];
        Line[] lines = new Line[n + 1];
 
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lines[i] = new Line(x, y);
        }
 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    d[i][j] = 0;
                    continue;
                }
 
                if (isFriend(lines[i], lines[j]))
                    d[i][j] = 1;
                else
                    d[i][j] = INF;
            }
        }
 
        for (int target = 1; target <= n; target++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][target] + d[target][j]);
                }
            }
        }
 
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(d[i][j] == INF ? -1 : d[i][j]).append("\n");
        }
 
        System.out.println(sb);
    }
 
    private static boolean isFriend(Line l1, Line l2) {
        if (l1.y < l2.x || l1.x > l2.y)
            return false;
        return true;
    }
}