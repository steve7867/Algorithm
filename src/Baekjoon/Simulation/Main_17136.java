/**
 * 색종이 붙이기
 * https://www.acmicpc.net/problem/17136
 */
package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main_17136 {
 
    private static int ans = Integer.MAX_VALUE;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[][] board = new int[10][10];
    private static final boolean[][] isCovered = new boolean[10][10];
    private static final int[] numOfPaper = new int[6];
    private static final List<Pair> oneList = new ArrayList<>();
 
    private static class Pair {
        int x;
        int y;
 
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 
    static {
        Arrays.fill(numOfPaper, 5);
    }
 
    public static void main(String[] args) throws IOException {
        input();
 
        if (oneList.size() == 0)
            ans = 0;
        else
            backtrack(0, 0);
 
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
 
    private static void input() throws IOException {
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                int a = Integer.parseInt(st.nextToken());
                board[i][j] = a;
                if (a == 1)
                    oneList.add(new Pair(i, j));
            }
        }
    }
 
    private static void backtrack(int idx, int used) {
        if (idx == oneList.size()) {
            ans = Math.min(ans, used);
            return;
        }
 
        Pair pair = oneList.get(idx);
        int x = pair.x;
        int y = pair.y;
 
        if (isCovered[x][y]) {
            backtrack(idx + 1, used);
            return;
        }
 
        for (int p = 1; p <= 5; p++) {
            if (numOfPaper[p] > 0 && isAttachable(x, y, p)) {
                attach(x, y, p);
                backtrack(idx + 1, used + 1);
                detach(x, y, p);
            }
        }
    }
 
    private static boolean isAttachable(int x, int y, int p) {
        int rightEdge = x + p - 1;
        int lowerEdge = y + p - 1;
 
        if (rightEdge >= 10 || lowerEdge >= 10)
            return false;
 
        for (int i = x; i < x + p; i++) {
            for (int j = y; j < y + p; j++) {
                if (board[i][j] == 0 || isCovered[i][j])
                    return false;
            }
        }
 
        return true;
    }
 
    private static void detach(int x, int y, int p) {
        numOfPaper[p]++;
 
        for (int i = x; i < x + p; i++) {
            for (int j = y; j < y + p; j++) {
                isCovered[i][j] = false;
            }
        }
    }
 
    private static void attach(int x, int y, int p) {
        numOfPaper[p]--;
 
        for (int i = x; i < x + p; i++) {
            for (int j = y; j < y + p; j++) {
                isCovered[i][j] = true;
            }
        }
    }
}
