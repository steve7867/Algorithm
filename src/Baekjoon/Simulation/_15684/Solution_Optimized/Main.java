/**
 * 사다리 조작
 * https://www.acmicpc.net/problem/15684
 */
package Baekjoon.Simulation._15684.Solution_Optimized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    static int n, m, h;
    static boolean[][] isSetup;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        h = Integer.parseInt(input[2]);
 
        isSetup = new boolean[h][n];
 
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]) - 1;
            int b = Integer.parseInt(input[1]) - 1;
            isSetup[a][b] = true;
        }
 
        for (int num = 0; num < 4; num++) {
            if (backtrack(0, 0, num))
                return;
        }
 
        System.out.println(-1);
    }
 
    // cur: 현재 위치
    // cnt: 현재까지 설치한 가로선의 수
    private static boolean backtrack(int cur,int cnt, int num) {
        if (cnt == num) {
            if (ladderCheck()) {
                System.out.println(cnt);
                return true;
            }
            return false;
        }
 
        if (cur == n * h)
            return false;
 
        int x = cur / n;
        int y = cur % n;
 
        if (isSetup[x][y] || y == n - 1)
            return backtrack(cur + 1, cnt, num);
 
        boolean canSetup = false;
        if (y == 0) {
            if (!isSetup[x][y + 1])
                canSetup = true;
        } else if (!isSetup[x][y - 1] && !isSetup[x][y + 1])
            canSetup = true;
 
        if (canSetup) {
            isSetup[x][y] = true;
            if (backtrack(cur + 1, cnt + 1, num))
                return true;
            isSetup[x][y] = false;
        }
 
        if (backtrack(cur + 1, cnt, num))
            return true;
 
        return false;
    }
 
    private static boolean ladderCheck() {
        for (int j = 0; j < n; j++) {
            int line = j;
            for (int i = 0; i < h; i++) {
                if (isSetup[i][line])
                    line++;
                else if (line - 1 >= 0 && isSetup[i][line - 1])
                    line--;
            }
 
            if (line != j)
                return false;
        }
 
        return true;
    }
}