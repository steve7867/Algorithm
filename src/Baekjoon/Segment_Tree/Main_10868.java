//https://www.acmicpc.net/problem/10868
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_10868 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder sb = new StringBuilder();
	private static int n;
	private static int m;
	private static int[] arr;
	private static int[] tree;
	
	public static void main(String[] args) throws IOException {
		input();
		makeTree();
		processQuery();
		System.out.println(sb);
	}

	private static void processQuery() throws IOException {
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = sttoi(st);
			int b = sttoi(st);
			sb.append(getMin(1, 1, n, a, b)).append('\n');
		}
	}

	private static int sttoi(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	private static int getMin(int node, int start, int end, int l, int r) {
		if (l > end || r < start)
			return Integer.MAX_VALUE;
		else if (l <= start && end <= r)
			return tree[node];
		else
			return Math.min(getMin(node * 2, start, (start + end) / 2, l, r)
					, getMin(node * 2 + 1, (start + end) / 2 + 1, end, l, r));
	}

	private static void makeTree() {
		int height = logUp(n) + 1;
		int treeSize = (1 << height) - 1;
		tree = new int[treeSize + 1];
		
		init(1, 1, n);
	}
	
	private static int init(int node, int start, int end) {
		if (start == end)
			return tree[node] = arr[start];
		else
			return tree[node] = Math.min(init(node * 2, start, (start + end) / 2), init(node * 2 + 1, (start + end) / 2 + 1, end));
	}

	private static int logUp(int n) {
		return (int) Math.ceil(Math.log(n) / Math.log(2));
	}

	private static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = sttoi(st);
		m = sttoi(st);
		
		arr = new int[n + 1];
		
		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(br.readLine());
	}
}