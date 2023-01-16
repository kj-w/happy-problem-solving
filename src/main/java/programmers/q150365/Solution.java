package programmers.q150365;

/** https://school.programmers.co.kr/learn/courses/30/lessons/150365 */
/** 미로 탈출 명령어 */
class Solution {

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int distance = distance(x, y, r, c);
        if (distance > k || (distance & 1) != (k & 1))
            return "impossible";

        char[] commands = {'d', 'l', 'r', 'u'};
        int[][] moves = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};

        String answer = "";
        while (k > 0) {
            for (int i=0; i<commands.length; i++) {
                int nx = x + moves[i][0];
                int ny = y + moves[i][1];

                if (1 <= nx && nx <= n && 1 <= ny && ny <= m && distance(nx, ny, r, c) < k) {
                    answer += commands[i];
                    x = nx;
                    y = ny;
                    k--;
                    break;
                }
            }
        }

        return answer;
    }

    private int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
