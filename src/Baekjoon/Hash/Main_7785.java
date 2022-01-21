/**
 * 회사에 있는 사람
 * https://www.acmicpc.net/problem/7785
 */
package Baekjoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;
 
public class Main_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> peopleIndoors = new TreeSet<>(Collections.reverseOrder());
 
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            String name = st.nextToken();
            String action = st.nextToken();
 
            if (action.equals("enter")) {
                peopleIndoors.add(name);
            } else {
                peopleIndoors.remove(name);
            }
        }
 
        StringBuilder sb = new StringBuilder();
        for (String people : peopleIndoors)
            sb.append(people)
                    .append('\n');
 
        System.out.println(sb);
    }
}