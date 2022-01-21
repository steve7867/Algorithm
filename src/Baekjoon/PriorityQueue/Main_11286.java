/**
 * 절댓값 힙
 * https://www.acmicpc.net/problem/11286
 */
package Baekjoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
 
public class Main_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int absA = Math.abs(a);
                int absB = Math.abs(b);
 
                if (absA == absB)
                    return Integer.compare(a, b);
 
                return Integer.compare(absA, absB);
            }
        });
 
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