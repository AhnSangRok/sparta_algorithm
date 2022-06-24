import java.util.*;

class run_04 {
    public String solution(String[] participant, String[] completion) {

        String answer = "";
        HashMap<String, Integer> check = new HashMap<>();
        //효율성이 요구되는 문제이니 만큼 HashMap을 사용했다.

        for (String player : participant) check.put(player, check.getOrDefault(player, 0) + 1);
        //일단 participant에 있는 참가자의 이름을 check 해쉬의 Key로 넣고 getOrDefault()를 사용해 동명이인이 있을 경우를 대비해 값을 달리했다.
        System.out.print(check);

        for (String player : completion) check.put(player, check.get(player) - 1);
        //completion에 있는 참가자를 확인해 있을 경우 해당 Key의 값을 -1 한다.
        System.out.print(check);

        for (String key : check.keySet()) {
            if (check.get(key) != 0){
                answer = key;
            }
        }
        //KeySet()을 이용해 Key값을 가져와 해당 값이 0이 아닐 경우를 찾아 Key를 answer에 넣어주었다.

        return answer;
    }
    public static void main(String[] args) {
        String[] str1 = {"leo", "kiki", "eden","leo"};
        String[] str2 = {"eden", "kiki", "leo"};

        run_04 sol = new run_04();
        System.out.print(Arrays.toString(new String[]{sol.solution(str1, str2)}));
    }
}
