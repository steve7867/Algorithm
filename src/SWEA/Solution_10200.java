package SWEA;

import java.util.Scanner;

class Solution_10200 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int u = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int max = Math.min(a, b);
			int min = (a + b - u) <= 0 ? 0 : a + b - u; 
			
			System.out.format("#%d %d %d\n", tc, max, min);
		}
	}
}