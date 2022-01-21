/**
 * 예산
 * https://www.acmicpc.net/problem/2512
 */
package Baekjoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.min;
 
public class Main_2512 {
 
    private static int m;
    private static int max;
    private static int[] arr;
 
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(getMaxBudget());
    }
 
    private static int getMaxBudget() {
        int lo = 1, hi = max;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (isFeasible(mid))
                lo = mid;
            else
                hi = mid - 1;
        }
        return lo;
    }
 
    private static boolean isFeasible(int ceil) {
        int sum = 0;
        for (int i : arr)
            sum += min(i, ceil);
 
        return sum <= m;
    }
 
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = stoi(st.nextToken());
            max = Math.max(max, arr[i]);
        }
 
        m = stoi(br.readLine());
    }
 
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
