/**
 * 스티커 붙이기
 * https://www.acmicpc.net/problem/18808
 */
package Baekjoon.Simulation._18808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N, M, K;
    private static int[][] board = new int[50][50]; // notebook
    private static Queue<Sticker> stickers = new LinkedList<Sticker>();
 
    public static void main(String[] args) throws IOException {
        input();
        
        while (!stickers.isEmpty()) {
            Sticker s = stickers.poll();
            boolean completed = false;
            
            for (int rot = 0; rot < 4; rot++) {
                for (int x = 0; x <= N - s.X; x++) {
                    for (int y = 0; y <= M - s.Y; y++) {
                        if (possible(x, y, s)) { 
                            paste(x, y, s); 
                            completed = true; 
                            break;}
                    }
                    if (completed) break;
                }
                if (completed) break;
                rotate(s);
            }
                
        }
        
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                 cnt += board[i][j];
            }
        }
        System.out.println(cnt);
    }
    
    private static void rotate(Sticker s) {
        int[][] tmp = new int[s.X][s.Y];
        for (int i = 0; i < s.X; i++) {
            for (int j = 0; j < s.Y; j++) {
                tmp[i][j] = s.map[i][j];
            }
        }
        
        s.map = new int[s.Y][s.X];
        for (int i = 0; i < s.X; i++) {
            for (int j = 0; j < s.Y; j++) {
                s.map[j][s.X - 1 - i] = tmp[i][j];
            }
        }
        
        int temp = s.X;
        s.X = s.Y;
        s.Y = temp;
    }
 
    private static void paste(int x, int y, Sticker s) {
        for (int i = 0; i < s.X; i++) {
            for (int j = 0; j < s.Y; j++) {
                board[x + i][y + j] += s.map[i][j];
            }
        }
    }
 
    private static boolean possible(int x, int y, Sticker s) {
        for (int i = 0; i < s.X; i++) {
            for (int j = 0; j < s.Y; j++) {
                if (board[x + i][y + j]== 1 && s.map[i][j] == 1) return false;
            }
        }
        
        return true;
    }
 
    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Sticker s = new Sticker(x, y);
            for (int i = 0; i < x; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < y; j++) {
                    s.map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(s);
        }
    }
    
}
 
class Sticker {
    int[][] map;
    int X;
    int Y;
    
    Sticker (int X, int Y) {
        this.X = X;
        this.Y = Y;
        map = new int[X][Y];
    }
}