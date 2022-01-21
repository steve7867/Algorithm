/**
 * 이진 검색 트리
 * https://www.acmicpc.net/problem/1539
 * 문제 해설: https://entrydeveloper.tistory.com/491
 */
package Baekjoon.BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main_1539 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());
        long answer = 0;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (map.isEmpty()) {
                map.put(x, 1);
                answer += 1;
                continue;
            }

            Integer predecessor = map.floorKey(x);
            Integer successor = map.ceilingKey(x);

            int pHeight = (predecessor == null) ? 0 : map.get(predecessor);
            int sHeight = (successor == null) ? 0 : map.get(successor);

            int height = Math.max(pHeight, sHeight);
            map.put(x, height + 1);
            answer += height + 1;
        }

        System.out.println(answer);
    }
}