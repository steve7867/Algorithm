/**
 * 가운데를 말해요
 * https://www.acmicpc.net/problem/1655
 * 문제 해설: https://entrydeveloper.tistory.com/479
 */
package Baekjoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        maxHeap.offer(Integer.parseInt(br.readLine()));
        sb.append(maxHeap.peek()).append('\n');

        for (int i = 0; i < n - 1; i++) {
            int x = Integer.parseInt(br.readLine());

            int mid = maxHeap.peek();
            if (x <= mid)
                maxHeap.offer(x);
            else
                minHeap.offer(x);

            int diff = maxHeap.size() - minHeap.size();
            if (diff == 2)
                minHeap.offer(maxHeap.poll());
            else if (diff < 0)
                maxHeap.offer(minHeap.poll());

            sb.append(maxHeap.peek()).append('\n');
        }

        System.out.println(sb);
    }
}