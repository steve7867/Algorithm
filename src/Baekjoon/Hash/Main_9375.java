/**
 * 패션왕 신혜빈
 * https://www.acmicpc.net/problem/9375
 */
package Baekjoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main_9375 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
 
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            Map<String, Integer> closet = new HashMap<>();
 
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                sb.append(0).append('\n');
                continue;
            }
 
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();
 
                closet.put(kind, closet.getOrDefault(kind, 0) + 1);
            }
 
 
            int answer = 1;
            for (int value : closet.values())
                answer *= (value + 1);
 
            answer--;
            sb.append(answer)
                    .append('\n');
        }
 
        System.out.println(sb);
    }
 
}