//https://www.acmicpc.net/problem/1919
package Baekjoon.Array;

import java.io.*;

public class Main_1919 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] occur = new int[26];
        
        for (char c : br.readLine().toCharArray())
            occur[c - 'a']++;
        
        for (char c : br.readLine().toCharArray())
            occur[c - 'a']--;
        
        int res = 0;
        for (int i = 0; i < occur.length; i++)
            res += Math.abs(occur[i]);
        System.out.println(res);
    }
}