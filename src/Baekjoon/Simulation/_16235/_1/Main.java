/**
 * 나무 재테크
 * https://www.acmicpc.net/problem/16235
 */
package Baekjoon.Simulation._16235._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    private static int[][] nut; //땅의 영양분
    private static PriorityQueue<Integer>[][] trees; // 땅에 있는 나무들
    private static Queue<Integer>[][] deads; // 땅에 죽은 나무들
    private static int[][] a;
    private static int n, m, k;
    private static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
 
        a = new int[n][n];
        nut = new int[n][n];
        trees = new PriorityQueue[n][n];
        deads = new LinkedList[n][n];
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                trees[i][j] = new PriorityQueue<>();
                deads[i][j] = new LinkedList<>();
            }
        }
 
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(input[j]);
            }
        }
 
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
 
            trees[x][y].add(age);
        }
 
        for (int i = 0; i < n; i++)
            Arrays.fill(nut[i], 5);
 
        while (k-- > 0) {
            spring();
            summer();
            fall();
            winter();
        }
 
        System.out.println(count());
    }
 
    private static int count() {
        int sum = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                sum += trees[x][y].size();
            }
        }
 
        return sum;
    }
 
    private static void spring() {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                PriorityQueue<Integer> temp = new PriorityQueue<>();
                PriorityQueue<Integer> treeQueue = trees[x][y];
                int treeSize = treeQueue.size();
                for (int i = 0; i < treeSize; i++) {
                    int age = treeQueue.poll();
                    if (nut[x][y] - age >= 0) {
                        nut[x][y] -= age;
                        temp.add(age + 1);
                    } else
                        deads[x][y].offer(age);
                }
 
                trees[x][y] = temp;
            }
        }
    }
 
    private static void summer() {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                Queue<Integer> q = deads[x][y];
                while (!q.isEmpty()) {
                    int age = q.poll();
                    nut[x][y] += age / 2;
                }
            }
        }
    }
 
    private static void fall() {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int dir = 0; dir < 8; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
 
                    if (OOB(nx, ny))
                        continue;
 
                    for (int age : trees[x][y]) {
                        if (age % 5 == 0)
                            trees[nx][ny].add(1);
                    }
                }
            }
        }
    }
 
    private static boolean OOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }
 
    private static void winter() {
        for (int x = 0; x < n; x++)
            for (int y = 0; y < n; y++)
                nut[x][y] += a[x][y];
    }
}
