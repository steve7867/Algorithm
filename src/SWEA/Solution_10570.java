package SWEA;

import java.util.Scanner;
import java.util.Stack;

class Solution_10570 {
	public static double sr;
	
	public static String num;
	public static Stack<Character> st = new Stack<Character>();

	public static boolean isSquare(double n) {
		sr = Math.sqrt(n);

		return (sr - Math.floor(sr) == 0);
	}

	public static boolean isPalindrome(int n) {
		num = String.valueOf(n);
		int len = num.length();
		
		if (len == 1) return true;

		for (int i = 0; i < len; i++) {
			char c = num.charAt(i);

			if (i < len / 2)
				st.push(c);
			else if (len % 2 == 1 && i == len / 2) continue;
			else {
				if (st.pop() != c) {
					st.clear();
					return false;
				}
			}
		}

		st.clear();
		return true;
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;

			int a = sc.nextInt(), b = sc.nextInt();

			for (int i = a; i <= b; i++) {
				if (isSquare(i) && isPalindrome(i)) {
					int n = (int) Math.sqrt(i);
					if (isPalindrome(n)) answer++;
				}
			}

			System.out.format("#%d %d", test_case, answer);
		}
	}
}