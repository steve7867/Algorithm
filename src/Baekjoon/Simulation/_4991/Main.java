/**
 * 로봇 청소기
 * https://www.acmicpc.net/problem/4991
 */
package Baekjoon.Simulation._4991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static class Pair {
        int x;
        int y;
 
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
 
        @Override
        public boolean equals(Object obj) {
            Pair p = (obj instanceof Pair) ? (Pair) obj: null;
 
            return this.x == p.x && this.y == p.y;
        }
    }
 
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static int h, w;
    private static char[][] board;
    private static int[][] distArr;
    private static List<Pair> list = new ArrayList<>();
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
 
    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
 
            if (h == 0 && w == 0)
                break;
 
            preprocess();
 
            if (!possible()) {
                sb.append(-1).append('\n');
                continue;
            }
 
            for (Pair src : list)
                bfs(src);
 
            List<Pair> temp = new ArrayList<>();
            temp.add(list.get(0));
            sb.append(backtrack(temp, new boolean[list.size()])).append('\n');
        }
 
        System.out.println(sb);
    }
 
    private static int backtrack(List<Pair> temp, boolean[] visited) {
        if (temp.size() == list.size()) {
            int dist = 0;
            Pair cur = temp.get(0);
 
            for (int i = 1; i < temp.size(); i++) {
                Pair next = temp.get(i);
                dist += distArr[getPos(cur)][getPos(next)];
                cur = next;
            }
 
            return dist;
        }
 
        int minDist = Integer.MAX_VALUE;
 
        for (int i = 1; i < list.size(); i++) {
            if (visited[i])
                continue;
 
            visited[i] = true;
            temp.add(list.get(i));
            minDist = Math.min(minDist, backtrack(temp, visited));
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
 
        return minDist;
    }
 
    private static boolean possible() {
        int trashCnt = list.size() - 1;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
 
        Pair src = list.get(0);
        visited[src.x][src.y] = true;
        q.offer(src);
 
        while (!q.isEmpty()) {
            Pair cur = q.poll();
 
            if (board[cur.x][cur.y] == '*')
                trashCnt--;
 
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
 
                if (OOB(nx, ny))
                    continue;
                if (board[nx][ny] == 'x' || visited[nx][ny])
                    continue;
 
                visited[nx][ny] = true;
                q.offer(new Pair(nx, ny));
            }
        }
 
        return trashCnt == 0;
    }
 
    private static boolean OOB(int x, int y) {
        return x < 0 || x >= h || y < 0 || y >= w;
    }
 
    private static void bfs(Pair src) {
        int[][] space = new int[h][w];
        for (int i = 0; i < h; i++)
            Arrays.fill(space[i] , -1);
 
        Queue<Pair> q = new LinkedList<>();
 
        space[src.x][src.y] = 0;
        q.offer(src);
 
        while (!q.isEmpty()) {
            Pair cur = q.poll();
 
            if (!cur.equals(src) && board[cur.x][cur.y] == 'o' || board[cur.x][cur.y] == '*') {
                int pos1 = getPos(src);
                int pos2 = getPos(cur);
 
                distArr[pos1][pos2] = space[cur.x][cur.y];
                distArr[pos2][pos1] = space[cur.x][cur.y];
            }
 
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
 
                if (OOB(nx, ny))
                    continue;
                if (board[nx][ny] == 'x' || space[nx][ny] >= 0)
                    continue;
 
                space[nx][ny] = space[cur.x][cur.y] + 1;
                q.offer(new Pair(nx, ny));
            }
 
        }
    }
 
    private static void preprocess() throws IOException {
        board = new char[h][w];
        distArr = new int[400][400];
        list.clear();
 
        for (int i = 0; i < h; i++) {
            String input = br.readLine();
            for (int j = 0; j < w; j++) {
                char c = input.charAt(j);
                board[i][j] = c;
 
                if (c == 'o')
                    list.add(0, new Pair(i, j));
 
                if (c == '*')
                    list.add(new Pair(i, j));
            }
        }
    }
 
    private static int getPos(Pair p) {
        return p.x * w + p.y;
    }
}
