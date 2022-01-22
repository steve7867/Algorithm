/**
 * 드래곤 커브
 * https://www.acmicpc.net/problem/15685
 */
package Baekjoon.Simulation._15685;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static int[][] board = new int[101][101];
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
 
            List<Integer> list = new ArrayList<>();
            list.add(d);
            for (int g = 0; g < G; g++) {
                int size = list.size();
                for (int l = size - 1; l >= 0; l--) {
                    int dir = list.get(l);
                    list.add(dir + 1 >= 4 ? 0 : dir + 1);
                }
            }
 
            board[y][x]++;
            for (int dir : list) {
                y += dy[dir];
                x += dx[dir];
                board[y][x]++;
            }
 
        }
 
        int ans = 0;
        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                if (check(y, x))
                    ans++;
            }
        }
 
        System.out.println(ans);
    }
 
    static boolean check(int y, int x) {
        for (int dy = 0; dy < 2; dy++) {
            for (int dx = 0; dx < 2; dx++) {
                if (board[y + dy][x + dx] == 0)
                    return false;
            }
        }
 
        return true;
    }
}
