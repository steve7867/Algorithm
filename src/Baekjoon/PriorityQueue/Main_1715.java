/**
 * 카드 정렬하기
 * https://www.acmicpc.net/problem/1715
 * 허프만 코딩 방식이다.
 */
package Baekjoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
 
public class Main_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
 
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }
 
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            pq.offer(x);
        }
 
        int answer = 0;
        while (!pq.isEmpty() && pq.size() != 1) {
            int temp = pq.poll() + pq.poll();
            answer += temp;
            pq.offer(temp);
        }
 
        System.out.println(answer);
    }
}