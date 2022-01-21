/**
 * 용액 합성하기
 * https://www.acmicpc.net/problem/14921
 *
 * 문제 해설: https://entrydeveloper.tistory.com/542
 */
package Baekjoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());

        int ans = arr[0] + arr[1];
        for (int i = 0 ; i < n; i++) {
            int lbIdx = getLowerBound(arr, -arr[i]);
            int[] targets = {lbIdx, lbIdx - 1};
            for (int target : targets) {
                if (target == i || (target == n || target == -1))
                    continue;

                int sum = arr[i] + arr[target];
                if (Math.abs(ans) > Math.abs(sum))
                    ans = sum;
            }

            if (ans == 0)
                break;
        }

        System.out.println(ans);
    }

    private static int getLowerBound(int[] arr, int target) {
        int st = 0, en = arr.length;
        while (st < en) {
            int mid = (st + en) / 2;
            if (arr[mid] >= target)
                en = mid;
            else
                st = mid + 1;
        }

        return st;
    }
}