package SWEA;

import java.util.Scanner;

class Solution_10059 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String num = sc.next();
			int former = Integer.parseInt(num.substring(0, 2));
			int latter = Integer.parseInt(num.substring(2));
			String answer = "";
			
			if ((former > 12 && latter > 12)
				|| (former > 12 && latter == 0)
				|| (former == 0 && latter > 12)
				|| (former == 0 && latter == 0)) answer = "NA";
			else if (former == 0) answer = "YYMM";
			else if (latter == 0) answer = "MMYY";
			else if ((former <= 12 && latter <= 12)) answer = "AMBIGUOUS";
			else if (former <= 12) answer = "MMYY";
			else if (latter <= 12) answer = "YYMM";
			
			System.out.format("#%d %s\n", tc, answer);
		}
	}
}