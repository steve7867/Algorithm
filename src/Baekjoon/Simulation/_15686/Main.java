/**
 * 치킨 배달
 * https://www.acmicpc.net/problem/15686
 */
package Baekjoon.Simulation._15686;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N, M;
    private static int K; //폐업할 개수
    private static int ans = Integer.MAX_VALUE;
    private static int[][] map;
    private static List<int[]> chicken = new ArrayList<int[]>(13);
 
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) chicken.add(new int[] {i, j});
            }
        }
        
        K = chicken.size() - M; //폐업할 개수
        
        backTrack(0, 0);
        System.out.println(ans);
    }    
    
    private static void backTrack(int closed, int start) {
        if (closed == K) {
            int totalDist = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) totalDist += getChickenDist(i, j); 
                }
            }
            
            ans = Math.min(ans, totalDist);
            return;
        }
        
        for (int i = start; i < chicken.size(); i++) {
            int[] cur = chicken.get(i);
            int x = cur[0];
            int y = cur[1];
            map[x][y] = 0;
            backTrack(closed + 1, i + 1);
            map[x][y] = 2;
        }
    }
 
    private static int getChickenDist(int x, int y) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    int dist = Math.abs(i - x) + Math.abs(j - y);
                    min = Math.min(min, dist);
                }
            }
        }
        
        return min;
    }
}