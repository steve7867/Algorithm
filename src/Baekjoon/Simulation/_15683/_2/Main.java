/**
 * 감시
 * https://www.acmicpc.net/problem/15683
 */
package Baekjoon.Simulation._15683._2;

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
    private static int[][] map;
    private static List<int[]> list = new ArrayList<int[]>();
    private static int ans = Integer.MAX_VALUE;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[] ceil = {0, 4, 2, 4, 4, 1};
    
 
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) list.add(new int[] {i, j});
            }
        }
        
        backTrack(0);
        System.out.println(ans);
    }
    
    private static void backTrack(int k) {
        if (k == list.size()) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) cnt++;
                }
            }
            ans = Math.min(ans, cnt);
            return;
        }
        
        int[] cur = list.get(k);
        int x = cur[0];
        int y = cur[1];
        
        for (int dir = 0; dir < ceil[map[x][y]]; dir++) {
            spreadOrRemove(x, y, dir, true); // spread
            backTrack(k + 1);
            spreadOrRemove(x, y, dir, false); // remove
        }
    }
    
    private static void spreadOrRemove(int x, int y, int dir, boolean spread) {
        switch (map[x][y]) {
        case 1:
            process(x, y, dir, spread);
            break;
        case 2:
                process(x, y, dir, spread);
                process(x, y, dir + 2, spread);
            break;
        case 3:
                process(x, y, dir, spread);
                process(x, y, (dir + 1) % 4, spread);
            break;
        case 4:
            for (int i = 0; i < 3; i++)
                process(x, y, (dir + i) % 4, spread);
            break;
        case 5:
            for (int i = 0; i < 4; i++)
                process(x, y, (dir + i) % 4, spread);
            break;
        }
    }
    
    private static void process(int x, int y, int dir, boolean spread) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            if (map[nx][ny] == 6) break;
            if (spread && map[nx][ny] <= 0) map[nx][ny]--; //spread
            if (!spread && map[nx][ny] < 0) map[nx][ny]++; //remove
            nx += dx[dir];
            ny += dy[dir];
        }        
    }
}