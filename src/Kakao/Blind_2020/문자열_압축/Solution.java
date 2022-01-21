/**
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 */
package Kakao.Blind_2020.문자열_압축;

class Solution {
    public int solution(String s) {
        int ans = s.length();
        int len = s.length();
        for (int unit = 1; unit <= len / 2; unit++) {
            StringBuilder sb = new StringBuilder();
            int cur = 0;
            String pre = "";
            int cnt = 0;
            while (cur < len) {
                String temp = "";
                if (cur + unit <= len) {
                    temp = s.substring(cur, cur + unit);
                    cur = cur + unit;
                } else {
                    temp = s.substring(cur);
                    cur = len + 1;
                }
 
                if (temp.equals(pre))
                    cnt++;
                else {
                    sb.append(cnt <= 1 ? "" : cnt).append(pre);
                    pre = temp;
                    cnt = 1;
                }
            }
 
            sb.append(cnt <= 1 ? "" : cnt).append(pre);
 
            if (ans > sb.length())
                ans = sb.length();
        }
 
        return ans;
    }
}
