/**
 * https://programmers.co.kr/learn/courses/30/lessons/43236
 */
package Programmers.Level4;

import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int lo = 1, hi = distance;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (check(mid, rocks, distance, n))
                lo = mid;
            else
                hi = mid - 1;
        }

        return lo;
    }

    private boolean check(int mid, int[] rocks, int distance, int n) {
        int cnt = 0;

        int prev = 0;
        for (int rock : rocks) {
            if (rock - prev < mid)
                cnt++;
            else
                prev = rock;
        }

        if (distance - prev < mid)
            cnt++;

        return cnt <= n;
    }
}