package SWEA;

import java.util.Scanner;

class Solution_10505 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[] income = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				income[i] = sc.nextInt();
				sum += income[i];
			}
			
			double average = (double)sum / n;
			int answer = 0;
			
			for (int i = 0; i < n; i++)
				if (income[i] <= average) answer++;
			
			System.out.format("#%d %d\n", tc, answer);
		}
	}
}