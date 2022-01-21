/**
 * 집합의 표현
 * https://www.acmicpc.net/problem/1717
 */
package Baekjoon.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_1717 {
    private static int[] p;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
 
        p = new int[n + 1];
        for (int i = 0; i <= n; i++)
            p[i] = i;
 
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
 
            if (op == 0)
                union(a, b);
            else
                sb.append(find(a) == find(b) ? "YES" : "NO").append('\n');
        }
 
        System.out.println(sb);
    }
 
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
 
        p[b] = a;
    }
 
    private static int find(int i) {
        if (i != p[i])
            p[i] = find(p[i]);
 
        return p[i];
    }
}
