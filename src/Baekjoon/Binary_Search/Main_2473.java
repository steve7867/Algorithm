/**
 * 세 용액
 * https://www.acmicpc.net/problem/2473
 */
package Baekjoon.Binary_Search;

import java.io.*;
import java.util.*;
 
public class Main_2473 {
    private static int n;
    private static int[] arr;
    private static int[] ans = new int[3];
    private static long diff = Long.MAX_VALUE;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
 
        Arrays.sort(arr);
 
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int idx = getLowerBound(j + 1, n, -(arr[i] + arr[j]));
 
                list.add(idx - 1);
                list.add(idx);
                list.add(idx + 1);
 
                for (int k : list) {
                    if (k < 0 || k >= n || k == j)
                        continue;
 
                    long sum = Math.abs((long) arr[i] + arr[j] + arr[k]);
 
                    if (diff > sum) {
                        diff = sum;
 
                        ans[0] = arr[i];
                        ans[1] = arr[j];
                        ans[2] = arr[k];
                    }
                }
 
                list.clear();
            }
        }
 
        Arrays.sort(ans);
 
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
 
    private static int getLowerBound(int st, int en, int target) {
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
