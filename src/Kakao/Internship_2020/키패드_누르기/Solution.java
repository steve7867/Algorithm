/**
 * 키패드 누르기
 * https://programmers.co.kr/learn/courses/30/lessons/67256
 */
package Kakao.Internship_2020.키패드_누르기;

class Solution {
	public static int[] leftLoc = {0, 3}; //왼손 위치 {x, y}
	public static int[] rightLoc = {2, 3}; //오른손 위치 {x, y}
	//중간 번호 누를 경우 어느 손을 사용하는지
	public static char whichHand(int num, String hand) {
		//x좌표 거리 먼저 계산
		int ld = Math.abs(leftLoc[0] - 1), rd = Math.abs(rightLoc[0] - 1);
		//y좌표 거리 계산
		switch (num) {
			case 2:
				ld += Math.abs(leftLoc[1] - 0);
				rd += Math.abs(rightLoc[1] - 0);
				break;
			case 5:
				ld += Math.abs(leftLoc[1] - 1);
				rd += Math.abs(rightLoc[1] - 1);
				break;
			case 8:
				ld += Math.abs(leftLoc[1] - 2);
				rd += Math.abs(rightLoc[1] - 2);
				break;
			case 0:
				ld += Math.abs(leftLoc[1] - 3);
				rd += Math.abs(rightLoc[1] - 3);
				break;
		}
		
		if (ld < rd) return 'L';
		else if (ld > rd) return 'R';
		else return Character.toUpperCase(hand.charAt(0));
	}
	//손 위치 이동
	public static void moveHand(int[] handLoc, int num) {
		
		if (num == 1 || num == 4 || num == 7) handLoc[0] = 0;
		else if (num == 2 || num == 5 || num == 8 || num == 0) handLoc[0] = 1;
		else if (num == 3 || num == 6 || num == 9) handLoc[0] = 2;
		
		switch (num) {
			case 1: case 2: case 3:
				handLoc[1] = 0;
				break;
			case 4: case 5: case 6:
				handLoc[1] = 1;
				break;
			case 7: case 8:	case 9:
				handLoc[1] = 2;
				break;
			case 0:
				handLoc[1] = 3;
				break;
		}
	}
	
    public String solution(int[] numbers, String hand) {
        StringBuffer answer = new StringBuffer();
        
        for (int num : numbers) {
        	if (num == 2 || num == 5 || num == 8 || num == 0) {
        		char h = whichHand(num, hand);
        		
        		if (h == 'L') moveHand(leftLoc, num);
        		else moveHand(rightLoc, num);
        		
        		answer.append(h);
        		continue;
        	}
        	
        	switch (num) {
        		case 1:	case 4: case 7:
        			moveHand(leftLoc, num);
        			answer.append('L');
        			break;
        		case 3:	case 6:	case 9:
        			moveHand(rightLoc, num);
        			answer.append('R');
        			break;
        	}
        }
        
        return answer.toString();
    }
}