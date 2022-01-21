/**
 * 좋은 단어
 * https://www.acmicpc.net/problem/3986
 */
package Baekjoon.Stack;

import java.io.*;
import java.util.*;
 
public class Main_3986 {
    private static Deque<Character> st = new ArrayDeque<>();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        int n = Integer.parseInt(br.readLine());
 
        while (n-- > 0)
            ans += isGood(br.readLine());
 
        System.out.println(ans);
    }
 
    private static int isGood(String input) {
        st.clear();
 
        for (char c : input.toCharArray()) {
            if (st.isEmpty())
                st.push(c);
            else {
                if (c == st.peek())
                    st.pop();
                else
                    st.push(c);
            }
        }
 
        return st.isEmpty() ? 1 : 0;
    }
}