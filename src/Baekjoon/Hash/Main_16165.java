/**
 * 걸그룹 마스터 준석이
 * https://www.acmicpc.net/problem/16165
 */
package Baekjoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main_16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
 
        Map<String, String> nameToGroup = new HashMap<>();
        Map<String, Set<String>> groupToName = new HashMap<>();
 
        while (n-- > 0) {
            String group = br.readLine();
            int k = Integer.parseInt(br.readLine());
 
            groupToName.put(group, new TreeSet<>());
            for (int i = 0; i < k; i++) {
                String name = br.readLine();
                nameToGroup.put(name, group);
                groupToName.get(group).add(name);
            }
        }
 
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String key = br.readLine();
            int flag = Integer.parseInt(br.readLine());
 
            if (flag == 1) {
                sb.append(nameToGroup.get(key)).append('\n');
            } else {
                for (String name : groupToName.get(key))
                    sb.append(name).append('\n');
            }
        }
 
        System.out.println(sb);
    }
}
