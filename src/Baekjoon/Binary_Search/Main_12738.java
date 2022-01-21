/**
 * 가장 긴 증가하는 부분 수열 3
 * https://www.acmicpc.net/problem/12738
 *
 * 문제 해설: https://entrydeveloper.tistory.com/549
 */
package Baekjoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_12738 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        list.add(Integer.parseInt(st.nextToken()));

        for (int i = 1; i < n; i++) {
            int last = list.get(list.size() - 1);
            int cur = Integer.parseInt(st.nextToken());

            if (cur > last) {
                list.add(cur);
                continue;
            }

            int lb = getLowerBound(list, cur);
            list.set(lb, cur);
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

}