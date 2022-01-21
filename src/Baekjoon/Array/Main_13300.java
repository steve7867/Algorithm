/**
 * 방 배정
 * https://www.acmicpc.net/problem/13300
 */

package Baekjoon.Array;

import java.io.*;
import java.util.StringTokenizer;

public class Main_13300 {
	public static void main (String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		int[][] student = new int[2][7];
		int total = 0;
		
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			student[gender][grade]++;
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				if (student[i][j] == 0) 
					continue;
				
				int quota = student[i][j] / max;
				int remainder = student[i][j] % max;
				
				total += quota;
				if (remainder > 0) total++;
			}
		}
		
		bw.write(total + "");
		bw.flush();
		br.close();
		bw.close();
	}
}