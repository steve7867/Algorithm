//https://www.acmicpc.net/problem/10807
package Baekjoon.Array;

import java.io.*;

public class Main_10807 {
	public static void main (String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		br.readLine();
		String[] arr = br.readLine().split(" ");
		int target = Integer.parseInt(br.readLine());
		int count = 0;
		
		for (String s : arr)
			if (Integer.parseInt(s) == target) count++;
		
		bw.write(count + "");
		
		bw.flush();
		br.close();
		bw.close();
	}
}