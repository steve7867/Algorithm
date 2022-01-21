/**
 * 문제 추천 시스템 Version 2
 * https://www.acmicpc.net/problem/21944
 */
package Baekjoon.BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;
 
public class Main_21944 {
    private static class Problem implements Comparable<Problem> {
        int p;
        int l;

        public Problem(int p, int l) {
            this.p = p;
            this.l = l;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.l == o.l)
                return Integer.compare(this.p, o.p);

            return Integer.compare(this.l, o.l);
        }

    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    public static void main(String[] args) throws IOException {
        Problem[] problems = new Problem[100001];
        int[] groupNumArr = new int[100001];
 
        TreeSet<Problem> totalSet = new TreeSet<>();
        List<TreeSet<Problem>> groupList = new ArrayList<>();
        for (int i = 0; i <= 100; i++)
            groupList.add(new TreeSet<>());
 
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
 
            Problem problem = new Problem(p, l);
 
            problems[p] = problem;
            groupNumArr[p] = g;
 
            TreeSet<Problem> groupSet = groupList.get(g);
            groupSet.add(problem);
            totalSet.add(problem);
        }
 
        StringBuilder sb = new StringBuilder();
 
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
 
            switch (order) {
                case "add": {
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    int g = Integer.parseInt(st.nextToken());
 
                    Problem problem = new Problem(p, l);
 
                    problems[p] = problem;
                    groupNumArr[p] = g;
 
                    TreeSet<Problem> groupSet = groupList.get(g);
                    groupSet.add(problem);
                    totalSet.add(problem);
                    break;
                }
                case "recommend": {
                    int g = Integer.parseInt(st.nextToken());
                    int x = Integer.parseInt(st.nextToken());
 
                    TreeSet<Problem> groupSet = groupList.get(g);
                    sb.append(x == 1 ? groupSet.last().p : groupSet.first().p)
                            .append('\n');
                    break;
                }
                case "recommend2": {
                    int x = Integer.parseInt(st.nextToken());
                    sb.append(x == 1 ? totalSet.last().p : totalSet.first().p)
                            .append('\n');
                    break;
                }
                case "recommend3": {
                    int x = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
 
                    Problem problem;
                    if (x == 1)
                        problem = totalSet.ceiling(new Problem(1, l));
                    else
                        problem = totalSet.lower(new Problem(0, l));
 
                    sb.append(problem == null ? -1 : problem.p)
                            .append('\n');
                    break;
                }
                default: {
                    int p = Integer.parseInt(st.nextToken());
                    Problem problem = problems[p];
                    problems[p] = null;
 
                    int g = groupNumArr[p];
                    groupNumArr[p] = 0;
 
                    totalSet.remove(problem);
                    TreeSet<Problem> groupSet = groupList.get(g);
                    groupSet.remove(problem);
                    break;
                }
            }
        }
 
        System.out.println(sb);
    }
}
 
