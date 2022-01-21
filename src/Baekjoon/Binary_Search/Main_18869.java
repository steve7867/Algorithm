/**
 * 멀티버스 Ⅱ
 * https://www.acmicpc.net/problem/18869
 *
 * 좌표 압축을 이용해 풀어야 한다.
 * 브루트 포스하게 풀면 시간 소모가 너무 크다.
 */
package Baekjoon.Binary_Search;

import java.io.*;
import java.util.*;
 
public class Main_18869 {
    private static int m, n;
    private static int[][] arr, sorted;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
 
        arr = new int[m][n];
        sorted = new int[m][n];
 
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
 
            System.arraycopy(arr[i], 0, sorted[i], 0, n);
            Arrays.sort(sorted[i]);
        }
 
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++)
                sb.append(Arrays.binarySearch(sorted[i], arr[i][j])).append(' ');
 
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
 
        int ans = 0;
        for (int val : map.values())
            ans += sumSequence(val);
 
        System.out.println(ans);
    }
 
    public static int sumSequence(int val) {
        return val * (val - 1) / 2;
    }
}