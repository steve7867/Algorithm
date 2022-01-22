/**
 * 다트 게임
 * https://programmers.co.kr/learn/courses/30/lessons/17682
 */
package Kakao.Blind_2018.다트_게임;

class Solution {
	public int solution(String dartResult) {
		int[] score = new int[3];
		int j = -1;
		for (int i = 0; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);
			if (Character.isDigit(c)) {
				if (c == '1' && dartResult.charAt(i + 1) == '0') {
					i++;
					j++;
					score[j] = 10;
				} else {
					j++;
					score[j] = c - '0';
				}
			} else {
				if (c == 'D')
					score[j] = score[j] * score[j];
				else if (c == 'T')
					score[j] = score[j] * score[j] * score[j];
				else if (c == '*') {
					score[j] *= 2;
					if (j != 0)
						score[j - 1] *= 2;
				} else if (c == '#')
					score[j] *= -1;
			}
		}

		int answer = 0;
		for (int i = 0; i < score.length; i++)
			answer += score[i];

		return answer;
	}
}