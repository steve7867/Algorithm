/**
 * 문제 해설: https://entrydeveloper.tistory.com/563
 */
package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
import static java.lang.Math.max;
 
public class Solution_8935 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    private static final int[][][] dp = new int[3002][102][101];
    private static final int[] A = new int[3001];
    private static final int[] B = new int[101];
    private static int N, M;
 
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
 
        int TC = stoi();
        for (int tc = 1; tc <= TC; tc++) {
            input();
            Arrays.sort(B, 1, M + 1);
            reverse();
 
            int ans = getMax(1, 1, 1, M);
            sb.append('#')
                    .append(tc)
                    .append(' ')
                    .append(ans)
                    .append('\n');
 
            dpReset();
        }
 
        System.out.print(sb);
    }
 
    private static void reverse() {
        int l = 1, r = M;
        while (l < r) {
            int temp = B[l];
            B[l] = B[r];
            B[r] = temp;
 
            l++;
            r--;
        }
    }
 
    private static int stoi() throws IOException {
        return Integer.parseInt(br.readLine());
    }
 
    private static void input() throws IOException {
        N = stoi();
        for (int i = 1; i <= N; i++)
            A[i] = stoi();
 
        M = stoi();
        for (int i = 1; i <= M; i++)
            B[i] = stoi();
    }
 
    private static void dpReset() {
        for (int n = 0; n <= N + 1; n++)
            for (int m1 = 0; m1 <= M + 1; m1++)
                for (int m2 = 0; m2 <= M; m2++)
                    dp[n][m1][m2] = 0;
    }
 
    /**
     * @param idx (1-indexed) idx번째 자리에 어떤 과자를 놓을지
     *            idx번째의 과자를 선택할 수도 있고, 스킵할 수도 있다.
     * @param n N개의 과자 중 n번째 과자를 포인팅
     * @param s M개의 과자 중 s번째 과자를 포인팅(선택할 과자, 큰 과자 우선)
     * @param e M개의 과자 중 e번째 과자를 포인팅(버릴 과자, 작은 과자 우선)
     * @return 완전 탐색 후 가장 큰 값 return
     */
    private static int getMax(int idx, int n, int s, int e) {
        if (idx > N + M)
            return 0;
 
        if (dp[n][s][e] != 0)
            return dp[n][s][e];
 
        int val = 0;
        if (n + 1 <= N)
            // 1.A[n](선택), A[n+1](버림)
            val = max(val, A[n] + getMax(idx + 2, n + 2, s, e));
 
        if (n <= N && (s <= e || idx == N + M))
            // 2.A[n](선택), B[e](버림)
            val = max(val, A[n] + getMax(idx + 2, n + 1, s, e - 1));
 
        if (s <= e && (n <= N || idx == N + M))
            // 3.B[s](선택), A[n](버림)
            val = max(val, B[s] + getMax(idx + 2, n + 1, s + 1, e));
 
        if (s < e)
            // 4.B[s](선택), B[e](버림)
            val = max(val, B[s] + getMax(idx + 2, n, s + 1, e - 1));
 
        if (n <= N)
            // 5. A[n] 을 안 고름
            val = max(val, getMax(idx + 1, n + 1, s, e));
 
        if (s <= e)
            //6. B[e]
            val = max(val, getMax(idx + 1, n, s, e - 1));
 
        return dp[n][s][e] = val;
    }
 
}