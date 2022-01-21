/**
 * 카드 합체 놀이
 * https://www.acmicpc.net/problem/15903
 */
package Baekjoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
        while (n-- > 0)
            pq.offer(Long.parseLong(st.nextToken()));
 
        while (m-- > 0) {
            long temp = pq.poll() + pq.poll();
            pq.offer(temp);
            pq.offer(temp);
        }
 
        long sum = 0;
        while (!pq.isEmpty())
            sum += pq.poll();
 
        System.out.println(sum);
    }
}
