/**
 * 트리의 부모 찾기
 * https://www.acmicpc.net/problem/11725
 */
package Baekjoon.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main_11725 {
 
    private static int[] p;
    private static List<Integer>[] listArr;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int n = Integer.parseInt(br.readLine());
        p = new int[n + 1];
        p[1] = 1;
 
        listArr = new List[n + 1];
        for (int i = 0; i <= n; i++)
            listArr[i] = new ArrayList<>();
 
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
 
            if (p[a] > 0)
                process(a, b);
            else if (p[b] > 0)
                process(b, a);
            else {
                listArr[a].add(b);
                listArr[b].add(a);
            }
        }
 
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++)
            sb.append(p[i]).append('\n');
 
        System.out.println(sb);
    }
 
    private static void process(int parent, int child) {
        p[child] = parent;
 
        for (int grandChild : listArr[child]) {
            if (grandChild == parent)
                continue;
 
            process(child, grandChild);
        }
    }
}