/**
 *알파벳 개수
 *https://www.acmicpc.net/problem/10808
 */

package Baekjoon.Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_10808 {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = bf.readLine();
        int[] res = new int[26];
        
        for (char c : s.toCharArray())
            res[c - 'a']++;
        
        for (int i : res)
            bw.write(i + " ");
        
        bf.close();
        bw.flush();
        bw.close();
    }
}