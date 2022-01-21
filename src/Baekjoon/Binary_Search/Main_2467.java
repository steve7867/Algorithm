/**
 * 용액
 * https://www.acmicpc.net/problem/2467
 */
package Baekjoon.Binary_Search;

import java.io.*;
import java.util.*;
 
public class Main_2467 {
    private static int n;
    private static int[] arr;
    private static int[] ans = new int[2];
    private static int diff = Integer.MAX_VALUE;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
 
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int idx = getLowerBound(-arr[i]);
            list.add(idx - 1);
            list.add(idx);
            list.add(idx + 1);
 
            for (int j : list) {
                if (j < 0 || j >= n || i == j)
                    continue;
 
                int sum = Math.abs(arr[i] + arr[j]);
                if (diff > sum) {
                    diff = sum;
                    ans[0] = arr[i];
                    ans[1] = arr[j];
                }
            }
 
            list.clear();
        }
 
        Arrays.sort(ans);
 
        System.out.println(ans[0] + " " + ans[1]);
    }
 
    private static int getLowerBound(int target) {
        int st = 0, en = n;
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