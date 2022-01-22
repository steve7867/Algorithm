/**
 * 감시
 * https://www.acmicpc.net/problem/15683
 */
package Baekjoon.Simulation._15683._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N, M;
    private static int[][] board1 = new int[10][10];
    private static int[][] board2 = new int[10][10];
    private static int min;
    private static List<int[]> cctv = new ArrayList<>();
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board1[i][j] = Integer.parseInt(st.nextToken());
                if (board1[i][j] != 0 && board1[i][j] != 6) 
                    cctv.add(new int[] {i, j});
                if (board1[i][j] == 0) min++;
            }
        }
        
        for (int tmp = 0; tmp < 1 << (2 * cctv.size()); tmp++) {
            for (int i = 0; i < N; i++)
                System.arraycopy(board1[i], 0, board2[i], 0, M);
            
            int brute = tmp;
            for (int i = 0; i < cctv.size(); i++) {
                int dir = brute % 4;
                brute /= 4;
                
                int x = cctv.get(i)[0];
                int y = cctv.get(i)[1];
                
                switch (board1[x][y]) {
                case 1:
                    update(x, y, dir);
                    break;
                case 2:
                    update(x, y, dir);
                    update(x, y, dir + 2);
                    break;
                case 3:
                    update(x, y, dir);
                    update(x, y, dir + 1);
                    break;
                case 4:
                    update(x, y, dir);
                    update(x, y, dir + 1);
                    update(x, y, dir + 2);
                    break;
                case 5:
                    update(x, y, dir);
                    update(x, y, dir + 1);
                    update(x, y, dir + 2);
                    update(x, y, dir + 3);
                    break;
                }
            }
            
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board2[i][j] == 0) cnt++;
                }
            }
            
            min = Math.min(cnt, min);
        }
        System.out.println(min);
    }
 
    private static void update(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (OOB(x, y) || board2[x][y] == 6) return;
            if (board2[x][y] != 0) continue;
            board2[x][y] = 7;
        }
        
    }
    
    private static boolean OOB(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
 
}