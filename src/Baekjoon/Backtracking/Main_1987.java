/**
 * 알파벳
 * https://www.acmicpc.net/problem/1987
 */
package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_1987 {
    static char[][] board;
    static int r, c;
    static int ans = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
 
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = input.charAt(j);
            }
        }
 
        backtrack(0, 0, 1, new boolean[26]);
 
        System.out.println(ans);
    }
 
    private static void backtrack(int x, int y, int cnt, boolean[] used) {
        used[board[x][y] - 'A'] = true;
 
        if (cnt > ans)
            ans = cnt;
 
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (OOB(nx, ny) || used[board[nx][ny] - 'A'])
                continue;
            backtrack(nx, ny, cnt + 1, used);
        }
 
        used[board[x][y] - 'A'] = false;
    }
 
    private static boolean OOB(int nx, int ny) {
        return nx < 0 || nx >= r || ny < 0 || ny >= c;
    }
}

//다른 풀이
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    static char[][] board;
//    static int r, c;
//    static int ans = 0;
//    static int[] dx = {1, -1, 0, 0};
//    static int[] dy = {0, 0, 1, -1};
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        r = Integer.parseInt(st.nextToken());
//        c = Integer.parseInt(st.nextToken());
//        board = new char[r][c];
//
//        for (int i = 0; i < r; i++) {
//            String input = br.readLine();
//            for (int j = 0; j < c; j++) {
//                board[i][j] = input.charAt(j);
//            }
//        }
//
//        backtrack(0, 0, 1, 0);
//
//        System.out.println(ans);
//    }
//
//    private static void backtrack(int x, int y, int cnt, int set) {
//        set |= 1 << board[x][y] - 'A';
//
//        if (cnt > ans)
//            ans = cnt;
//
//        for (int dir = 0; dir < 4; dir++) {
//            int nx = x + dx[dir];
//            int ny = y + dy[dir];
//            if (OOB(nx, ny) || (set & (1 << (board[nx][ny] - 'A'))) != 0)
//                continue;
//            backtrack(nx, ny, cnt + 1, set);
//        }
//
//
//        set &= ~(1 << board[x][y] - 'A');
//    }
//
//    private static boolean OOB(int nx, int ny) {
//        return nx < 0 || nx >= r || ny < 0 || ny >= c;
//    }
//}