/**
 * 경사로
 * https://www.acmicpc.net/problem/14890
 */
package Baekjoon.Simulation._14890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    static int n;
    static int l;
    static int[][] board;
    static int ans;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        l = Integer.parseInt(input[1]);
        board = new int[n][n];
 
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++)
                board[i][j] = Integer.parseInt(input[j]);
        }
 
        for (int i = 0; i < n; i++) {
            boolean canPass = true;
            boolean[] isSetup = new boolean[n];
            for (int j = 0; j < n - 1; j++) {
                int k = j + 1;
                if (board[i][j] == board[i][k])
                    continue;
                else if (Math.abs(board[i][j] - board[i][k]) > 1) {
                    canPass = false;
                    break;
                } else if (board[i][j] + 1 == board[i][k]) {
                    if (settableRow(j - l + 1, j, i, isSetup)) {
                        for (int m = j - l + 1; m <= j; m++)
                            isSetup[m] = true;
                    } else {
                        canPass = false;
                        break;
                    }
                } else if (board[i][j] == board[i][k] + 1) {
                    if (settableRow(k, k + l - 1, i, isSetup)) {
                        for (int m = k; m <= k + l - 1; m++)
                            isSetup[m] = true;
                    } else {
                        canPass = false;
                        break;
                    }
                }
            }
 
            if (canPass)
                ans++;
        }
 
        for (int j = 0; j < n; j++) {
            boolean canPass = true;
            boolean[] isSetup = new boolean[n];
            for (int i = 0; i < n - 1; i++) {
                int k = i + 1;
                if (board[i][j] == board[k][j])
                    continue;
                else if (Math.abs(board[i][j] - board[k][j]) > 1) {
                    canPass = false;
                    break;
                } else if (board[i][j] + 1 == board[k][j]) {
                    if (settableCol(i - l + 1, i, j, isSetup)) {
                        for (int m = i - l + 1; m <= i; m++)
                            isSetup[m] = true;
                    } else {
                        canPass = false;
                        break;
                    }
                } else if (board[i][j] == board[k][j] + 1) {
                    if (settableCol(k, k + l - 1, j, isSetup)) {
                        for (int m = k; m <= k + l - 1; m++)
                            isSetup[m] = true;
                    } else {
                        canPass = false;
                        break;
                    }
                }
            }
 
            if (canPass)
                ans++;
        }
 
        System.out.println(ans);
    }
 
    private static boolean settableRow(int a, int b, int row, boolean[] isSetup) {
        if (a < 0 || b >= n)
            return false;
 
        int anchor = board[row][a];
        for (int j = a; j <= b; j++) {
            if (isSetup[j])
                return false;
 
            if (anchor != board[row][j])
                return false;
        }
 
        return true;
    }
 
    private static boolean settableCol(int a, int b, int col, boolean[] isSetup) {
        if (a < 0 || b >= n)
            return false;
 
        int anchor = board[a][col];
        for (int i = a; i <= b; i++) {
            if (isSetup[i])
                return false;
 
            if (anchor != board[i][col])
                return false;
        }
 
        return true;
    }
}