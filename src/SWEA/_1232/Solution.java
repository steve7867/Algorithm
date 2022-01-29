/*
    사칙연산
    https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141J8KAIcCFAYD&categoryId=AV141J8KAIcCFAYD&categoryType=CODE&problemTitle=%EC%82%AC%EC%B9%99%EC%97%B0%EC%82%B0&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */
package SWEA._1232;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static final int[][] child = new int[1001][2];
    private static final double[] stack = new double[2000];
    private static int top = -1;

    public static void main(String[] args) throws IOException {
        int tc = 1;

        String s = br.readLine();
        while (s != null) {
            for (int[] c : child)
                Arrays.fill(c, -1);

            int n = Integer.parseInt(s);

            String[] tree = new String[n + 1];
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                tree[i] = st.nextToken();

                while (st.hasMoreTokens()) {
                    child[i][0] = Integer.parseInt(st.nextToken());
                    child[i][1] = Integer.parseInt(st.nextToken());
                }
            }

            postorder(tree, 1);
            double res = stack[top--];

            sb.append('#')
                    .append(tc++)
                    .append(' ')
                    .append((int) res)
                    .append('\n');

            s = br.readLine();
        }

        System.out.println(sb);
    }

    private static void postorder(String[] tree, int i) {
        if (i == -1)
            return;

        postorder(tree, child[i][0]);
        postorder(tree, child[i][1]);
        if (isOperator(tree[i]))
            calculate(tree[i]);
        else
            stack[++top] = Double.parseDouble(tree[i]);
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static void calculate(String op) {
        double a = stack[top--];
        double b = stack[top--];
        if (b > a) {
            double temp = a;
            a = b;
            b = temp;
        }

        double res = 0;
        switch (op) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                res = a / b;
                break;
        }

        stack[++top] = res;
    }

}