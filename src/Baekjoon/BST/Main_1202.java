/**
 * 보석 도둑
 * https://www.acmicpc.net/problem/1202
 */
package Baekjoon.BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
 
public class Main_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        PriorityQueue<Jewelry> pq = new PriorityQueue<>();
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
 
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
 
            pq.offer(new Jewelry(weight, value));
        }
 
        for (int i = 0; i < k; i++) {
            int weight = Integer.parseInt(br.readLine());
            tm.put(weight, tm.getOrDefault(weight, 0) + 1);
        }
 
        long answer = 0;
        while (!tm.isEmpty() && !pq.isEmpty()) {
            Jewelry j = pq.poll();
 
            Integer bag = tm.ceilingKey(j.weight);
            if (bag == null)
                continue;
 
            answer += j.value;
 
            int quantity = tm.get(bag);
            if (quantity == 1)
                tm.remove(bag);
            else
                tm.put(bag, quantity - 1);
        }
 
        System.out.println(answer);
    }
}
 
class Jewelry implements Comparable<Jewelry> {
    int weight;
    int value;
 
    public Jewelry(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
 
    @Override
    public int compareTo(Jewelry o) {
        if (this.value == o.value)
            return Integer.compare(this.weight, o.weight);
 
        return -Integer.compare(this.value, o.value);
    }
}
 
class Bag implements Comparable<Bag> {
    int weight;
 
    public Bag(int weight) {
        this.weight = weight;
    }
 
    @Override
    public int compareTo(Bag o) {
        return -Integer.compare(this.weight, o.weight);
    }
}