/**
 * 선발 명단
 * https://www.acmicpc.net/problem/3980
 */
package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_3980 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        boolean[] isUsed = new boolean[11];
 
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int[][] score = new int[11][11];
            Arrays.fill(isUsed, false);
 
            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            sb.append(backtrack(0, 0, isUsed, score))
                    .append('\n');
        }
 
        System.out.println(sb);
    }
 
    private static int backtrack(int j, int sum, boolean[] isUsed, int[][] score) {
        if (j == 11)
            return sum;
 
        int max = 0;
        for (int i = 0; i < 11; i++) {
            if (isUsed[i] || score[i][j] == 0)
                continue;
 
            isUsed[i] = true;
            max = Math.max(max, backtrack(j + 1, sum + score[i][j], isUsed, score));
            isUsed[i] = false;
        }
 
        return max;
    }
}
