/**
 * 숫자 카드
 * https://www.acmicpc.net/problem/10815
 */
package Baekjoon.Binary_Search;

import java.io.*;
import java.util.*;
 
public class Main_10815 {
    private static int n, m;
    private static int[] arr;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
 
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
 
        Arrays.sort(arr);
 
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
 
        for (int i = 0; i < m; i++)
            sb.append(binarySearch(Integer.parseInt(st.nextToken())) >= 0 ? 1 : 0).append(' ');
 
        System.out.println(sb);
    }
 
    private static int binarySearch(int target) {
        int st = 0, en = arr.length - 1;
 
        while (st <= en) {
            int mid = (st + en) / 2;
            if (arr[mid] > target)
                en = mid - 1;
            else if (arr[mid] < target)
                st = mid + 1;
            else
                return mid;
        }
 
        return -1;
    }
}
