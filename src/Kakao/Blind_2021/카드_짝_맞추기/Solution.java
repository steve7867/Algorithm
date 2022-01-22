/**
 * 카드 짝 맞추기
 * https://programmers.co.kr/learn/courses/30/lessons/72415?language=java
 * 백트래킹과 BFS의 조합
 */
package Kakao.Blind_2021.카드_짝_맞추기;

import java.util.*;
 
class Solution {
    int[][] board;
    int r, c;
    int ans = Integer.MAX_VALUE;
    List<int[]> card = new ArrayList<>();
    List<int[]> permu = new ArrayList<>();
    boolean[] chosen = new boolean[12];
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
 
    public int solution(int[][] Board, int R, int C) {
        board = Board;
        r = R;
        c = C;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] > 0)
                    card.add(new int[]{i, j});
            }
        }
 
        backtrack(0);
        return ans;
    }
 
    private void backtrack(int idx) {
        if (idx == card.size()) {
            Queue<Integer> q = new LinkedList<>();
 
            int hit = 0;
            int[] src = new int[]{r, c};
            for (int[] dest : permu) {
                hit += bfs(src, dest) + 1; // +1은 enter키
                q.offer(board[dest[0]][dest[1]]);
                board[dest[0]][dest[1]] = 0;
 
                src = dest;
            }
            ans = Math.min(ans, hit);
 
            // 뒤집었던 카드 원래대로
            for (int[] pos : permu)
                board[pos[0]][pos[1]] = q.poll();
 
            return;
        }
 
        for (int i = 0; i < card.size(); i++) {
            if (chosen[i])
                continue;
 
            //같은 카드가 연속적으로 들어가지 않으면 continue
            if (idx % 2 == 1 &&
                    board[permu.get(idx - 1)[0]][permu.get(idx - 1)[1]]
                            != board[card.get(i)[0]][card.get(i)[1]])
                continue;
 
            chosen[i] = true;
            permu.add(card.get(i));
            backtrack(idx + 1);
            permu.remove(permu.size() - 1);
            chosen[i] = false;
        }
    }
 
    private int bfs(int[] src, int[] dest) {
        int[][] dist = new int[4][4];
        for (int i = 0; i < 4; i++)
            Arrays.fill(dist[i], -1);
 
        Queue<int[]> q = new LinkedList<>();
 
        dist[src[0]][src[1]] = 0;
        q.offer(new int[]{src[0], src[1]});
 
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
 
            if (curX == dest[0] && curY == dest[1])
                return dist[curX][curY];
 
            for (int dir = 0; dir < 4; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
 
                if (OOB(nx, ny))
                    continue;
 
                if (dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[curX][curY] + 1;
                    q.offer(new int[]{nx, ny});
                }
 
                // ctrl 조작
                for (int i = 0; i < 2; i++) {
                    if (OOB(nx + dx[dir], ny + dy[dir]))
                        break;
                    if (board[nx][ny] != 0)
                        break;
                    nx += dx[dir];
                    ny += dy[dir];
                }
 
                if (dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[curX][curY] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
 
        return -1;
    }
 
    private boolean OOB(int nx, int ny) {
        return nx < 0 || nx > 3 || ny < 0 || ny > 3;
    }
 
}
