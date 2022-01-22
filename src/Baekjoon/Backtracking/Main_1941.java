/**
 * 소문난 칠공주
 * https://www.acmicpc.net/problem/1941
 *
 * 문제 해설: https://entrydeveloper.tistory.com/226
 */
package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1941 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static char[][] board = new char[5][5];
    private static int[] arr = new int[7];
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean[][] visited;
    // bfs를 위한 map.
    private static boolean[][] reachable;
    private static int ans;
    
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++)
            board[i] = br.readLine().toCharArray();
        
        func(0, 0);
        System.out.println(ans);
    }
    
    // 25명의 학생 중 7명의 학생을 선별해 조합을 만들어 arr에 저장.
    private static void func(int start, int k) {
        if (k == 7) {
            if (getNumOfS() >= 4 && isAdjacent()) ans++;
            return;
        }
        
        for (int i = start; i < 25; i++) {
            arr[k] = i;
            func(i + 1, k + 1);
        }
    }
    
    // arr에 있는 학생들이 서로 인접한지 bfs를 이용해 확인.
    private static boolean isAdjacent() {
        visited = new boolean[5][5];
        reachable = new boolean[5][5];
        for (int i = 0; i < 7; i++) {
            int x = arr[i] / 5;
            int y = arr[i] % 5;
            reachable[x][y] = true;
        }
        
        Queue<int[]> q = new LinkedList<int[]>();
        int x = arr[0] / 5;
        int y = arr[0] % 5;
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        int cnt = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;
                if (visited[nx][ny] || !reachable[nx][ny]) continue;
                q.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
                cnt++;
            }
        }
        return cnt == 7 ? true : false;
    }
    
    // arr의 학생 중 'S'가 몇 명인지.
    private static int getNumOfS() {
        int cnt = 0;
        for (int i = 0; i < 7; i++) {
            int x = arr[i] / 5, y = arr[i] % 5;
            if (board[x][y] == 'S') cnt++;
        }
        return cnt;
    }
}