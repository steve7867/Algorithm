/**
 * 오픈채팅방
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */
package Kakao.Blind_2019.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
class Solution {
 
    class Info {
        String state;
        String nickname;
        List<Integer> list;
 
        public Info(String state, String nickname, List<Integer> list) {
            this.state = state;
            this.nickname = nickname;
            this.list = list;
        }
    }
 
    List<String> ans = new ArrayList<>();
    Map<String, Info> map = new HashMap<>();
 
    public String[] solution(String[] records) {
 
        for (String record : records) {
            String[] r = record.split(" ");
 
            String state = r[0];
            String ID = r[1];
 
            if (state.equals("Leave")) {
                Info info = map.get(ID);
                info.state = "Leave";
                ans.add(info.nickname + "님이 나갔습니다.");
                info.list.add(ans.size() - 1);
                continue;
            }
 
            String nickname = r[2];
            if (state.equals("Enter")) {
                if (!map.containsKey(ID)) {
                    map.put(ID, new Info("Enter", nickname, new ArrayList<>()));
                    ans.add(nickname + "님이 들어왔습니다.");
                    map.get(ID).list.add(ans.size() - 1);
                } else {
                    Info info = map.get(ID);
                    if (!info.nickname.equals(nickname))
                        change(info, nickname);
 
                    ans.add(nickname + "님이 들어왔습니다.");
                    info.list.add(ans.size() - 1);
                }
            }
 
            if (state.equals("Change"))
                change(map.get(ID), nickname);
        }
 
        return ans.toArray(new String[0]);
    }
 
    private void change(Info info, String newNickname) {
        for (int i : info.list)
            ans.set(i, ans.get(i).replace(info.nickname, newNickname));;
 
        info.nickname = newNickname;
    }
}
