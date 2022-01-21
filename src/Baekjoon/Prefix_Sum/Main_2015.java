/**
 * 수들의 합 4
 * https://www.acmicpc.net/problem/2015
 */
package Baekjoon.Prefix_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Main_2015 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
 
        int[] prefix = new int[n + 1];
 
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
 
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefix[i] = Integer.parseInt(st.nextToken());
            prefix[i] += prefix[i - 1];
 
            if (map.containsKey(prefix[i] - k))
                answer += map.get(prefix[i] - k);
 
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }
 
        System.out.println(answer);
    }
}