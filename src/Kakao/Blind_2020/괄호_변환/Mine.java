/**
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 */
package Kakao.Blind_2020.괄호_변환;

class Mine {
    public String solution(String p) {
        if (p.isEmpty())
            return p;

        String u = "", v = "";
        int l = 0, r = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(')
                l++;
            else
                r++;

            if (l == r) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }

        if (isRight(u))
            return u + solution(v);

        StringBuilder ret = new StringBuilder();
        ret.append('(').append(solution(v)).append(')');
        u = u.substring(1, u.length() - 1);
        u = reverse(u);
        ret.append(u);

        return ret.toString();
    }

    private String reverse(String u) {
        StringBuilder sb = new StringBuilder();
        for (char c : u.toCharArray())
            sb.append(c == '(' ? ')' : '(');

        return sb.toString();
    }

    private boolean isRight(String u) {
        int l = 0, r = 0;
        for (char c : u.toCharArray()) {
            if (c == '(')
                l++;
            else
                r++;

            if (r > l)
                return false;
        }

        return true;
    }
}