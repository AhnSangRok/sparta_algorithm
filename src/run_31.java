import java.util.*;
public class run_31 {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];
        //에라토스테네스의 체를 이용한 풀이
        for(int i=2;i<=n;i++){
            arr[i] = i;
        }

        for(int i=2;i<=n;i++){
            if(arr[i]==0){
                continue;
            }
            for(int j=i*2;j<=n;j+=i){
                arr[j]=0;
            }
        }

        for(int i=2;i<=n;i++){
            if(arr[i]!=0){
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        run_31 sol = new run_31();
        System.out.print(sol.solution(10));
    }
}
