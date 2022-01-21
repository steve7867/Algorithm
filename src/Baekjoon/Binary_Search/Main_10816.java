/**
 * 숫자 카드 2
 * https://www.acmicpc.net/problem/10816
 */
package Baekjoon.Binary_Search;

import java.io.*;
import java.util.*;
 
public class Main_10816 {
    private static int n, m;
    private static int[] arr;
 
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
 
        Arrays.sort(arr);
 
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int input = Integer.parseInt(st.nextToken());
            int lowerIdx = getLowerIdx(input);
            int upperIdx = getUpperIdx(input);
 
            sb.append(upperIdx - lowerIdx).append(' ');
        }
 
        System.out.println(sb);
    }
 
    private static int getLowerIdx(int target) {
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
 
    private static int getUpperIdx(int target) {
        int st = 0, en = n;
 
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