/**
 * 좋다
 * https://www.acmicpc.net/problem/1253
 */
package Baekjoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n <= 2) {
            System.out.println(0);
            return;
        }
 
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
 
        Arrays.sort(arr);
 
        int cnt = 0;
        for (int a = 0; a < n; a++) {
            boolean exist = false;
            for (int b = 0; b < n; b++) {
                if (a == b)
                    continue;
 
                int target = arr[a] - arr[b];
 
                int lbIdx = getLowerBound(arr, target);
                int ubIdx = getUpperBound(arr, target);
 
                for (int i = lbIdx; i < ubIdx; i++) {
                    if (i != a && i != b) {
                        exist = true;
                        break;
                    }
                }
 
                if (exist) {
                    cnt++;
                    break;
                }
            }
        }
 
        System.out.println(cnt);
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
 
}