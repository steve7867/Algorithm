/**
 * 비밀지도
 * https://programmers.co.kr/learn/courses/30/lessons/17681
 */
package Kakao.Blind_2018.비밀지도;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
        	String s = Integer.toBinaryString(arr1[i] | arr2[i]);
            //Integer.toBinaryString()은 앞의 0을 생략. 길이 맞춰줘야 함 
        	while (s.length() < n)
        		s = "0" + s;
        	
        	s = s.replace("0", " ");
        	s = s.replace("1", "#");
        	
        	answer[i] = s;
        }
        
        return answer;
    }
}