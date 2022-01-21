/**
 * 접미사 배열
 * https://www.acmicpc.net/problem/11656
 */
package Baekjoon.Sort2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main_11656 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static String[] arr;
    
    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int n = input.length();
        arr = new String[n];
        
        for (int i = 0; i < n; i++)
            arr[i] = input.substring(i, n);
        
        Arrays.sort(arr);
        
        for (String s : arr)
            sb.append(s).append("\n");
        
        System.out.println(sb);
    }
    
}