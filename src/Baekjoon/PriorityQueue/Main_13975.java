/**
 * 파일 합치기 3
 * https://www.acmicpc.net/problem/13975
 */
package Baekjoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main_13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
 
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (k-- > 0)
                pq.offer(Long.parseLong(st.nextToken()));
 
            long sum = 0;
            while (!pq.isEmpty() && pq.size() != 1) {
                long temp = pq.poll() + pq.poll();
                sum += temp;
                pq.offer(temp);
            }
 
            sb.append(sum).append('\n');
            pq.clear();
        }
 
        System.out.println(sb);
    }
}
