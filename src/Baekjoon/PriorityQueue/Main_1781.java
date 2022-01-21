/**
 * 컵라면
 * https://www.acmicpc.net/problem/1781
 */
package Baekjoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Work[] arr = new Work[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());

            arr[i] = new Work(deadLine, ramen);
        }

        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(arr[i].ramen);
            while (pq.size() > arr[i].deadLine)
                pq.poll();
        }

        int ans = 0;
        while (!pq.isEmpty())
            ans += pq.poll();

        System.out.println(ans);
    }
}

class Work implements Comparable<Work> {
    int deadLine;
    int ramen;

    public Work(int deadLine, int ramen) {
        this.deadLine = deadLine;
        this.ramen = ramen;
    }

    @Override
    public int compareTo(Work o) {
        if (this.deadLine == o.deadLine)
            return Integer.compare(this.ramen, o.ramen);

        return Integer.compare(this.deadLine, o.deadLine);
    }

}