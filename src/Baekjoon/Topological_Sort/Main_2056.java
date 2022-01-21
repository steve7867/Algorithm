/**
 * 작업
 * https://www.acmicpc.net/problem/2056
 */
package Baekjoon.Topological_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main_2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int n = Integer.parseInt(br.readLine());
        int[] workingTime = new int[n + 1];
        for (int a = 1; a <= n; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int t = Integer.parseInt(st.nextToken());
            workingTime[a] = t;
 
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                int b = Integer.parseInt(st.nextToken());
                workingTime[a] = Math.max(workingTime[a], workingTime[b] + t);
            }
        }
 
        int ans = 0;
        for (int i = 1; i <= n; i++)
            ans = Math.max(ans, workingTime[i]);
 
        System.out.println(ans);
    }
 
}
