/**
 * 숫자의 개수
 * https://www.acmicpc.net/problem/2577
 */

package Baekjoon.Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main_2577 {
    public static void main (String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int product = Integer.parseInt(br.readLine());
        product *= Integer.parseInt(br.readLine());
        product *= Integer.parseInt(br.readLine());
        
        String s = Integer.toString(product); // String s = String.valueOf(product);
        int[] countArr = new int[10];
        
        for (char c : s.toCharArray())
            countArr[c - '0']++;
        
        for (int i : countArr)
            bw.write(i + "\n");
        
        bw.flush();
        br.close();
        bw.close();
    }
}