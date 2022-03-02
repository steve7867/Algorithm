// https://www.acmicpc.net/problem/2042
package Baekjoon.Segment_Tree;
import java.io.*;
import java.util.*;

class Main_2042 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder sb = new StringBuilder();
	private static int n, m, k;
	private static long[] arr;
	private static long[] tree;
	
	public static void main(String[] args) throws IOException {
		input();
		makeTree();
		process();
		System.out.println(sb);
	}

	private static void process() throws IOException {
		for (int i = 0; i < m + k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = sttoi(st);
			
			if (a == 1) {
				int b = sttoi(st);
				long c = Long.parseLong(st.nextToken());
				update(b, c);
			} else {
				int b = sttoi(st);
				int c = sttoi(st);
				sb.append(sum(1, 1, n, b, c)).append('\n');
			}
		}
	}

	private static long sum(int node, int start, int end, int l, int r) {
		if (l > end || r < start)
			return 0;
		else if (l <= start && end <= r)
			return tree[node];
		else
			return sum(node * 2, start, (start + end) / 2, l, r)
					+ sum(node * 2 + 1, (start + end) / 2 + 1, end, l, r);
	}

	private static void update(int idx, long value) {
		long diff = value - arr[idx];
		arr[idx] = value;
		
		update(1, 1, n, idx, diff);
	}

	private static void update(int node, int start, int end, int idx, long diff) {
		if (idx < start || end < idx)
			return;
		
		tree[node] += diff;
		
		if (start == end)
			return;
		
		update(node * 2, start, (start + end) / 2, idx, diff);
		update(node * 2 + 1, (start + end) /2 + 1, end, idx, diff);
	}

	private static void makeTree() {
		int treeSize = (1 << (logUp(n) + 1)) - 1;
		tree = new long[treeSize + 1];
		init(1, 1, n);
	}
	
	private static int logUp(int n) {
		return (int) Math.ceil(Math.log(n) / Math.log(2));
	}
	
	private static long init(int node, int start, int end) {
		if (start == end)
			return tree[node] = arr[start];
		else
			return tree[node] = init(node * 2, start, (start + end) / 2) 
			+ init(node * 2 + 1, (start + end) / 2 + 1, end);
	}


	private static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = sttoi(st);
		m = sttoi(st);
		k = sttoi(st);
		
		arr = new long[n + 1];
		for (int i = 1; i <= n; i++)
			arr[i] = Long.parseLong(br.readLine());
	}

	private static int sttoi(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}