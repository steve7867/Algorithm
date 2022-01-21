/**
 * 집합
 * https://www.acmicpc.net/problem/11723
 */
package Baekjoon.Bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
 
        int combi = 0;
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            
            if (order.equals("all")) 
                combi = (1 << 21) - 1 - 1;
            else if (order.equals("empty"))
                combi = 0;
            else {
                int val = Integer.parseInt(st.nextToken());
                int binVal = 1 << val;
                switch (order.charAt(0)) {
                    case 'a':
                        combi |= binVal;
                        break;
                    case 'r':
                        combi &= (~binVal);
                        break;
                    case 'c':
                        sb.append((combi & binVal) != 0 ? 1 : 0).append("\n");
                        break;
                    case 't':
                        if ((combi & binVal) != 0)
                            combi &= ~binVal;
                        else
                            combi |= binVal;
                        break;
                }
            }
 
        }
 
        System.out.println(sb);
    }
}