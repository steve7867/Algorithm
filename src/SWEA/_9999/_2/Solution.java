/**
 * 9999. 광고 시간 정하기
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXIvPBC6aqUDFAXR&categoryId=AXIvPBC6aqUDFAXR&categoryType=CODE&problemTitle=9999&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */
package SWEA._9999._2;

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[][] peaks = new int[100_000][2];
        int L, N;
        int result, end, sIdx, eIdx, time, add, i;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            L = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());

            for (i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                peaks[i][0] = Integer.parseInt(st.nextToken());
                peaks[i][1] = Integer.parseInt(st.nextToken());
            }
            result = 0;
            time = 0;
            sIdx = 0;
            eIdx = 0;

            while (eIdx < N) {
                end = peaks[sIdx][0] + L;

                while (eIdx < N && peaks[eIdx][1] <= end) {
                    time += peaks[eIdx][1] - peaks[eIdx][0];
                    eIdx++;
                }

                add = 0;
                if (eIdx < N && peaks[eIdx][0] < end)
                    add = end - peaks[eIdx][0];

                result = Math.max(result, (time + add));
                if (result == L)
                    break;
                time -= (end < peaks[sIdx][1]) ? L : (peaks[sIdx][1] - peaks[sIdx][0]);
                sIdx++;
                eIdx = Math.max(sIdx, eIdx);
            }

            sb.append(String.format("#%d %d\n", tc, result));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}