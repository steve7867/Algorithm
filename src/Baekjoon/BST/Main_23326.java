/**
 * 홍익 투어리스트
 * https://www.acmicpc.net/problem/23326
 */
package Baekjoon.BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
 
public class Main_23326 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> ts = new TreeSet<>();
        boolean[] isFamous;
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
 
        isFamous = new boolean[n + 1];
        int size = 0;
 
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            char c = st.nextToken().charAt(0);
 
            if (c == '1') {
                ts.add(i);
                isFamous[i] = true;
                size++;
            }
        }
 
        StringBuilder sb = new StringBuilder();
        int cur = 1;
 
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
 
            String order = st.nextToken();
            if (order.equals("1")) {
                int x = Integer.parseInt(st.nextToken());
                if (isFamous[x]) {
                    ts.remove(x);
                    isFamous[x] = false;
                    size--;
                } else {
                    ts.add(x);
                    isFamous[x] = true;
                    size++;
                }
            } else if (order.equals("2")) {
                int x = Integer.parseInt(st.nextToken());
                cur = (cur + x) % n;
                if (cur == 0)
                    cur = n;
            } else {
                if (size == 0) {
                    sb.append(-1).append('\n');
                    continue;
                }
 
                if (isFamous[cur]) {
                    sb.append(0).append('\n');
                    continue;
                }
 
                Integer upper = ts.ceiling(cur);
                if (upper != null) {
                    sb.append(upper - cur).append('\n');
                    continue;
                }
 
                Integer lower = ts.ceiling(1);
                if (lower != null)
                    sb.append(n - cur + lower).append('\n');
 
            }
        }
 
        System.out.println(sb);
    }
}
