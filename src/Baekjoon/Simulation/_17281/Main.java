/**
 * ⚾
 * https://www.acmicpc.net/problem/17281
 */
package Baekjoon.Simulation._17281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static int n;
    static int[][] result;
    static int[] seq = new int[10];
    static boolean[] visited = new boolean[10];
    static int ans = 0;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = new int[n][10];
 
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        backtrack(1);
        System.out.println(ans);
    }
 
    private static void backtrack(int idx) {
        if (idx == 10) {
            int score = play();
            if (score > ans)
                ans = score;
            return;
        }
 
        if (idx == 4) {
            seq[idx] = 1;
            backtrack(idx + 1);
            return;
        }
 
        for (int i = 2; i <= 9; i++) {
            if (visited[i])
                continue;
 
            visited[i] = true;
            seq[idx] = i;
            backtrack(idx + 1);
            visited[i] = false;
        }
    }
 
    private static int play() {
        int score = 0;
        int cur = 1;
        int[] base = new int[4];
        int out = 0;
 
        for (int i = 0; i < n; i++) {
            out = 0;
            base[1] = base[2] = base[3] = 0;
 
            while (out < 3) {
                int player = seq[cur];
                cur++;
                if (cur >= 10)
                    cur = 1;
 
                int hit = result[i][player];
                if (hit == 1) {
                    score += base[3];
                    base[3] = base[2];
                    base[2] = base[1];
                    base[1] = 1;
                } else if (hit == 2) {
                    score += base[3] + base[2];
                    base[3] = base[1];
                    base[2] = 1;
                    base[1] = 0;
                } else if (hit == 3) {
                    score += base[3] + base[2] + base[1];
                    base[3] = 1;
                    base[1] = base[2] = 0;
                } else if (hit == 4) {
                    score += base[3] + base[2] + base[1] + 1;
                    base[1] = base[2] = base[3] = 0;
                } else
                    out++;
            }
        }
        return score;
    }
}