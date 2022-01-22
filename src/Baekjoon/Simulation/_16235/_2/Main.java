/**
 * 나무 재테크
 * https://www.acmicpc.net/problem/16235
 */
package Baekjoon.Simulation._16235._2;

import java.io.*;
import java.util.*;
 
public class Main {
    private static int[][] a, nut;
    private static PriorityQueue<Tree> pq = new PriorityQueue<>();
    private static Queue<Tree> deads = new LinkedList<>();
    private static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    private static int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};
    private static int N, M, K;
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
 
        a = new int[N][N];
        nut = new int[N][N];
 
        for (int i = 0; i < N; i++)
            Arrays.fill(nut[i], 5);
 
        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < N; y++) {
                a[x][y] = Integer.parseInt(st.nextToken());
            }
        }
 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
 
            pq.offer(new Tree(x, y, age));
        }
 
        while (K-- > 0) {
            spring();
            summer();
            fall();
            winter();
        }
 
        System.out.println(pq.size());
    }
 
    private static void spring() {
        PriorityQueue<Tree> temp = new PriorityQueue<>();
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            Tree t = pq.poll();
            int tx = t.x;
            int ty = t.y;
            int age = t.age;
 
            if (nut[tx][ty] >= age) {
                nut[tx][ty] -= age;
                t.age++;
                temp.offer(t);
            } else
                deads.offer(t);
        }
 
        pq = temp;
    }
 
    private static void summer() {
        for (Tree t : deads)
            nut[t.x][t.y] += t.age / 2;
 
        deads.clear();
    }
 
    private static void fall() {
        List<Tree> temp = new ArrayList<>();
        for (Tree t : pq) {
            int tx = t.x;
            int ty = t.y;
            int age = t.age;
 
            if (age % 5 != 0)
                continue;
 
            for (int dir = 0; dir < 8; dir++) {
                int nx = tx + dx[dir];
                int ny = ty + dy[dir];
                if (OOB(nx, ny))
                    continue;
 
                temp.add(new Tree(nx, ny, 1));
            }
        }
 
        pq.addAll(temp);
    }
 
    private static boolean OOB(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }
 
    private static void winter() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                nut[x][y] += a[x][y];
            }
        }
    }
}
 
class Tree implements Comparable<Tree> {
    int x;
    int y;
    int age;
 
    Tree(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }
 
    @Override
    public int compareTo(Tree o) {
        return Integer.compare(this.age, o.age);
    }
}