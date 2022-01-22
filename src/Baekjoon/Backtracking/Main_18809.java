/**
 * Gaaaaaaaaaarden
 * https://www.acmicpc.net/problem/18809
 */
package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main_18809 {
 
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N, M, G, R, ans;
    private static int[][] map; // 정원
    private static ArrayList<int[]> cult; // 배양 가능한 위치
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static final int WATER             = 0;
    private static final int IMPOSSIBLE_GARDEN = 1;
    private static final int POSSIBLE_GARDEN   = 2;
    private static final int GREEN             = 3;
    private static final int RED               = 4;
    private static final int FLOWER            = 7;// 3 + 4
 
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        cult = new ArrayList<int[]>(G + R);
 
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == POSSIBLE_GARDEN) 
                    cult.add(new int[] { i, j });
            }
        }
        
        func(G, R, 0);
        
        System.out.println(ans);
    }
    
    //k번째 배양 가능한 땅에 (그린, 레드, 안 뿌림) 중 하나를 선택하여 맵을 만든 후,
    //배양액을 다 쓰면 bfs 수행
    private static void func(int g, int r, int k) {
        
        if (g + r == 0) {
            ans = Math.max(ans, bfs());
            return;
        }
        //func(g, r, k + 1);만 계속 수행될 경우
        if (k == cult.size()) return;
 
        int[] cur = cult.get(k);
        int x = cur[0], y = cur[1];
        
        if (g > 0) {
            map[x][y] = GREEN;
            func(g - 1, r, k + 1);
            map[x][y] = POSSIBLE_GARDEN;
        }
 
        if (r > 0) {
            map[x][y] = RED;
            func(g, r - 1, k + 1);
            map[x][y] = POSSIBLE_GARDEN;
        }
 
        func(g, r, k + 1);
    }
 
    private static int bfs() {
        
        int[][] mapCopy = new int[N][M];
        int[][] time = new int[N][M];
        Queue<int[]> q = new LinkedList<int[]>();
        
        for (int i = 0; i < N; i++) 
            System.arraycopy(map[i], 0, mapCopy[i], 0, M);
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(time[i], -1);
            for (int j = 0; j < M; j++)
                if (mapCopy[i][j] == GREEN || mapCopy[i][j] == RED) {
                    q.offer(new int[] {i, j});
                    time[i][j] = 0;
                }
        }
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            //큐에 들어와 있는데 다른 배양액이 퍼져서 꽃이 피는 경우도 있다
            if (mapCopy[curX][curY] != GREEN && mapCopy[curX][curY] != RED) continue;
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (mapCopy[nx][ny] == IMPOSSIBLE_GARDEN || mapCopy[nx][ny] == POSSIBLE_GARDEN) {
                    mapCopy[nx][ny] = mapCopy[curX][curY];
                    q.offer(new int[] {nx, ny});
                    time[nx][ny] = time[curX][curY] + 1;
                }
                
                if (mapCopy[curX][curY] + mapCopy[nx][ny] == FLOWER && time[nx][ny] == time[curX][curY] + 1)
                    mapCopy[nx][ny] = FLOWER;
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) 
                if (mapCopy[i][j] == FLOWER)
                    cnt++;
        
        return cnt;
    }
}
