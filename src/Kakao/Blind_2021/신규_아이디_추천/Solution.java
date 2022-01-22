/**
 * 신규 아이디 추천
 * https://programmers.co.kr/learn/courses/30/lessons/72410
 */
package Kakao.Blind_2021.신규_아이디_추천;

class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder(new_id);
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (!Character.isAlphabetic(c) && !Character.isDigit(c) && c != '-' && c != '_' && c != '.')
                sb.deleteCharAt(i);
        }
 
        for (int i = sb.length() - 1; i >= 1; i--) {
            if (sb.charAt(i) == '.' && sb.charAt(i - 1) == '.')
                sb.deleteCharAt(i);
        }
 
        if (sb.length() > 0 && sb.charAt(0) == '.')
            sb.deleteCharAt(0);
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.')
            sb.deleteCharAt(sb.length() - 1);
 
        if (sb.length() == 0)
            sb.append('a');
 
        if (sb.length() >= 16)
            sb.delete(15, sb.length());
 
        if (sb.charAt(sb.length() - 1) == '.')
            sb.deleteCharAt(sb.length() - 1);
 
        if (sb.length() <= 2) {
            while (sb.length() < 3)
                sb.append(sb.charAt(sb.length() - 1));
        }
 
        return sb.toString();
    }
}