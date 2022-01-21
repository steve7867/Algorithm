/**
 * 과자 나눠주기
 * https://www.acmicpc.net/problem/16401
 *
 * 문제 해설: https://entrydeveloper.tistory.com/414
 */
package Baekjoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16401 {
    private static int m, n;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[n];

        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());

        Arrays.sort(arr);

        int st = 1, en = 1000000000;
        boolean isPossible = false;
        while (st < en) {
            int mid = (st + en + 1) / 2;
            if (check(mid)) {
                isPossible = true;
                st = mid;
            }
            else
                en = mid - 1;
        }

        if (isPossible)
            System.out.println(st);
        else
            System.out.println(0);
    }

    private static boolean check(int len) {
        int cnt = 0;
        for (int cookie : arr)
            cnt += cookie / len;

        return cnt >= m;
    }
}