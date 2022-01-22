/**
 * 구슬 탈출 2
 * https://www.acmicpc.net/problem/13460
 */
package Baekjoon.Simulation._13460.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static int n, m;
    static char[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int ans = 11;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
 
        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = input.charAt(j);
                board[i][j] = c;
 
                if (c == 'R') {
                    rx = i;
                    ry = j;
                }
 
                if (c == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
 
        backtrack(1, rx, ry, bx, by);
        System.out.println(ans == 11 ? -1 : ans);
    }
 
    private static void backtrack(int moveNum, int rx, int ry, int bx, int by) {
        if (moveNum == 11)
            return;
 
        for (int dir = 0; dir < 4; dir++) {
            boolean redFirst = false;
            if (ry == by) {
                if (dir == 0 && rx > bx)
                    redFirst = true;
                if (dir == 1 && rx < bx)
                    redFirst = true;
            }
 
            if (rx == bx) {
                if (dir == 2 && ry > by)
                    redFirst = true;
                if (dir == 3 && ry < by)
                    redFirst = true;
            }
 
            Result redResult, blueResult;
            if (redFirst) {
                redResult = move(rx, ry, 0, 0, dir);
                blueResult = move(bx, by, redResult.x, redResult.y, dir);
            } else {
                blueResult = move(bx, by, 0, 0, dir);
                redResult = move(rx, ry, blueResult.x, blueResult.y, dir);
            }
 
            if (blueResult.fallInHole)
                continue;
            else if (redResult.fallInHole) {
                if (ans > moveNum)
                    ans = moveNum;
                return;
            } else
                backtrack(moveNum + 1, redResult.x, redResult.y, blueResult.x, blueResult.y);
        }
    }
 
    private static Result move(int stX, int stY, int pX, int pY, int dir) {
        int curX = stX;
        int curY = stY;
 
        while (true) {
            curX += dx[dir];
            curY += dy[dir];
 
            if ((curX == pX && curY == pY) || board[curX][curY] == '#') {
                curX -= dx[dir];
                curY -= dy[dir];
                break;
            }
 
            if (board[curX][curY] == 'O') {
                return new Result(0, 0, true);
            }
        }
 
        return new Result(curX, curY, false);
    }
}
 
class Result {
    int x;
    int y;
    boolean fallInHole;
 
    public Result(int x, int y, boolean fallInHole) {
        this.x = x;
        this.y = y;
        this.fallInHole = fallInHole;
    }
}
