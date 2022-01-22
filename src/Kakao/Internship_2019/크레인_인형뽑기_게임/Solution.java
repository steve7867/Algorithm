/**
 * 크레인 인형뽑기 게임
 * https://programmers.co.kr/learn/courses/30/lessons/64061
 */
package Kakao.Internship_2019.크레인_인형뽑기_게임;

import java.util.*;

class Solution {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> st = new Stack<Integer>();
		for (int loc = 0; loc < moves.length; loc++) {
			int j = moves[loc] - 1;
			for (int i = 0; i < board.length; i++) {
				if (board[i][j] == 0)
					continue;
				else {
					if (!st.isEmpty() && board[i][j] == st.peek()) {
						st.pop();
						answer += 2;
					} else
						st.push(board[i][j]);
					board[i][j] = 0;
					break;
				}
			}
		}
		return answer;
	}
}