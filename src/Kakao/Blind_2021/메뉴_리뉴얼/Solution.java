/**
 * 메뉴 리뉴얼
 * https://programmers.co.kr/learn/courses/30/lessons/72411
 */
package Kakao.Blind_2021.메뉴_리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    HashMap<Integer, HashMap<String, Integer>> hm = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            orders[i] = String.valueOf(temp);
        }


        for (int len : course) {
            hm.put(len, new HashMap<>());
            for (String order : orders) {
                if (order.length() >= len)
                    backtrack(order, len, 0, "", 0);
            }
        }

        for (int len : course) {
            Map<String, Integer> temp = hm.get(len);
            ArrayList<String> willBeDeleted = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : temp.entrySet()) {
                if (entry.getValue() < 2)
                    willBeDeleted.add(entry.getKey());
            }

            for (String key : willBeDeleted) {
                temp.remove(key);
            }
        }

        ArrayList<String> entireMenu = new ArrayList<>();
        for (int len : course) {
            ArrayList<String> list = new ArrayList<>();
            int maxOrder = 0;
            Map<String, Integer> temp = hm.get(len);
            for (Map.Entry<String, Integer> entry : temp.entrySet()) {
                int order = entry.getValue();
                if (maxOrder < order) {
                    list.clear();
                    list.add(entry.getKey());
                    maxOrder = order;
                } else if (maxOrder == order)
                    list.add(entry.getKey());
            }

            entireMenu.addAll(list);
        }

        String[] ans = entireMenu.toArray(new String[0]);
        Arrays.sort(ans);

        return ans;
    }

    private void backtrack(String order, int len, int idx, String combi, int start) {
        if (idx == len) {
            Map<String, Integer> temp = hm.get(len);
            temp.put(combi, temp.getOrDefault(combi, 0) + 1);
            return;
        }

        for (int i = start; i < order.length(); i++) {
            backtrack(order, len, idx + 1, combi + order.charAt(i), i + 1);
        }
    }
}