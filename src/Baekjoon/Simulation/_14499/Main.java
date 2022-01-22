/**
 * 주사위 굴리기
 * https://www.acmicpc.net/problem/14499
 *
 * 문제 해설: https://entrydeveloper.tistory.com/258
 */
package Baekjoon.Simulation._14499;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static int N, M;
    private static int[][] map;
    private static int[] cur = new int[2];
    private static int[] d = new int[6]; // {동, 서, 밑, 위, 앞, 뒤}
    private static Queue<Integer> orders = new LinkedList<>();
    private static int[] dx = {0, 0, 0, -1, 1};
    private static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        input();
        
        while (!orders.isEmpty()) {
            int order = orders.poll();
            int nx = cur[0] + dx[order];
            int ny = cur[1] + dy[order];
            if (OOB(nx , ny)) continue;
            int[] temp;
            
            switch (order) {
            case 1: //east
                temp = new int[] { d[3], d[2], d[0], d[1] };
                System.arraycopy(temp, 0, d, 0, 4);
                break;
            case 2: //west
                temp = new int[] {d[2], d[3], d[1], d[0]};
                System.arraycopy(temp, 0, d, 0, 4);
                break;
            case 3: //north
                temp = new int[] {d[5], d[4], d[2], d[3]};
                System.arraycopy(temp, 0, d, 2, 4);
                break;
            case 4: //south
                temp = new int[] {d[4], d[5], d[3], d[2]};
                System.arraycopy(temp, 0, d, 2, 4);
                break;
            }
            cur[0] = nx; cur[1] = ny;
            copy(nx, ny);
            bw.write(d[3] + "\n");
        }
        
        bw.flush();
    }   
    
    private static void copy(int nx, int ny) {
        if (map[nx][ny] == 0) map[nx][ny] = d[2];
        else {
            d[2] = map[nx][ny];
            map[nx][ny] = 0;
        }
    }

    private static boolean OOB(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        cur[0] = Integer.parseInt(st.nextToken());
        cur[1] = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            orders.add(Integer.parseInt(st.nextToken()));
        }
    }
}