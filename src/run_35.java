import java.util.*;
public class run_35 {
    public String solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        ArrayList<String> arr = new ArrayList<>();
        int num = 1;

        for(int i=1;i<n;i++){
            num *= 2; //한줄이 모두 칠해져 있을 경우의 값
        }

        for(int i=0;i<n;i++){
            String str = "";
            int div = num;
            int number1 = arr1[i];
            int number2 = arr2[i];
            while(true){
                if(number1/div >= 1 || number2/div >= 1){ //맨 왼쪽부터 두 지도에 하나라도 #이 있는지 확인
                    str += "#";
                    number1 %= div;
                    number2 %= div;
                    div /= 2;
                }else{ // 두개다 없다면 공백을 넣는다.
                    str += " ";
                    div /= 2;
                }
                if(div < 1){ //오른쪽 끝까지 확인했다면 나간다.
                    break;
                }
            }
            arr.add(str); //해독한 라인을 넣는다.
        }

        for(int i=0;i<answer.length;i++){
            answer[i] = arr.get(i);
        }

        return Arrays.toString(answer);
    }

    public static void main(String[] args) {
        run_35 sol = new run_35();
        int n = 5;
        int [] arr1 = {9, 20, 28, 18, 11};
        int [] arr2 = {30, 1, 21, 17, 28};
        System.out.print(sol.solution(n,arr1,arr2));
    }
}
