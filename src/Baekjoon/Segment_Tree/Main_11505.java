//https://www.acmicpc.net/problem/11505
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_11505 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder sb = new StringBuilder();
	private static int n;
	private static int m;
	private static int k;
	private static int[] arr;
	private static long[] tree;
	private static final int MOD = 1_000_000_007;//10억7
	
	public static void main(String[] args) throws IOException {
		input();
		makeTree();
		processQuery();
		System.out.println(sb);
	}

	private static void processQuery() throws IOException {
		for (int i = 0; i < m + k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = sttoi(st);
			int b = sttoi(st);
			int c = sttoi(st);
			
			if (a == 1)
				update(b, c);
			else
				sb.append(getMul(1, 1, n, b, c)).append('\n');
		}
	}

	private static long getMul(int node, int start, int end, int l, int r) {
		if (l > end || r < start)
			return 1;
		else if (l <= start && end <= r)
			return tree[node];
		else
			return getMul(node * 2, start, (start + end) / 2, l, r)
					* getMul(node * 2 + 1, (start + end) / 2 + 1, end, l, r) % MOD;
	}

	private static void update(int idx, int newVal) {
		arr[idx] = newVal;
		update(1, 1, n, idx, newVal);
	}

	private static long update(int node, int start, int end, int idx, int newVal) {
		if (idx < start || end < idx)
			return tree[node];
		
		if (start == end)
			return tree[node] = newVal;
		
		return tree[node] = update(node * 2, start, (start + end) / 2, idx, newVal) * update(node * 2 + 1, (start + end) / 2 + 1, end, idx, newVal) % MOD;
	}

	private static void makeTree() {
		int height = logUp(n) + 1;
		int treeSize = (1 << height) - 1;
		tree = new long[treeSize + 1];
		init(1, 1, n);
	}

	private static long init(int node, int start, int end) {
		if (start == end)
			return tree[node] = arr[start];
		else
			return tree[node] = init(node * 2, start, (start + end) / 2) 
			* init(node * 2 + 1, (start + end) / 2 + 1, end) % MOD;
	}

	private static int logUp(int n) {
		return (int) Math.ceil(Math.log(n) / Math.log(2));
	}

	private static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = sttoi(st);
		m = sttoi(st);
		k = sttoi(st);
		
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(br.readLine());
	}

	private static int sttoi(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}