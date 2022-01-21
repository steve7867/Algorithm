/**
 *https://programmers.co.kr/learn/courses/30/lessons/60061
 */
package Kakao.Blind_2020.기둥과_보_설치;

class Solution {
    static final int POLL = 0;
    static final int BO = 1;
    static final int REMOVE = 0;
    static final int INSERT = 1;

    int n;
    boolean[][][] map;

    public int[][] solution(int N, int[][] build_frame) {
        int n = N;
        map = new boolean[n + 2][n + 2][2];
        int cnt = 0;

        for (int[] order : build_frame) {
            int x = order[0];
            int y = order[1];
            int a = order[2];
            int b = order[3];

            if (b == INSERT && a == POLL) {
                if (checkPoll(x, y)) {
                    map[x][y][POLL] = true;
                    cnt++;
                }
            }

            if (b == INSERT && a == BO) {
                if (checkBo(x, y)) {
                    map[x][y][BO] = true;
                    cnt++;
                }
            }

            if (b == REMOVE && a == POLL) {
                map[x][y][POLL] = false;
                if (!canRemove(x, y)) {
                    map[x][y][POLL] = true;
                    continue;
                }
                cnt--;
            }

            if (b == REMOVE && a == BO) {
                map[x][y][BO] = false;
                if (!canRemove(x, y)) {
                    map[x][y][BO] = true;
                    continue;
                }
                cnt--;
            }
        }


        int[][] ans = new int[cnt][3];
        cnt = 0;
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (map[x][y][POLL]) {
                    ans[cnt][0] = x;
                    ans[cnt][1] = y;
                    ans[cnt][2] = POLL;
                    cnt++;
                }

                if (map[x][y][BO]) {
                    ans[cnt][0] = x;
                    ans[cnt][1] = y;
                    ans[cnt][2] = BO;
                    cnt++;
                }
            }
        }

        return ans;
    }

    private boolean canRemove(int x, int y) {
        for (int i = Math.max(x - 1, 0); i <= x + 1; i++) {
            for (int j = y; j <= y + 1; j++) {
                if (map[i][j][POLL] && checkPoll(i, j) == false)
                    return false;
                if (map[i][j][BO] && checkBo(i, j) == false)
                    return false;
            }
        }
        return true;
    }

    private boolean checkBo(int x, int y) {
        // 양 옆에 보가 있는지
        if ((x - 1 >= 0 && map[x - 1][y][BO]) && map[x + 1][y][BO])
            return true;

        // 바로 밑에서 기둥이 받치고 있는지
        if (map[x][y - 1][POLL])
            return true;

        // 오른쪽 밑에서 기둥이 받치고 있는지
        if (map[x + 1][y - 1][POLL])
            return true;

        return false;
    }

    private boolean checkPoll(int x, int y) {
        //바닥이면
        if (y == 0)
            return true;
        // 기둥이 받치고 있는지
        if (map[x][y - 1][POLL])
            return true;

        // 보가 받치고 있는지
        if ((x - 1 >= 0 && map[x - 1][y][BO]) || map[x][y][BO])
            return true;

        return false;
    }
}