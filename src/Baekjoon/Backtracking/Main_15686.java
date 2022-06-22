package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686 {

    private static int n;
    private static int m;

    private static final List<Pair> houses = new ArrayList<>();
    private static final List<Pair> chickens = new ArrayList<>();
    private static int[][] distMap;
    private static boolean[] deleted;

    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        makeDistMap();
        backtrack(0, 0);
        System.out.println(ans);
    }

    private static void makeDistMap() {
        for (int i = 0; i < houses.size(); i++)
            for (int j = 0; j < chickens.size(); j++)
                distMap[i][j] = getDistance(houses.get(i), chickens.get(j));
    }

    private static void backtrack(int idx, int numOfDeleted) {
        if (chickens.size() - numOfDeleted == m) {

            int total = 0;

            for (int[] dist : distMap) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < chickens.size(); j++) {
                    if (deleted[j])
                        continue;

                    min = Math.min(dist[j], min);
                }

                total += min;
            }

            ans = Math.min(ans, total);
            return;
        }

        if (idx == chickens.size())
            return;

        deleted[idx] = true;
        backtrack(idx + 1, numOfDeleted + 1);
        deleted[idx] = false;

        backtrack(idx + 1, numOfDeleted);
    }

    private static int getDistance(Pair p1, Pair p2) {
        return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                int value = Integer.parseInt(st.nextToken());

                if (value == 1)
                    houses.add(new Pair(r, c));

                if (value == 2)
                    chickens.add(new Pair(r, c));
            }
        }

        distMap = new int[houses.size()][chickens.size()];
        deleted = new boolean[chickens.size()];
    }
}

class Pair {
    int r;
    int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}