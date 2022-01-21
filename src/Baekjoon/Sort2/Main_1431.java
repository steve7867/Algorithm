/**
 * 시리얼 번호
 * https://www.acmicpc.net/problem/1431
 */
package Baekjoon.Sort2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
 
public class Main_1431 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int n;
    private static String[] serials;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        serials = new String[n];
        
        for (int i = 0; i < n; i++)
            serials[i] = br.readLine();
        
        Arrays.sort(serials, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int aLen = a.length();
                int bLen = b.length();
                if (aLen != bLen) return aLen - bLen;
                else {
                    int aSum = 0, bSum = 0;
                    for (int i = 0; i < a.length(); i++) {
                        char c = a.charAt(i);
                        if (isNum(c)) aSum += c - '0';
                    }
                    
                    for (int i = 0; i < b.length(); i++) {
                        char c = b.charAt(i);
                        if (isNum(c)) bSum += c - '0';
                    }
                    
                    if (aSum != bSum) return aSum - bSum;
                }
                
                return a.compareTo(b);
            }
 
            private boolean isNum(char c) {
                return '0' <= c && c <= '9';
            }
            
        });
        
        for (String s : serials)
            sb.append(s).append("\n");
        
        System.out.println(sb);
    }
 
}
