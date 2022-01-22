/**
 * ABCDE
 * https://www.acmicpc.net/problem/13023
 */
package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main_13023 {
    static ArrayList<Integer>[] a;
    static boolean[] visited;
    static boolean exist;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
 
        a = new ArrayList[n];
        visited = new boolean[n];
 
        for (int i = 0; i < n; i++)
            a[i] = new ArrayList<>();
 
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
 
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
 
            a[u].add(v);
            a[v].add(u);
        }
 
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            backtrack(i, 1);
            if (exist)
                break;
 
            visited[i] = false;
        }
 
        System.out.println(exist ? 1 : 0);
    }
 
    private static void backtrack(int cur, int idx) {
        if (idx == 5) {
            exist = true;
            return;
        }
 
        for (int i : a[cur]) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(i, idx + 1);
                if (exist)
                    return;
                visited[i] = false;
            }
        }
    }
}
