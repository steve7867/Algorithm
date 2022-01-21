/**
 * 이중 우선순위 큐
 * https://www.acmicpc.net/problem/7662
 */
package Baekjoon.BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
 
public class Main_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
 
        while (t-- > 0) {
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
 
            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int i = Integer.parseInt(st.nextToken());
 
                if (op.equals("I")) {
                    tm.put(i, tm.getOrDefault(i, 0) + 1);
                } else if (!tm.isEmpty()) {
                    int target = (i == 1) ? tm.lastKey() : tm.firstKey();
                    int num = tm.get(target);
 
                    if (num == 1)
                        tm.remove(target);
                    else
                        tm.put(target, num - 1);
                }
            }
 
            if (tm.isEmpty())
                sb.append("EMPTY").append('\n');
            else
                sb.append(tm.lastKey()).append(' ').append(tm.firstKey()).append('\n');
        }
 
        System.out.println(sb);
    }
}

//우선순위 큐 2개를 활용한 풀이
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int t = Integer.parseInt(br.readLine());
//
//        while (t-- > 0) {
//            Map<Integer, Integer> map = new HashMap<>();
//            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//
//            int k = Integer.parseInt(br.readLine());
//
//            while (k-- > 0) {
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                String op = st.nextToken();
//                int i = Integer.parseInt(st.nextToken());
//
//                if (op.equals("I")) {
//                    map.put(i, map.getOrDefault(i, 0) + 1);
//                    maxHeap.offer(i);
//                    minHeap.offer(i);
//                } else if (!map.isEmpty()) {
//                    PriorityQueue<Integer> pq = (i == 1) ? maxHeap : minHeap;
//
//                    removeMap(pq, map);
//                }
//            }
//
//            if (map.isEmpty())
//                sb.append("EMPTY").append('\n');
//            else {
//                int i = removeMap(maxHeap, map);
//                sb.append(i)
//                        .append(' ')
//                        .append(map.isEmpty()? i : removeMap(minHeap, map))
//                        .append('\n');
//            }
//        }
//
//        System.out.println(sb);
//    }
//
//    private static int removeMap(PriorityQueue<Integer> pq, Map<Integer, Integer> map) {
//        int num;
//        while (true) {
//            num = pq.poll();
//
//            int cnt = map.getOrDefault(num, 0);
//            if (cnt == 0)
//                continue;
//
//            if (cnt == 1)
//                map.remove(num);
//            else
//                map.put(num, cnt - 1);
//
//            break;
//        }
//
//        return num;
//    }
//}