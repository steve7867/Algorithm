/**
 * 가장 긴 증가하는 부분 수열 5
 * https://www.acmicpc.net/problem/14003
 *
 * 문제 해설: https://entrydeveloper.tistory.com/548
 */
package Baekjoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14003 {
    private static int n;
    private static int[] arr;
    private static List<Integer> list;
    private static int[] p;

    public static void main(String[] args) throws IOException {
        input();
        findLIS();

        System.out.println(list.size());
        System.out.println(getLIS());
    }

    private static String getLIS() {
        List<Integer> lis = new ArrayList<>();
        int idx = list.size() - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (idx < 0)
                continue;

            if (p[i] == idx) {
                lis.add(arr[i]);
                idx--;
            }
        }
        Collections.reverse(lis);

        StringBuilder sb = new StringBuilder();
        for (Integer i : lis)
            sb.append(i).append(' ');

        return sb.toString();
    }

    private static void findLIS() {
        list = new ArrayList<>();
        p = new int[n];
        list.add(arr[0]);

        for (int i = 1; i < n; i++) {
            int last = list.get(list.size() - 1);
            if (arr[i] > last) {
                list.add(arr[i]);
                p[i] = list.size() - 1;
                continue;
            }

            int lb = getLowerBound(list, arr[i]);
            list.set(lb, arr[i]);
            p[i] = lb;
        }
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

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = stoi(st.nextToken());
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}