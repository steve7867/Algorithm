/**
 * 가장 긴 증가하는 부분 수열 2
 * https://www.acmicpc.net/problem/12015
 *
 * 문제 해설: https://entrydeveloper.tistory.com/547
 */
package Baekjoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = stoi(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < n; i++) {
            int last = list.get(list.size() - 1);
            if (last < arr[i]) {
                list.add(arr[i]);
                continue;
            }

            int lb = getLowerBound(list, arr[i]);
            list.set(lb, arr[i]);
        }

        System.out.println(list.size());
    }

    private static int getLowerBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size() - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) >= target)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}