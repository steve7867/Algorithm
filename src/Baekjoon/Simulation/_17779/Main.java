/**
 * 게리맨더링 2
 * https://www.acmicpc.net/problem/17779
 */
package Baekjoon.Simulation._17779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
 
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[][] A;
    private static final List<Pair> fiveAreas = new ArrayList<>();
    private static boolean[][] isFive;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static final Queue<Pair> q = new LinkedList<>();
    private static int ans = Integer.MAX_VALUE;
    private static final int[] res = new int[6];
 
    private static class Pair {
        int x;
        int y;
 
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 
    public static void main(String[] args) throws IOException {
        input();
 
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {
                        if (OOB(i, j, d1, d2))
                            continue;
 
                        markFive(i, j, d1, d2);
 
                        res[1] = processOne(i, j, d1, d2);
                        res[2] = processTwo(i, j, d1, d2);
                        res[3] = processThree(i, j, d1, d2);
                        res[4] = processFour(i, j, d1, d2);
                        res[5] = processFive();
 
                        int max = Integer.MIN_VALUE;
                        int min = Integer.MAX_VALUE;
                        for (int k = 1; k <= 5; k++) {
                            max = Math.max(max, res[k]);
                            min = Math.min(min, res[k]);
                        }
 
                        eraseFive();
 
                        if (ans > max - min)
                            ans = max - min;
                    }
                }
            }
        }
 
        System.out.println(ans);
    }
 
    private static int processFive() {
        int total = 0;
        for (Pair pair : fiveAreas)
            total += A[pair.x][pair.y];
 
        return total;
    }
 
    private static int processFour(int x, int y, int d1, int d2) {
        int total = 0;
        for (int r = x + d2 + 1; r <= N; r++) {
            for (int c = y - d1 + d2; c <= N; c++) {
                if (isFive[r][c])
                    continue;
 
                total += A[r][c];
            }
        }
        return total;
    }
 
    private static int processThree(int x, int y, int d1, int d2) {
        int total = 0;
        for (int r = x + d1; r <= N; r++) {
            for (int c = 1; c < y - d1 + d2; c++) {
                if (isFive[r][c])
                    continue;
 
                total += A[r][c];
            }
        }
        return total;
    }
 
    private static int processTwo(int x, int y, int d1, int d2) {
        int total = 0;
        for (int r = 1; r <= x + d2; r++) {
            for (int c = y + 1; c <= N; c++) {
                if (isFive[r][c])
                    continue;
 
                total += A[r][c];
            }
        }
 
        return total;
    }
 
    private static int processOne(int x, int y, int d1, int d2) {
        int total = 0;
        for (int r = 1; r < x + d1; r++) {
            for (int c = 1; c <= y; c++) {
                if (isFive[r][c])
                    continue;
 
                total += A[r][c];
            }
        }
 
        return total;
    }
 
    private static void eraseFive() {
        for (Pair pair : fiveAreas)
            isFive[pair.x][pair.y] = false;
 
        fiveAreas.clear();
    }
 
    private static boolean OOB(int x, int y, int d1, int d2) {
        return x + d1 + d2 > N || y - d1 < 1 || y + d2 > N;
    }
 
    private static void markFive(int x, int y, int d1, int d2) {
        //edge
        for (int r = x, c = y; r < x + d1 && c > y - d1; r++, c--) {
            isFive[r][c] = true;
            fiveAreas.add(new Pair(r, c));
        }
 
        for (int r = x + 1, c = y + 1; r <= x + d2 && c <= y + d2; r++, c++) {
            isFive[r][c] = true;
            fiveAreas.add(new Pair(r, c));
        }
 
        for (int r = x + d1, c = y - d1; r < x + d1 + d2 && c < y - d1 + d2; r++, c++) {
            isFive[r][c] = true;
            fiveAreas.add(new Pair(r, c));
        }
 
        for (int r = x + d2 + 1, c = y + d2 - 1; r <= x + d2 + d1 && c >= y + d2 - d1; r++, c--) {
            isFive[r][c] = true;
            fiveAreas.add(new Pair(r, c));
        }
 
        //inner
        for (int r = x + 1, c = y - 1; r <= x + d1 && c >= y - d1; r++, c--) {
            int i = c + 1;
            while (!isFive[r][i]) {
                isFive[r][i] = true;
                fiveAreas.add(new Pair(r, i));
                i++;
            }
        }
 
        for (int r = x + d1 + 1, c = y - d1 + 1; r < x + d1 + d2 && c < y - d1 + d2; r++, c++) {
            int i = c + 1;
            while (!isFive[r][i]) {
                isFive[r][i] = true;
                fiveAreas.add(new Pair(r, i));
                i++;
            }
        }
    }
 
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
 
        A = new int[N + 1][N + 1];
        isFive = new boolean[N + 1][N + 1];
 
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}