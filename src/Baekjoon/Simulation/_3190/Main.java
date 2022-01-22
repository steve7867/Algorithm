/**
 * 뱀
 * https://www.acmicpc.net/problem/3190
 */
package Baekjoon.Simulation._3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1}; // 북동남서
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n + 1][n + 1];
 
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], 'o');
 
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            board[x][y] = 'a';
        }
 
        Map<Integer, Character> turn = new HashMap<>();
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            String[] input = br.readLine().split(" ");
            int second = Integer.parseInt(input[0]);
            char dir = input[1].charAt(0);
 
            turn.put(second, dir);
        }
 
        Queue<int[]> tails = new LinkedList<>();
        int curX = 1, curY = 1;
        board[curX][curY] = 's';
        tails.offer(new int[]{curX, curY});
        int s = 1, dir = 1;
        while (true) {
            curX += dx[dir];
            curY += dy[dir];
 
            if (curX < 1 || curX > n || curY < 1 || curY > n)
                break;
            if (board[curX][curY] == 's')
                break;
 
            if (board[curX][curY] != 'a') {
                int[] tail = tails.poll();
                board[tail[0]][tail[1]] = 'o';
            }
            board[curX][curY] = 's';
            tails.offer(new int[]{curX, curY});
 
 
            if (turn.containsKey(s)) {
                char c = turn.get(s);
                if (c == 'L')
                    dir--;
                else
                    dir++;
 
                if (dir == -1)
                    dir = 3;
                else if (dir == 4)
                    dir = 0;
 
                turn.remove(s);
            }
 
            s++;
        }
 
        System.out.println(s);
    }
}
