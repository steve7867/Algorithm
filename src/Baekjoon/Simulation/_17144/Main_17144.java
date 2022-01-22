/**
 * 미세먼지 안녕!
 * https://www.acmicpc.net/problem/17144
 */
package Baekjoon.Simulation._17144;

import java.io.*;
import java.util.*;
 
public class Main_17144 {
    private static int R, C, T;
    private static int low, high;
    private static int[][] board;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static List<Pair> highPath = new ArrayList<>();
    private static List<Pair> lowPath = new ArrayList<>();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        board = new int[R][C];
 
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
 
                if (board[i][j] == -1) {
                    low = i;
                    high = i - 1;
                }
 
            }
        }
 
        setPath();
 
        while (T-- > 0) {
            spread();
            purify();
        }
 
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] > 0)
                    sum += board[i][j];
            }
        }
 
        System.out.println(sum);
    }
 
    private static void setPath() {
        for (int j = 1; j < C; j++)
            highPath.add(new Pair(high, j));
 
        for (int i = high - 1; i >= 0; i--)
            highPath.add(new Pair(i, C - 1));
 
        for (int j = C - 2; j >= 0; j--)
            highPath.add(new Pair(0, j));
 
        for (int i = 1; i < high; i++)
            highPath.add(new Pair(i, 0));
 
 
        for (int j = 1; j < C; j++)
            lowPath.add(new Pair(low, j));
 
        for (int i = low + 1; i < R; i++)
            lowPath.add(new Pair(i, C - 1));
 
        for (int j = C - 2; j >= 0; j--)
            lowPath.add(new Pair(R - 1, j));
 
        for (int i = R - 2; i > low; i--)
            lowPath.add(new Pair(i, 0));
    }
 
    private static void spread() {
        List<Pair> list = new ArrayList<>();
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (board[x][y] > 0)
                    list.add(new Pair(x, y, board[x][y]));
            }
        }
 
        for (Pair cur : list) {
            int cnt = 0;
            int spreadSize = cur.dust / 5;
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
 
                if (OOB(nx, ny))
                    continue;
 
                board[nx][ny] += spreadSize;
                cnt++;
            }
 
            board[cur.x][cur.y] -= spreadSize * cnt;
        }
    }
 
    private static boolean OOB(int x, int y) {
        return x < 0 || x >= R || y < 0 || y >= C || board[x][y] == -1;
    }
 
    private static void purify() {
        Deque<Integer> dq = new LinkedList<>();
 
        for (Pair p : highPath)
            dq.offer(board[p.x][p.y]);
 
        dq.pollLast();
        dq.offerFirst(0);
 
        for (Pair p : highPath)
            board[p.x][p.y] = dq.pollFirst();
 
        dq.clear();
 
        for (Pair p : lowPath)
            dq.offer(board[p.x][p.y]);
 
        dq.pollLast();
        dq.offerFirst(0);
 
        for (Pair p : lowPath)
            board[p.x][p.y] = dq.pollFirst();
    }
}
 
class Pair {
    int x;
    int y;
    int dust;
 
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
 
    Pair(int x, int y, int dust) {
        this.x = x;
        this.y = y;
        this.dust = dust;
    }
}