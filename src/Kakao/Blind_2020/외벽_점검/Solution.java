/**
 * https://programmers.co.kr/learn/courses/30/lessons/60062
 */
package Kakao.Blind_2020.외벽_점검;

class Solution {
    int n;
    int[] weak;
    int[] dist;
    boolean[] isCovered;
    boolean[] isUsed;
    int ans = Integer.MAX_VALUE;

    public int solution(int N, int[] Weak, int[] Dist) {
        n = N;
        weak = Weak;
        dist = Dist;
        isCovered = new boolean[n];
        isUsed = new boolean[dist.length];

        //dist를 내림차순으로 정렬
        int l = 0, r = dist.length - 1;
        while (l < r) {
            swap(l, r);
            l++;
            r--;
        }

        for (int num = 0; num < weak.length; num++)
            backtrack(num, 0, 0);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // num: 몇번째 외벽에 배치할지
    // p: 몇번 친구를 배치할지
    // cover: 커버했는 외벽이 몇개인지
    private void backtrack(int num, int p, int cover) {
        if (cover == weak.length) {
            ans = Math.min(ans, p);
            return;
        }

        if (isCovered[weak[num]]) {
            backtrack((num + 1) % weak.length, p, cover + 1);
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (isUsed[i])
                continue;
            isUsed[i] = true;
            int d = dist[i];
            for (int j = weak[num]; j <= weak[num] + d; j++)
                isCovered[j % n] = true;

            backtrack((num + 1) % weak.length, p + 1, cover + 1);

            for (int j = weak[num]; j <= weak[num] + d; j++)
                isCovered[j % n] = false;
            isUsed[i] = false;
        }
    }

    private void swap(int l, int r) {
        int temp = dist[l];
        dist[l] = dist[r];
        dist[r] = temp;
    }
}