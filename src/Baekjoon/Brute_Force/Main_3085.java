/**
 * 사탕 게임
 * https://www.acmicpc.net/problem/3085
 * 문제 해설: https://entrydeveloper.tistory.com/234
 */
package Baekjoon.Brute_Force;

import java.util.*;
import java.io.*;

public class Main_3085 {
    static int n;
    static char[][] board;
    static int ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            checkRow(i);
            checkCol(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 <= n - 1 && board[i][j] != board[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    checkRow(i);
                    checkCol(j);
                    checkCol(j + 1);
                    swap(i, j, i, j + 1);
                }

                if (i + 1 <= n - 1 && board[i][j] != board[i + 1][j]) {
                    swap(i, j, i + 1, j);
                    checkCol(j);
                    checkRow(i);
                    checkRow(i + 1);
                    swap(i, j, i + 1, j);
                }
            }
        }

        System.out.println(ans);
    }

    private static void checkRow(int r) {
        int cnt = 1;
        for (int j = 0; j < n - 1; j++) {
            if (board[r][j] == board[r][j + 1]) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 1;
            }
        }
    }

    private static void checkCol(int c) {
        int cnt = 1;
        for (int i = 0; i < n - 1; i++) {
            if (board[i][c] == board[i + 1][c]) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 1;
            }
        }
    }

    private static void swap(int i, int j, int x, int y) {
        char temp = board[i][j];
        board[i][j] = board[x][y];
        board[x][y] = temp;
    }
}