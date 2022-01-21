package SWEA;

import java.util.Arrays;
import java.util.Scanner;

class Solution_10580 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			
			int n = sc.nextInt();
			Cable[] cable = new Cable[n];
			
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				cable[i] = new Cable(a, b);
			}
			
			Arrays.sort(cable);
			
			for (int i = 0; i < cable.length - 1; i++)
				for (int j = i + 1; j < cable.length; j++)
					if (cable[i].b > cable[j].b)
						answer++;

			System.out.format("#%d %d\n", test_case, answer);
		}
	}
}

class Cable implements Comparable<Cable> {
	int a, b;
	
	Cable (int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int compareTo(Cable c) {
		if (this.a < c.a) return -1;
		else if (this.a == c.a) return Integer.compare(this.b, c.b);
		else return 1;
	}
}