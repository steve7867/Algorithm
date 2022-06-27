package Baekjoon.Greedy;

import java.util.*;
import java.io.*;

public class Main_1339 {
    private static int n;
    private static String[] words;
    private static final Map<Character, Integer> map = new HashMap<>();
    private static final PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] arsgs) throws IOException {
        init();
        System.out.println(getSum());
    }

    private static int getSum() {
        int sum = 0;
        int m = 9;
        while (!pq.isEmpty()) {
            int val = pq.poll();
            sum += val * m;
            m--;
        }

        return sum;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        words = new String[n];

        for (int i = 0; i < n; i++){
            words[i] = br.readLine();
            process(words[i]);
        }

        for (int val : map.values())
            pq.offer(val);
    }

    private static void process(String word) {
        int len = word.length();
        int val = (int) Math.pow(10, len - 1);

        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + val);
            val /= 10;
        }
    }
}