import java.util.*;
public class run_33 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] list = new int[n];
        int answer = 0;

        Arrays.sort(reserve);
        Arrays.sort(lost);

        for(int i=0;i<list.length;i++){ //모든학생이 체육복을 가지고 있다고 가정, 1을 대입(아직 점심시간에 도둑이 들기전)
            list[i]=1;
        }

        for(int i=0;i<lost.length;i++){ // 도둑이든 학생들은 값을 하나씩 빼준다
            list[lost[i]-1]--;
        }

        for(int i=0;i<reserve.length;i++){ //여벌을 가지고 있는 학생들은 하나씩 더해준다.
            list[reserve[i]-1]++;
        }

        for(int i=0;i<list.length;i++){
            if(i-1>0 && list[i] == 2 && list[i-1] == 0){ //i번째 학생이 여벌이 있지만 앞에있는 학생이 없을 경우
                list[i]--;
                list[i+1]++;
            }
            if(i+1<list.length && list[i] == 2 && list[i+1] == 0){ //i번째 학생이 여벌이 있지만 뒤에있는 학생이 없을 경우
                list[i]--;
                list[i+1]++;
            }
            if(i-1>0 && list[i] == 0 && list[i-1] == 2){  // i번째 학생이 체육복이 없고 앞에있는 학생이 있는경우
                list[i]++;
                list[i+1]--;
            }
            if(i+1<list.length && list[i] == 0 && list[i+1] == 2){ // i번째 학생이 체육복이 없고 뒤에있는 학생이 있는경우
                list[i]++;
                list[i+1]--;
            }
        }

        for(int i=0;i<list.length;i++){
            if(list[i] > 0){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        run_33 sol = new run_33();
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        System.out.print(sol.solution(5,lost,reserve));
    }
}
