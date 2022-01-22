/**
 * 광고 삽입
 * https://programmers.co.kr/learn/courses/30/lessons/72414#fn1
 */
package Kakao.Blind_2021.광고_삽입;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        if (play_time.equals(adv_time))
            return "00:00:00";
 
        long[] view = new long[360000];
 
        int endSec = timeToSec(play_time);
        int advSec = timeToSec(adv_time);
 
        for (String log : logs) {
            int start = timeToSec(log.substring(0, 8));
            int end = timeToSec(log.substring(9, 17));
 
            for (int i = start; i < end; i++)
                view[i]++;
        }
 
        int insertSec = 0;
        long segmentView = 0;
        for (int i = 0; i < advSec; i++)
            segmentView += view[i];
 
        long maxView = segmentView;
        for (int i = advSec; i < endSec; i++) {
            segmentView = segmentView + view[i] - view[i - advSec];
            if (segmentView > maxView) {
                maxView = segmentView;
                insertSec = i - advSec + 1;
            }
        }
 
        return String.format("%02d:%02d:%02d", insertSec / 3600, (insertSec / 60) % 60, insertSec % 60);
    }
 
    public int timeToSec(String time) {
        String[] unit = time.split(":");
        return 3600 * Integer.parseInt(unit[0]) + 60 * Integer.parseInt(unit[1]) + Integer.parseInt(unit[2]);
    }
}
