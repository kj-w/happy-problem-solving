package programmers.q42888;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** https://school.programmers.co.kr/learn/courses/30/lessons/42888 */
/** 오픈채팅방 */
public class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nickName = new HashMap<>();

        List<String> history = new ArrayList<>();
        String[] template = {"님이 들어왔습니다.", "님이 나갔습니다."};
        for (String r : record) {
            String[] s = r.split(" ");

            switch (s[0]) {
                case "Enter":
                    nickName.put(s[1], s[2]);
                    history.add(s[1] + template[0]);
                    break;
                case "Leave":
                    history.add(s[1] + template[1]);
                    break;
                case "Change":
                    nickName.put(s[1], s[2]);
            }
        }

        return history.stream()
                .map(line -> {
                    String uid = line
                            .replace(template[0], "")
                            .replace(template[1], "");
                    return line.replace(uid, nickName.get(uid));
                })
                .collect(Collectors.toList()).toArray(String[]::new);
    }
}
