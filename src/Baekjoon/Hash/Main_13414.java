/**
 * 수강신청
 * https://www.acmicpc.net/problem/13414
 */
package Baekjoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Main_13414 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
 
        Map<String, Integer> map = new HashMap<>();
        String[] list = new String[l + 1];
 
        for (int i = 1; i <= l; i++) {
            String ID = br.readLine();
            if (map.containsKey(ID)) {
                int idx = map.get(ID);
                list[idx] = null;
            }
 
            list[i] = ID;
            map.put(ID, i);
 
        }
 
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= l; i++) {
            if (list[i] != null) {
                sb.append(list[i]).append('\n');
                cnt++;
                if (cnt == k)
                    break;
            }
        }
 
        System.out.println(sb);
    }
}