/**
 * 하노이 탑
 * https://www.acmicpc.net/problem/1914
 */
package Baekjoon.Recursion;

import java.io.*;
import java.math.BigInteger;

public class Main_1914 {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	
    public static void main(String[] args) throws IOException {
    	N = Integer.parseInt(br.readLine());
    	BigInteger cnt = BigInteger.TWO.pow(N).subtract(BigInteger.ONE);
    	System.out.println(cnt);
    	
   		if (N <= 20) {
   			hanoii(N, 1, 3);
   			System.out.println(sb);
   		}
    }
    
    // k개의 원판을 f -> t로 옮기는 과정을 출력. 
    private static void hanoii(int k, int a, int b) {
    	if (k == 0) return;
    	
    	hanoii(k - 1, a, 6 - a - b);
    	if (N <= 20) sb.append(a + " " + b).append("\n");
    	hanoii(k - 1, 6 - a - b, b);
    }
}