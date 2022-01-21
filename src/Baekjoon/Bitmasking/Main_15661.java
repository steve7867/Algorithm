/**
 * 링크와 스타트
 * https://www.acmicpc.net/problem/15661
 */
package Baekjoon.Bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_15661 {
    static int n;
    static int[][] board;
    static boolean[] isIncluded;
    static int ans = Integer.MAX_VALUE;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        isIncluded = new boolean[n];
 
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        for (int sc = 1; sc < (1 << n) - 1; sc++) {
            int team1 = 0, team2 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isIn(sc, i) && isIn(sc, j))
                        team1 += board[i][j];
                    else if (!isIn(sc, i) && !isIn(sc, j))
                        team2 += board[i][j];
                }
            }
 
            ans = Math.min(ans, Math.abs(team1 - team2));
        }
 
        System.out.println(ans);
    }
 
    private static boolean isIn(int sc, int n) {
        return (sc & (1 << n)) != 0;
    }
 
}