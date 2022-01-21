/**
 * 두 배열의 합
 * https://www.acmicpc.net/problem/2143
 */
package Baekjoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_2143 {
 
    private static int t;
    private static int n;
    private static int m;
    private static int[] a;
    private static int[] b;
    private static int[] subA;
    private static int[] subB;
 
    public static void main(String[] args) throws IOException {
        input();
        makePrefixSum();
        makeSubArr();
        System.out.println(getAns());
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
 
    private static int getUpperBound(int[] arr, int target) {
        int st = 0, en = arr.length;
        while (st < en) {
            int mid = (st + en) / 2;
            if (arr[mid] > target)
                en = mid;
            else
                st = mid + 1;
        }
 
        return st;
    }
 
    private static long getAns() {
        long ans = 0;
        for (int i : subA) {
            int lowerBound = getLowerBound(subB, t - i);
            int upperBound = getUpperBound(subB, t - i);
            ans += upperBound - lowerBound;
        }
 
        return ans;
    }
 
    private static void makeSubArr() {
        subA = new int[(n + 1) * n / 2];
        int idx = 0;
        for (int i = n; i >= 0; i--)
            for (int j = 0; j < i; j++)
                subA[idx++] = a[i] - a[j];
 
        Arrays.sort(subA);
 
        subB = new int[(m + 1) * m / 2];
        idx = 0;
        for (int i = m; i >= 0; i--)
            for (int j = 0; j < i; j++)
                subB[idx++] = b[i] - b[j];
 
        Arrays.sort(subB);
    }
 
    private static void makePrefixSum() {
        for (int i = 1; i <= n; i++)
            a[i] += a[i - 1];
 
        for (int i = 1; i <= m; i++)
            b[i] += b[i - 1];
    }
 
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        t = stoi(br.readLine());
        n = stoi(br.readLine());
        a = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            a[i] = stoi(st.nextToken());
 
        m = stoi(br.readLine());
        b = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++)
            b[i] = stoi(st.nextToken());
    }
 
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
