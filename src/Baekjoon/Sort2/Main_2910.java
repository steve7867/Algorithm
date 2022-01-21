/**
 * 빈도 정렬
 * https://www.acmicpc.net/problem/2910
 */
package Baekjoon.Sort2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Main_2910 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static int n, c;
    private static List<Integer> list = new LinkedList<>();
    private static Map<Integer, Integer> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!list.contains(num)) list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(b) - map.get(a);
            }
        });
        
        for (int num : list) {
            int rep = map.get(num);
            
            for (int i = 0; i < rep; i++)
                sb.append(num).append(" ");
        }
        
        System.out.println(sb);
    }
    
}
