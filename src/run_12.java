public class run_12 {
    public boolean solution(int x) { //하샤드 수
        boolean answer = true;
        int num = x;
        int n = 0;
        int nam;

        while(true){
            nam = num % 10;
            n += nam;
            //각 자리의 수를 더한다.
            if(num < 10){
                break;
                //만약 num이 1의 자리 수라면 빠져나간다.
            }
            num /= 10;
        }

        if(x % n != 0){
            answer = false;
            //만약 각자리의 수를 더한 값으로 받은 수가 나눠 떨어지지 않는다면 하샤드 수가 아니므로 false를 출력한다.
        }

        return answer;
    }

    public static void main(String[] args) {
        run_12 sol = new run_12();
        System.out.print(sol.solution(22));
    }
}
