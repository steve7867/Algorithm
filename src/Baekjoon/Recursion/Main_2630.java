/**
 * 색종이 만들기
 * https://www.acmicpc.net/problem/2630
 */
package Baekjoon.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    static int white, blue;
    static int n;
    static int[][] board;
 
    public static void main(String[] args) throws IOException {
        input();
 
        cut(0, 0, n);
 
        System.out.println(white);
        System.out.println(blue);
    }
 
    private static void cut(int x, int y, int size) {
        if (size == 1 || isAllSame(x, y, size)) {
            if (board[x][y] == 1)
                blue++;
            else
                white++;
            return;
        }
 
        int newSize = size / 2;
 
        cut(x, y, newSize);
        cut(x, y + newSize, newSize);
        cut(x + newSize, y, newSize);
        cut(x + newSize, y + newSize, newSize);
    }
 
    private static boolean isAllSame(int x, int y, int size) {
        int color = board[x][y];
 
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != color)
                    return false;
            }
        }
 
        return true;
    }
 
    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
 
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

//BFS를 활용한 풀이
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    static int white, blue;
//    static int n;
//    static int[][] board;
//
//    public static void main(String[] args) throws IOException {
//        input();
//
//        Queue<Triple> q = new LinkedList<>();
//        q.offer(new Triple(0, 0, n));
//
//        while (!q.isEmpty()) {
//            Triple cur = q.poll();
//            int x = cur.x;
//            int y = cur.y;
//            int size = cur.size;
//
//            if (size == 1 || isAllSame(x, y, size)) {
//                if (board[x][y] == 1)
//                    blue++;
//                else
//                    white++;
//                continue;
//            }
//
//            int newSize = size / 2;
//
//            q.offer(new Triple(x, y, newSize));
//            q.offer(new Triple(x, y + newSize, newSize));
//            q.offer(new Triple(x + newSize, y, newSize));
//            q.offer(new Triple(x + newSize, y + newSize, newSize));
//        }
//
//        System.out.println(white);
//        System.out.println(blue);
//    }
//
//    private static boolean isAllSame(int x, int y, int size) {
//        int color = board[x][y];
//
//        for (int i = x; i < x + size; i++) {
//            for (int j = y; j < y + size; j++) {
//                if (board[i][j] != color)
//                    return false;
//            }
//        }
//
//        return true;
//    }
//
//    private static void input() throws IOException {
//        n = Integer.parseInt(br.readLine());
//        board = new int[n][n];
//
//        StringTokenizer st;
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < n; j++) {
//                board[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//    }
//}
//
//class Triple {
//    int x;
//    int y;
//    int size;
//
//    public Triple(int x, int y, int size) {
//        this.x = x;
//        this.y = y;
//        this.size = size;
//    }
//}