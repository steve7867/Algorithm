/**
 * 일곱 난쟁이
 * https://www.acmicpc.net/problem/2309
 */
package Baekjoon.Brute_Force;

import java.util.*;
import java.io.*;
 
public class Main_2309 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    for (int k = 0; k < arr.length; k++) {
                        if (k == i || k == j)
                            continue;
                        System.out.println(arr[k]);
                    }
                    return;
                }
            }
        }
    }
}