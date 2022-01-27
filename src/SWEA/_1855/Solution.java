/**
 * 영준이의 진짜 BFS
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LnipaDvwDFAXc
 *
 * LCA 문제
 */
package SWEA._1855;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static final int max = 17; // round up (log2(100_001))
    private static final int maxN = 100_001;
    private static final int[] depth = new int[maxN];
    private static final int[][] parent = new int[maxN][max];
    private static final List<Integer>[] adjList = new List[maxN];

    static {
        for (int i = 0; i < adjList.length; i++)
            adjList[i] = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            input();
            depth[1] = 0;
            List<Integer> list = BFS();
            fillDp();

            long ans = getAns(list);

            sb.append('#')
                    .append(tc)
                    .append(' ')
                    .append(ans)
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static long getAns(List<Integer> list) {
        long totalDist = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            int src = list.get(i);
            int dest = list.get(i + 1);

            totalDist += getDist(src, dest);
        }

        return totalDist;
    }

    private static List<Integer> BFS() {
        List<Integer> retList = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        depth[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            retList.add(cur);

            for (int next : adjList[cur]) {
                if (depth[next] != -1)
                    continue;

                q.offer(next);
                depth[next] = depth[cur] + 1;
                parent[next][0] = cur;
            }
        }

        return retList;
    }

    private static int getDist(int src, int dest) {
        if (src == dest)
            return 0;

        int lca = LCA(src, dest);

        return (depth[src] - depth[lca]) + (depth[dest] - depth[lca]);
    }

    private static int LCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int diff = depth[a] - depth[b];

        for (int i = 0; diff != 0; i++) {
            if (diff % 2 == 1)
                a = parent[a][i];

            diff >>= 1;
        }

        if (a != b) {
            for (int i = max - 1; i >= 0; i--) {
                if (parent[a][i] != -1 && parent[a][i] != parent[b][i]) {
                    a = parent[a][i];
                    b = parent[b][i];
                }
            }

            a = parent[a][0];
        }

        return a;
    }

    private static void fillDp() {
        for (int j = 1; j < max; j++) {
            for (int i = 1; i <= n; i++) {
                if (parent[i][j - 1] == -1)
                    continue;

                parent[i][j] = parent[parent[i][j - 1]][j - 1];
            }
        }
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++)
            depth[i] = -1;

        for (int i = 1; i <= n; i++)
            Arrays.fill(parent[i], -1);

        for (int i = 1; i <= n; i++)
            adjList[i].clear();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int j = Integer.parseInt(st.nextToken());

            adjList[i].add(j);
            adjList[j].add(i);
        }
    }

}