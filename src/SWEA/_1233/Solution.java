/*
    사칙연산 유효성 검사
    https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD&categoryId=AV141176AIwCFAYD&categoryType=CODE&problemTitle=1233&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */
package SWEA._1233;

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

            int res = 1;
            if (n % 2 == 0) // 총 노드 개수가 짝수이면 계산 불가능
                res = 0;

            int lastParent = n / 2;

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                char c = st.nextToken().charAt(0);

                if (i <= lastParent && Character.isDigit(c)) //자식 있는 노드가 숫자를 담고 있으면 계산 불가
                    res = 0;

                if (i > lastParent && !Character.isDigit(c)) //리프 노드가 연산자를 담고 있으면 계산 불가
                    res = 0;
            }

            sb.append('#')
                    .append(tc++)
                    .append(' ')
                    .append(res)
                    .append('\n');

            s = br.readLine();
        }

        System.out.println(sb);
    }

}