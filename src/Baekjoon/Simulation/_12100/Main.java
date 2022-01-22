/**
 * 2048 (Easy)
 * https://www.acmicpc.net/problem/12100
 */
package Baekjoon.Simulation._12100;

import java.io.*;
import java.util.StringTokenizer;
 
public class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N, ans;
    private static int[][] map, map2;
 
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        map2 = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        for (int tmp = 0; tmp < 1 << (2 * 5); tmp++) {
            for (int i = 0; i < N; i++)
                System.arraycopy(map[i], 0, map2[i], 0, N);
            
            int brute = tmp;
            for (int i = 0; i < 5; i++) {
                int dir = brute % 4;
                brute /= 4;
                
                tilt(dir);
            }
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    ans = Math.max(ans, map2[i][j]);
            }
        }
        System.out.println(ans);
    }
    
    private static void tilt(int dir) {
        while (dir-- > 0) rotate();
        
        for (int i = 0; i < N; i++) {
            int[] tilted = new int[N];
            int idx = 0;
            for (int j = 0; j < N; j++) {
                if (map2[i][j] == 0) continue;
                if (tilted[idx] == 0) tilted[idx] = map2[i][j];
                else if (tilted[idx] == map2[i][j]) tilted[idx++] *= 2;
                else tilted[++idx] = map2[i][j];
            }
            for (int j = 0; j < N; j++) map2[i][j] = tilted[j];
        }
    }
 
    private static void rotate() {
        int[][] temp = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                temp[i][j] = map2[i][j];
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                map2[i][j] = temp[N - 1 -j][i];
        }
    }
}