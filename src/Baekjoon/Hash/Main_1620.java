/**
 * 나는야 포켓몬 마스터 이다솜
 * https://www.acmicpc.net/problem/1620
 */
package Baekjoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Main_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
 
        String[] numToName = new String[100001];
        Map<String, Integer> nameToNum = new HashMap<>();
 
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
 
            numToName[i] = name;
            nameToNum.put(name, i);
        }
 
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            String input = br.readLine();
            if (isNumeric(input)) {
                int num = Integer.parseInt(input);
                sb.append(numToName[num]);
            } else
                sb.append(nameToNum.get(input));
 
            sb.append('\n');
        }
 
        System.out.println(sb);
    }
 
    private static boolean isNumeric(String input) {
        return Character.isDigit(input.charAt(0));
    }
}
