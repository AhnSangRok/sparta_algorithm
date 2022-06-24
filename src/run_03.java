import java.util.*;
class run_03 {
    public String solution(int n) {
        ArrayList<String> str = new ArrayList<>();
        String answer = "";

        str.add("수");
        str.add("박");
        //list에 각 인덱스에 "수", "박"을 넣어주었다.

        for(int i=0;i<n;i++){
            answer = answer + str.get(i%2);
        }
        //n의 수 만큼 수박을 반복해야 하므로 for문으로 str에 있는 값을 가져와 answer로 넣었다.

        return answer;
    }

    public static void main(String[] args) {
        run_03 sol = new run_03();
        System.out.print(sol.solution(3));
    }
}
