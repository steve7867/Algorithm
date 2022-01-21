/**
 * List of Unique Numbers
 * https://www.acmicpc.net/problem/13144
 */
package Baekjoon.Two_Pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();

        int r = 0;
        long ans = 0;
        for (int l = 0; l < n; set.remove(arr[l]), l++) {
            while (r < n && !set.contains(arr[r])) {
                ans++; // arr[r]만 선택하는 경우
                ans += set.size(); // arr[r]과 arr[i]를 선택하는 경우(p < i < r, arr[p] = arr[r])
                set.add(arr[r]);
                r++;
            }
        }

        System.out.println(ans);
    }
}