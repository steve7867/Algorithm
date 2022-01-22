/**
 * 낚시왕
 * https://www.acmicpc.net/problem/17143
 */
package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main_17143 {
    static class Shark {
        static int[] dx = {0, -1, 1, 0, 0};
        static int[] dy = {0, 0, 0, 1, -1};
 
        int x;
        int y;
        int speed;
        int dir;
        int size;
 
        Shark(int x, int y, int speed, int dir, int size) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }
 
        public void move() {
            for (int i = 0; i < speed; i++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
 
                if (OOB(nx, ny)) {
                    if (dir % 2 == 1)
                        dir++;
                    else
                        dir--;
 
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
 
                x = nx;
                y = ny;
            }
        }
 
        private static boolean OOB(int x, int y) {
            return x < 1 || x > R || y < 1 || y > C;
        }
    }
 
    private static int R, C, M;
    private static Shark[][] board;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
 
        board = new Shark[R + 1][C + 1];
 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
 
            board[x][y] = new Shark(x, y, speed, dir, size);
        }
 
        int sum = 0;
        for (int j = 1; j <= C; j++) {
 
            int i = 1;
            while (i <= R) {
                if (board[i][j] != null)
                    break;
 
                i++;
            }
 
            if (1 <= i && i <= R) {
                Shark prey = board[i][j];
                sum += prey.size;
                board[i][j] = null;
            }
 
            collectiveMove();
        }
 
        System.out.println(sum);
    }
 
    private static void collectiveMove() {
        List<Shark> list = new ArrayList<>();
 
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (board[i][j] == null)
                    continue;
 
                Shark s = board[i][j];
                board[i][j] = null;
                s.move();
                list.add(s);
 
            }
        }
 
        for (Shark s : list) {
            int x = s.x;
            int y = s.y;
 
            if (board[x][y] == null)
                board[x][y] = s;
            else {
                if ( s.size > board[x][y].size)
                    board[x][y] = s;
            }
        }
    }
}