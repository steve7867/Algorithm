/**
 * 실패율
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 */
package Kakao.Blind_2019.실패율;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
 
class Solution {
    public int[] solution(int n, int[] stages) {
        int[] reachers = new int[n + 2];
        int[] players = new int[n + 2];
        double[] fail = new double[n + 1];
 
        for (int i = 0; i < stages.length; i++)
            players[stages[i]]++;
 
        reachers[n + 1] = players[n + 1];
        for (int i = n; i >= 1; i--) {
            reachers[i] = reachers[i + 1] + players[i];
            if (reachers[i] == 0)
                fail[i] = 0;
            else
                fail[i] = (double) players[i] / reachers[i];
        }
 
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
 
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (fail[a] == fail[b])
                    return Integer.compare(a, b);
                return -Double.compare(fail[a], fail[b]);
            }
        });
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++)
            ans[i] = list.get(i);
        
        return ans;
    }
}
