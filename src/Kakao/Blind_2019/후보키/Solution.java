/**
 * 후보키
 * https://programmers.co.kr/learn/courses/30/lessons/42890
 */
package Kakao.Blind_2019.후보키;

import java.util.*;
 
class Solution {
    String[][] relation;
    boolean[] selected;
    private List<boolean[]> keyList;
 
    public int solution(String[][] Relation) {
        relation = Relation;
        selected = new boolean[relation[0].length];
        keyList = new LinkedList<>();
 
        backtrack(0, 0);
 
        List<boolean[]> deleted = new ArrayList<>();
        for (int i = 0; i < keyList.size(); i++) {
            boolean[] a = keyList.get(i);
            for (int j = 0; j < keyList.size(); j++) {
                if (i == j)
                    continue;
                
                boolean[] b = keyList.get(j);
                
                if (contains(a, b))
                    deleted.add(a);
            }
        }
 
        for (boolean[] d : deleted)
            keyList.remove(d);
 
        return keyList.size();
    }
 
    private boolean contains(boolean[] s, boolean[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] && !s[i])
                return false;
        }
 
        return true;
    }
 
    private void backtrack(int idx, int num) {
        if (idx == relation[0].length) {
            if (num == 0)
                return;
 
            HashSet<String> hs = new HashSet<>();
 
            for (int i = 0; i < relation.length; i++) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < relation[0].length; j++) {
                    if (selected[j])
                        temp.append(relation[i][j]).append(" ");
                }
 
                String tuple = temp.toString();
                if (hs.contains(tuple))
                    return;
                else
                    hs.add(tuple);
            }
 
            keyList.add(Arrays.copyOf(selected, selected.length));
            return;
        }
 
        selected[idx] = true;
        backtrack(idx + 1, num + 1);
        selected[idx] = false;
 
        backtrack(idx + 1, num);
    }
}
