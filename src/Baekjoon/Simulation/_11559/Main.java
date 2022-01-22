/**
 * Puyo Puyo
 * https://www.acmicpc.net/problem/11559
 */
package Baekjoon.Simulation._11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static char[][] board = new char[12][6];
    static boolean[][] visited;
    static ArrayList<int[]> list = new ArrayList<>();
    static Deque<Character> stack = new ArrayDeque<>();
    static int ans;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String input = br.readLine();
            for (int j = 0; j < 6; j++) {
                board[i][j] = input.charAt(j);
            }
        }
 
        while (true) {
            visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (board[i][j] != '.' && !visited[i][j])
                        bfs(i, j);
                }
            }
 
            if (list.isEmpty()) {
                System.out.println(ans);
                return;
            } else {
                ans++;
                for (int[] target : list)
                    board[target[0]][target[1]] = '.';
                list.clear();
                reArrange();
            }
        }
    }
 
    private static void reArrange() {
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 12; i++) {
                if (board[i][j] != '.')
                    stack.push(board[i][j]);
            }
 
            int top = 12;
            while (!stack.isEmpty())
                board[--top][j] = stack.pop();
 
            for (int i = top - 1; i >= 0; i--)
                board[i][j] = '.';
        }
    }
 
    private static void bfs(int i, int j) {
        char c = board[i][j];
 
        ArrayList<int[]> temp = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.offer(new int[]{i, j});
 
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            temp.add(new int[]{cur[0], cur[1]});
 
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (isOutOfBoundary(nx, ny))
                    continue;
                if (board[nx][ny] != c || visited[nx][ny])
                    continue;
 
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
 
        if (temp.size() >= 4)
            list.addAll(temp);
    }
 
    private static boolean isOutOfBoundary(int nx, int ny) {
        return nx < 0 || nx >= 12 || ny < 0 || ny >= 6;
    }
 
}