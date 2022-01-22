/**
 * 마법사 상어와 파이어볼
 * https://www.acmicpc.net/problem/20056
 */
package Baekjoon.Simulation._20056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
 
    private static class Fireball {
        int m;
        int s;
        int d;
 
        public Fireball(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
 
    }
 
    private static int n;
    private static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] evenD = {0, 2, 4, 6};
    private static final int[] oddD = {1, 3, 5, 7};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
 
        Queue<Fireball>[][] aBoard = new Queue[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                aBoard[i][j] = new LinkedList<>();
            }
        }
 
        Queue<Fireball>[][] bBoard = new Queue[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                bBoard[i][j] = new LinkedList<>();
            }
        }
 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
 
            aBoard[r][c].add(new Fireball(m, s, d));
        }
 
        for (int k = 0; k < K; k++) {
            Queue<Fireball>[][] from, to;
            if (k % 2 == 0) {
                from = aBoard;
                to = bBoard;
            } else {
                from = bBoard;
                to = aBoard;
            }
 
            collectiveMove(from, to);
            processAfterMove(to);
        }
 
        Queue<Fireball>[][] board;
        if (K % 2 == 0)
            board = aBoard;
        else
            board = bBoard;
 
        int ans = 0;
        for (int r = 1; r <= n; r++)
            for (int c = 1; c <= n; c++)
                for (Fireball fireball : board[r][c])
                    ans += fireball.m;
 
        System.out.println(ans);
    }
 
    private static void processAfterMove(Queue<Fireball>[][] board) {
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                if (board[r][c].size() < 2)
                    continue;
 
                int totalMass = 0;
                int totalSpeed = 0;
                int cnt = 0;
                boolean existEven = false;
                boolean existOdd = false;
 
                Queue<Fireball> fireballQueue = board[r][c];
 
                while (!fireballQueue.isEmpty()) {
                    Fireball fireball = fireballQueue.poll();
                    totalMass += fireball.m;
                    totalSpeed += fireball.s;
                    cnt++;
 
                    if (fireball.d % 2 == 0)
                        existEven = true;
                    else
                        existOdd = true;
                }
 
                int resMass = totalMass / 5;
                if (resMass == 0)
                    continue;
 
                int resSpeed = totalSpeed / cnt;
 
                int[] D;
                if ((existEven && !existOdd) || (!existEven && existOdd))
                    D = evenD;
                else
                    D = oddD;
 
                for (int i = 0; i < 4; i++)
                    fireballQueue.add(new Fireball(resMass, resSpeed, D[i]));
            }
        }
    }
 
    private static void collectiveMove(Queue<Fireball>[][] from, Queue<Fireball>[][] to) {
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                Queue<Fireball> fireballQueue = from[r][c];
 
                while (!fireballQueue.isEmpty()) {
                    Fireball fireball = fireballQueue.poll();
                    move(r, c, fireball, to);
                }
            }
        }
 
    }
 
    private static void move(int x, int y, Fireball fireball, Queue<Fireball>[][] to) {
        int d = fireball.d;
        int s = fireball.s;
 
        int destX = shift(x, dx[d], s);
        int destY = shift(y, dy[d], s);
 
        to[destX][destY].add(fireball);
    }
 
    private static int shift(int src, int d, int s) {
        if (d == 0)
            return src;
 
        int cur = src + d * s;
        if (d > 0) {
            while (cur > n)
                cur -= n;
        } else {
            while (cur <= 0) {
                cur += n;
            }
        }
 
        return cur;
    }
}