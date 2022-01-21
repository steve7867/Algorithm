/**
 * 트리의 순회
 * https://www.acmicpc.net/problem/2263
 * 문제 해설: https://entrydeveloper.tistory.com/464
 */
package Baekjoon.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_2263 {
    private static int n;
    private static int[] inorder, postorder, idx;
    private static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        n = Integer.parseInt(br.readLine());
        inorder = new int[n + 1];
        postorder = new int[n + 1];
        idx = new int[n + 1];
 
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            idx[inorder[i]] = i;
        }
 
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++)
            postorder[i] = Integer.parseInt(st.nextToken());
 
        preorder(0, n - 1, 0, n - 1);
 
        System.out.println(sb);
    }
 
    private static void preorder(int inBegin, int inEnd, int postBegin, int postEnd) {
        if (inBegin > inEnd)
            return;
 
        int root = postorder[postEnd];
        sb.append(root).append(' ');
 
        int numOfPrefix = idx[root] - inBegin;
 
        preorder(inBegin, idx[root] - 1, postBegin, postBegin + numOfPrefix - 1);
 
        preorder(idx[root] + 1, inEnd, postBegin + numOfPrefix, postEnd - 1);
    }
}
