/**
 * 거리두기 확인하기
 * https://programmers.co.kr/learn/courses/30/lessons/81302
 */
package Kakao.Internship_2021.거리두기_확인하기;

import java.util.*;
 
class Solution {
    char[][] room;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
 
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
 
        for (int num = 0; num < 5; num++) {
            room = new char[5][5];
            List<int[]> p = new ArrayList<>();
 
            for (int i = 0; i < 5; i++) {
                String input = places[num][i];
                for (int j = 0; j < 5; j++) {
                    char c = input.charAt(j);
                    room[i][j] = c;
                    if (c == 'P')
                        p.add(new int[]{i, j});
                }
            }
 
            if (p.size() == 1) {
                answer[num] = 1;
                continue;
            }
 
            boolean obey = true;
            for (int i = 0; i < p.size() - 1; i++) {
                for (int j = i + 1; j < p.size(); j++) {
                    int[] one = p.get(i);
                    int[] another = p.get(j);
                    if (mdist(one, another) <= 2 && bfs(one, another) <= 2) {
                        obey = false;
                        break;
                    }
                }
                if (!obey)
                    break;
            }
 
            answer[num] = obey ? 1 : 0;
        }
 
        return answer;
    }
 
    private int bfs(int[] src, int[] dest) {
        int[][] dist = new int[5][5];
        for (int i = 0; i < 5; i++)
            Arrays.fill(dist[i], -1);
 
        Queue<int[]> q = new LinkedList<>();
 
        dist[src[0]][src[1]] = 0;
        q.offer(new int[]{src[0], src[1]});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
 
            for (int dir = 0; dir < 4; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                
                if (nx == dest[0] && ny == dest[1])
                    return dist[curX][curY] + 1;
 
                if (OOB(nx, ny))
                    continue;
 
                if (dist[nx][ny] > -1 || room[nx][ny] == 'X')
                    continue;
 
                dist[nx][ny] = dist[curX][curY] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
 
        return Integer.MAX_VALUE;
    }
 
    //out of boundary
    private boolean OOB(int nx, int ny) {
        return nx < 0 || nx >= 5 || ny < 0 || ny >= 5;
    }
 
    //manhattan distance
    private int mdist(int[] one, int[] another) {
        return Math.abs(one[0] - another[0]) + Math.abs(one[1] - another[1]);
    }
}
