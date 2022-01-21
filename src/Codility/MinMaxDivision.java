/**
 * MinMaxDivision
 * https://app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division/
 */
package Codility;

class MinMaxDivision {
    public int solution(int K, int M, int[] A) {
        long st = 0, en = 100000 * 100000L;
        while (st < en) {
            long mid = st + (en - st) / 2;
            int n = getMax(K, mid, A);
            if (n <= mid)
                en = mid;
            else
                st = mid + 1;
        }
 
        return (int) st;
    }
 
    private int getMax(int k, long threshold, int[] arr) {
        int sum = 0;
        int cnt = 0;
        int ret = 0;
 
        for (int i : arr) {
            if (cnt >= k - 1) {
                sum += i;
                continue;
            }
 
            if (sum + i > threshold) {
                cnt++;
                ret = Math.max(ret, sum);
                sum = i;
            } else {
                sum += i;
            }
        }
 
        ret = Math.max(ret, sum);
 
        return ret;
    }
}