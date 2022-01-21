/**
 * 강의실 배정
 * https://www.acmicpc.net/problem/11000
 */
package Baekjoon.Greedy._11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Pair> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
 
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
 
            list.add(new Pair(s, t));
        }
 
        Collections.sort(list);
 
        for (Pair pair : list) {
            if (pq.isEmpty())
                pq.offer(pair.t);
            else {
                int a = pq.peek();
                if (a > pair.s) {
                    pq.offer(pair.t);
                } else {
                    pq.poll();
                    pq.offer(pair.t);
                }
            }
        }
 
        System.out.println(pq.size());
    }
}
 
class Pair implements Comparable<Pair> {
    int s;
    int t;
 
    public Pair(int s, int t) {
        this.s = s;
        this.t = t;
    }
 
    @Override
    public int compareTo(Pair p) {
        if (this.s == p.s)
            return Integer.compare(this.t, p.t);
 
        return Integer.compare(this.s, p.s);
    }
}
