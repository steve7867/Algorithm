/**
 * 수 찾기
 * https://www.acmicpc.net/problem/1920
 */
package Baekjoon.Binary_Search;

import java.io.*;
import java.util.*;
 
public class Main_1920 {
    private static int[] arr;
    private static int n, m;
 
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
        for (int i = 0; i < m; i++)
            sb.append(binarySearch(Integer.parseInt(st.nextToken())))
                    .append("\n");
 
        System.out.println(sb);
    }
 
    private static int binarySearch(int target) {
        int st = 0, en = n - 1;
 
        while (st <= en) {
            int mid = (st + en) / 2;
            if (arr[mid] > target)
                en = mid - 1;
            else if (arr[mid] < target)
                st = mid + 1;
            else
                return 1;
        }
 
        return 0;
    }
}