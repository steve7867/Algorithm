/**
 * https://programmers.co.kr/learn/courses/30/lessons/60059
 */
package Kakao.Blind_2020.자물쇠와_열쇠;

class Solution {
    int m, n;
    public boolean solution(int[][] key, int[][] lock) {
        m = key.length;
        n = lock.length;

        for (int r = 0; r < 4; r++) {
            int[][] rotated = rotate(key, r);

            if (canOpen(rotated, lock))
                return true;
        }

        return false;
    }

    private boolean canOpen(int[][] rotated, int[][] lock) {
        for (int i = 0; i < 20 + n; i++) {
            for (int j = 0; j < 20 + n; j++) {
                int[][] copiedLock = new int[60][60];
                for (int r = 0; r < n; r++)
                    System.arraycopy(lock[r], 0, copiedLock[20 + r], 20, n);

                for (int r = 0; r < m; r++) {
                    for (int c = 0; c < m; c++)
                        copiedLock[i + r][j + c] += rotated[r][c];
                }

                if (check(copiedLock))
                    return true;
            }
        }

        return false;
    }

    private boolean check(int[][] copiedLock) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (copiedLock[20 + i][20 + j] == 0
                        || copiedLock[20 + i][20 + j] == 2)
                    return false;

        return true;
    }


    private int[][] rotate(int[][] key, int r) {
        int[][] rotated = new int[m][m];
        if (r == 0) {
            for (int i = 0; i < m; i++)
                System.arraycopy(key[i], 0, rotated[i], 0, m);

            return rotated;
        }

        // 오른쪽 회전
        if (r == 1) {
            for (int i = 0; i < m; i++)
                for (int j = 0; j < m; j++)
                    rotated[j][m - 1 - i] = key[i][j];

            return rotated;
        }

        // 180도 회전
        if (r == 2) {
            for (int i = 0; i < m; i++)
                for (int j = 0; j < m; j++)
                    rotated[m - 1 - i][m - 1 - j] = key[i][j];

            return rotated;
        }

        if (r == 3) {
            for (int i = 0; i < m; i++)
                for (int j = 0; j < m; j++)
                    rotated[m - 1 - j][i] = key[i][j];

            return rotated;
        }

        return rotated;
    }
}