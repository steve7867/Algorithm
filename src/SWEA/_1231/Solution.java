/*
    중위순회
    https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV140YnqAIECFAYD&categoryId=AV140YnqAIECFAYD&categoryType=CODE&problemTitle=%EC%A4%91%EC%9C%84%EC%88%9C%ED%9A%8C&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */
package SWEA._1231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int tc = 1;

        String s = br.readLine();
        while (s != null) {
            int n = Integer.parseInt(s);
            char[] tree = new char[n + 1];

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                st.nextToken();
                tree[i] = st.nextToken().charAt(0);
            }

            sb.append('#').append(tc++).append(' ');
            inorder(tree, 1);
            sb.append('\n');

            s = br.readLine();
        }

        System.out.println(sb);
    }

    private static void inorder(char[] tree, int i) {
        if (i >= tree.length)
            return;

        inorder(tree, 2 * i);
        sb.append(tree[i]);
        inorder(tree, 2 * i + 1);
    }
}