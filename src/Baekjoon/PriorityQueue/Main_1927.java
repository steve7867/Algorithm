/**
 * 최소 힙
 * https://www.acmicpc.net/problem/1927
 */
package Baekjoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
 
public class Main_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
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