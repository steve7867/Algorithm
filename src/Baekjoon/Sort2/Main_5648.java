/**
 * 역원소 정렬
 * https://www.acmicpc.net/problem/5648
 */
package Baekjoon.Sort2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main_5648 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static List<Long> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        
        while (st.hasMoreTokens()) {
            String s = removePrefixZero(reverse(st.nextToken()));
            list.add(Long.parseLong(s));
        }
        
        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            while (st.hasMoreTokens())
                list.add(Long.parseLong(reverse(st.nextToken())));
        }
        
        Collections.sort(list);
        
        for (long num : list)
            sb.append(num).append("\n");
        
        System.out.println(sb);
    }
 
    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            sb.append(s.charAt(i));
        
        return sb.toString();
    }
    
    private static String removePrefixZero(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') i++;
        return s.substring(i);
    }
    
}