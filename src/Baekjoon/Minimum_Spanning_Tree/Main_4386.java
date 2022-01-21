/**
 * 별자리 만들기
 * https://www.acmicpc.net/problem/4386
 */
package Baekjoon.Minimum_Spanning_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main_4386 {
 
    private static Star[] starArr;
    private static int[] p;
    private static int[] rank;
 
    private static class Star {
        double x;
        double y;
 
        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
 
    private static class Edge implements Comparable<Edge> {
        int a;
        int b;
        double dist;
 
        public Edge(int a, int b, double dist) {
            this.a = a;
            this.b = b;
            this.dist = dist;
        }
 
        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dist, o.dist);
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        starArr = new Star[n];
        p = new int[n];
        for (int i = 0; i < n; i++)
            p[i] = i;
 
        rank = new int[n];
        Arrays.fill(rank, 0);
 
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            starArr[i] = new Star(x, y);
        }
 
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = getDist(i, j);
                edgeList.add(new Edge(i, j, dist));
            }
        }
 
        Collections.sort(edgeList);
 
        double ans = 0;
        int cnt = 0;
        for (Edge edge : edgeList) {
            int a = edge.a;
            int b = edge.b;
            double dist = edge.dist;
 
            if (!isInSameGroup(a, b)) {
                union(a, b);
                ans += dist;
                if (++cnt == n - 1)
                    break;
            }
        }
 
        System.out.println(ans);
    }
 
    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
 
        if (aRoot == bRoot)
            return;
 
        int c = Integer.compare(rank[aRoot], rank[bRoot]);
        if (c > 0) {
            p[bRoot] = aRoot;
        } else if (c < 0) {
            p[aRoot] = bRoot;
        } else {
            p[bRoot] = aRoot;
            rank[aRoot]++;
        }
    }
 
    private static boolean isInSameGroup(int a, int b) {
        return find(a) == find(b);
    }
 
    private static int find(int i) {
        if (i != p[i]) {
            p[i] = find(p[i]);
        }
 
        return p[i];
    }
 
    private static double getDist(int a, int b) {
        Star aStar = starArr[a];
        Star bStar = starArr[b];
 
        double aX = aStar.x;
        double aY = aStar.y;
        double bX = bStar.x;
        double bY = bStar.y;
 
        double xDiff = bX - aX;
        double yDiff = bY - aY;
 
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}
