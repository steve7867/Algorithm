/**
 * 합이 0
 * https://www.acmicpc.net/problem/3151
 *
 * 문제 해설: https://entrydeveloper.tistory.com/420
 */
package Baekjoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3151 {
    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];

                int l = getLowerBound(-sum, j + 1, n);
                int u = getUpperBound(-sum, j + 1, n);

                ans += u - l;
            }
        }

        System.out.println(ans);
    }

    private static int getLowerBound(int target, int st, int en) {
        while (st < en) {
            int mid = (st + en) / 2;
            if (arr[mid] >= target)
                en = mid;
            else
                st = mid + 1;
        }

        return st;
    }

    private static int getUpperBound(int target, int st, int en) {
        while (st < en) {
            int mid = (st + en) / 2;
            if (arr[mid] > target)
                en = mid;
            else
                st = mid + 1;

        }

        return st;
    }
}