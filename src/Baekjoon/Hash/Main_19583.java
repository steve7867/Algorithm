/**
 * 싸이버개강총회
 * https://www.acmicpc.net/problem/19583
 */
package Baekjoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
public class Main_19583 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        String start = st.nextToken();
        String end = st.nextToken();
        String sEnd = st.nextToken();
 
        int cnt = 0;
        Set<String> set = new HashSet<>();
        while (true) {
            String str = br.readLine();
            if (str == null)
                break;
 
            st = new StringTokenizer(str);
 
            String time = st.nextToken();
            String name = st.nextToken();
 
            int a = time.compareTo(start);
            int b = time.compareTo(end);
            int c = time.compareTo(sEnd);
 
            if (a <= 0) //총회 시작전
                set.add(name);
            else if (b >= 0 && c <= 0) { //총회 종료 후, 스트리밍 종료 전
                if (set.remove(name))
                    cnt++;
            } else if (c > 0) //스트리밍 종료 후
                break;
        }
 
        System.out.println(cnt);
    }
 
}