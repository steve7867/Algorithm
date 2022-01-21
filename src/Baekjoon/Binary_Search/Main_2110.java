/**
 * 공유기 설치
 * https://www.acmicpc.net/problem/2110
 *
 * 문제 해설: https://entrydeveloper.tistory.com/422
 */
package Baekjoon.Binary_Search;

import java.io.*;
import java.util.*;

public class Main_2110 {
    private static int n, c;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int ans = 0;

        int st = 1;
        int en = arr[n - 1] - arr[0];

        while (st <= en) {
            int mid = (st + en) / 2;
            int anchor = arr[0];
            int cnt = 1;

            for (int i = 1; i < n; i++) {
                int interval = arr[i] - anchor;

                if (interval >= mid) {
                    cnt++;
                    anchor = arr[i];
                }
            }

            if (cnt >= c) {
                ans = mid;
                st = mid + 1;
            } else
                en = mid - 1;
        }

        System.out.println(ans);
    }
}