package SWEA._9999._1;

import java.io.*;
import java.util.*;

class Solution {
    private static final int[][] peaks = new int[100_000][2];
    private static int L;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            init();
            input(br);

            sb.append('#')
                    .append(tc)
                    .append(' ')
                    .append(getMaxAdLen())
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void init() {
        l = r = coverLen = end = ret = 0;
        dq = new ArrayDeque<>();
    }

    private static int l, r;
    private static int coverLen;
    private static int end;
    private static int ret;
    private static Deque<Integer> dq;

    private static int getMaxAdLen() {
        while (r < n) {
            end = peaks[l][0] + L;

            if (end > peaks[r][0]) {
                include(r);
                r++;
                if (coverLen >= L)
                    return L;
            } else {
                coverLen -= dq.pollFirst();
                l++;

                if (end < peaks[r - 1][1]) {
                    coverLen -= dq.pollLast();
                    r--;
                }
            }
        }

        return ret;
    }

    private static void include(int r) {
        int unitCoverLen = getCoverLen(r, end);
        coverLen += unitCoverLen;
        ret = Math.max(ret, coverLen);
        dq.offerLast(unitCoverLen);
    }

    private static int getCoverLen(int i, int end) {
        if (end <= peaks[i][1])
            return end - peaks[i][0];

        return peaks[i][1] - peaks[i][0];
    }

    private static void input(BufferedReader br) throws IOException {
        L = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            peaks[i][0] = Integer.parseInt(st.nextToken());
            peaks[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}