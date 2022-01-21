/**
 * 입국심사
 * https://programmers.co.kr/learn/courses/30/lessons/43238?language=java
 *
 * 문제 해설: https://entrydeveloper.tistory.com/550
 */
package Programmers.입국심사;

class Solution {
    public long solution(int n, int[] times) {
        long lo = 1, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (check(mid, times, n))
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }

    public boolean check(long limit, int[] times, int n) {
        long sum = 0L;
        for (int t : times) {
            sum += limit / t;
            if (sum >= n)
                return true;
        }

        return sum >= n;
    }
}