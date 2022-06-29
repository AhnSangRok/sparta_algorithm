import java.util.*;
public class run_37 {
    public int solution(String dartResult) {
//        1.다트 게임은 총 3번의 기회로 구성된다.
//                각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
//                점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
//        2.옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
//                스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
//        3.스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
//        4.스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
//        5.Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
//        6.스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        char[] arr = dartResult.toCharArray();

        for(int i=0;i<arr.length;i++){
            switch(arr[i]){ // 각 점수, 영역, 상 옵션 별로 나눴다.
                case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                    if(arr[i] == '1' && arr[i+1] == '0'){
                        list.add(10);
                        i++;
                    }else{
                        list.add(Character.getNumericValue(arr[i]));
                    }
                    break;
                case 'S':case 'D':case 'T':
                    switch(arr[i]){
                        case 'S':
                            list.set(list.size()-1,list.get(list.size()-1));
                            break;
                        case 'D':
                            list.set(list.size()-1,list.get(list.size()-1)*list.get(list.size()-1));
                            break;
                        case 'T':
                            list.set(list.size()-1,list.get(list.size()-1)*list.get(list.size()-1)*list.get(list.size()-1));
                            break;
                    }
                    break;
                case '*':case '#':
                    switch(arr[i]){
                        case '*':
                            if(list.size()-1 == 0){
                                list.set(list.size()-1,list.get(list.size()-1)*2);
                            }else{
                                list.set(list.size()-2,list.get(list.size()-2)*2);
                                list.set(list.size()-1,list.get(list.size()-1)*2);
                            }
                            break;
                        case '#':
                            list.set(list.size()-1,list.get(list.size()-1)*(-1));
                            break;
                    }
                    break;
            }
        }

        for(int i=0;i<list.size();i++){
            answer += list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        run_37 sol =new run_37();
        String dartResult = "1D2S#10S";
        System.out.print(sol.solution(dartResult));
    }
}
