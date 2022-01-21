/**
 * 요세푸스
 * https://www.acmicpc.net/problem/1158
 */
package Baekjoon.LinkedList;

import java.io.*;
import java.util.*;

public class Main_1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> nums = new LinkedList<>();
		List<Integer> buffer = new LinkedList<>();
		StringBuffer sb = new StringBuffer();
		
		
		for (int i = 1; i <= N; i++)
			nums.add(i);
		
		sb.append('<');
		while (!nums.isEmpty()) {
			for (int i = 0; i < K - 1; i++)
				nums.offer(nums.poll());
			
			sb.append(nums.poll() + ", ");
		}
		
		sb.deleteCharAt(sb.length() - 1);
		sb.deleteCharAt(sb.length() - 1);
		sb.append(">");
		System.out.println(sb.toString());
		
		br.close();
	}
}