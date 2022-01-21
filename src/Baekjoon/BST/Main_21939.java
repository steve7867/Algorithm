/**
 * 문제 추천 시스템 Version 1
 * https://www.acmicpc.net/problem/21939
 */
package Baekjoon.BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
 
public class Main_21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Problem> ts = new TreeSet<>();
        Problem[] arr = new Problem[100001];
 
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
 
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
 
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
 
            Problem problem = new Problem(p, l);
 
            arr[p] = problem;
            ts.add(problem);
        }
 
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("recommend")) {
                sb.append(st.nextToken().equals("-1") ? ts.first().p : ts.last().p)
                        .append('\n');
            } else if (order.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
 
                Problem problem = new Problem(p, l);
 
                arr[p] = problem;
                ts.add(problem);
            } else {
                int num = Integer.parseInt(st.nextToken());
                Problem target = arr[num];
                ts.remove(target);
                arr[num] = null;
            }
        }
 
        System.out.println(sb);
    }
}
 
class Problem implements Comparable<Problem> {
    int p;
    int l;
 
    public Problem(int p, int l) {
        this.p = p;
        this.l = l;
    }
 
    @Override
    public int compareTo(Problem o) {
        if (this.l == o.l)
            return Integer.compare(this.p, o.p);
 
        return Integer.compare(this.l, o.l);
    }
}
