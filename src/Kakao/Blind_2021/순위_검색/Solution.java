/**
 * 순위 검색
 * https://programmers.co.kr/learn/courses/30/lessons/72412
 */
package Kakao.Blind_2021.순위_검색;

import java.util.Arrays;
import java.util.List;
 
class Solution {
    public int[] solution(String[] info, String[] query) {
        String[][] l = { {"-", "cpp", "java", "python"},
                         {"-", "backend", "frontend"},
                         {"-", "junior", "senior"},
                         {"-", "chicken", "pizza"} };
 
        // A. 전처리
        int L[][] = new int[108][100001];
 
        for (String s : info) {
            String[] word = s.split(" ");
 
            int v[] = new int[4];
            for (int i = 0; i < 4; i++) {
                List<String> tmp = Arrays.asList(l[i]);
                v[i] = tmp.indexOf(word[i]);
            }
 
            int score = Integer.parseInt(word[4]);
 
            int factor[] = {27, 9, 3, 1};
 
            for (int i = 0; i < 16; i++) {
                int idx = 0;
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) != 0)
                        idx += factor[j] * v[j];
                }
 
                L[idx][score]++;
            }
        }
 
        for (int i = 0; i < 108; i++) {
            for (int j = 1; j <= 100000; j++)
                L[i][j] += L[i][j - 1];
        }
 
        // B. 쿼리
        int[] ans = new int[query.length];
 
        for (int t = 0; t < query.length; t++) {
            String q = query[t];
            String[] word = q.split(" ");
 
            int v[] = new int[4];
            for (int i = 0; i < 4; i ++) {
                List<String> tmp = Arrays.asList(l[i]);
                v[i] = tmp.indexOf(word[i * 2]);
            }
 
            int target = Integer.parseInt(word[7]);
 
            int idx = v[0] * 27 + v[1] * 9 + v[2] * 3 + v[3];
            ans[t] = L[idx][100000] - L[idx][target - 1];
        }
 
        return ans;
    }
}
