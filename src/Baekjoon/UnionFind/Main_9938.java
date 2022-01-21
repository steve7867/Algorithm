/**
 * 방 청소
 * https://www.acmicpc.net/problem/9938
 * 문제 해설: https://blog.naver.com/PostView.naver?blogId=kks227&logNo=220791837179&categoryNo=299&parentCategoryNo=0&viewDate=&currentPage=2&postListTopCurrentPage=&from=postList&userTopListOpen=true&userTopListCount=30&userTopListManageOpen=false&userTopListCurrentPage=2
 */
package Baekjoon.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_9938 {
    private static int[] p;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
 
        p = new int[l + 1];
        for (int i = 0; i < l; i++)
            p[i] = i;
 
        int[] content = new int[l + 1];
 
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
 
            boolean canSave = true;
            if (content[a] == 0) {
                content[a] = i;
                union(a, b);
            } else if (content[b] == 0) {
                content[b] = i;
                union(b, a);
            } else {
                int aRoot = find(a);
                int bRoot = find(b);
 
                if (content[aRoot] == 0) {
                    content[aRoot] = i;
                    union(aRoot, bRoot);
                } else if (content[bRoot] == 0) {
                    content[bRoot] = i;
                    union(bRoot, aRoot);
                } else {
                    union(aRoot, bRoot);
                    canSave = false;
                }
            }
 
            sb.append(canSave ? "LADICA\n" : "SMECE\n");
        }
 
        System.out.println(sb);
    }
 
    private static int find(int i) {
        if (i != p[i])
            p[i] = find(p[i]);
 
        return p[i];
    }
 
    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
 
        if (aRoot == bRoot)
            return;
 
        p[aRoot] = bRoot;
    }
}
