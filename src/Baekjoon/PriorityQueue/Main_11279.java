/**
 * 최대 힙
 * https://www.acmicpc.net/problem/11279
 */
package Baekjoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
 
        int n = Integer.parseInt(br.readLine());
 
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
 
            if (x == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
                continue;
            }
 
            pq.offer(x);
        }
 
        System.out.println(sb);
    }
}