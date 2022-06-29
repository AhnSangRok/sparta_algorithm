public class run_36 {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        int[] left = {0,3}; //왼손의 위치 {x축,y축}
        int[] right = {2,3}; //오른손의 위치 {x축,y축}

        for(int i=0;i<numbers.length;i++) {
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7) { //1,4,7을 누를 경우
                left[0] = 0; //왼손을 사용한다. x축 이동
                switch(numbers[i]){ // 각 숫자에 따라 y축 이동
                    case 1:
                        left[1] = 0;
                        break;
                    case 4:
                        left[1] = 1;
                        break;
                    case 7:
                        left[1] = 2;
                        break;
                }
                answer+="L";
            }
            if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9) { //3,6,9를 누를 경우
                right[0] = 2;//오른손을 사용한다. x축 이동
                switch(numbers[i]){// 각 숫자에 따라 y축 이동
                    case 3:
                        right[1] = 0;
                        break;
                    case 6:
                        right[1] = 1;
                        break;
                    case 9:
                        right[1] = 2;
                        break;
                }
                answer+="R";
            }
            if(numbers[i]==2) { // 2를 누를때
                if((int)Math.abs(left[0]-1)+(int)Math.abs(left[1]) > (int)Math.abs(right[0]-1)+(int)Math.abs(right[1])) { //만약 오른쪽이 더 가까운 경우
                    answer+="R";
                    right[0]=1;
                    right[1]=0;
                }else if((int)Math.abs(left[0]-1)+(int)Math.abs(left[1]) < (int)Math.abs(right[0]-1)+(int)Math.abs(right[1])) {//만약 왼쪽이 더 가까운 경우
                    answer+="L";
                    left[0]=1;
                    left[1]=0;
                }else {
                    if(hand.equals("left")) { // 거리가 같고 왼손잡이인 경우
                        answer+="L";
                        left[0]=1;
                        left[1]=0;
                    }else { // 거리가 같고 오른손잡이인 경우
                        answer+="R";
                        right[0]=1;
                        right[1]=0;
                    }
                }
            }
            if(numbers[i]==5) {
                if((int)Math.abs(left[0]-1)+(int)Math.abs(left[1]-1) > (int)Math.abs(right[0]-1)+(int)Math.abs(right[1]-1)) {
                    answer+="R";
                    right[0]=1;
                    right[1]=1;
                }else if((int)Math.abs(left[0]-1)+(int)Math.abs(left[1]-1) < (int)Math.abs(right[0]-1)+(int)Math.abs(right[1]-1)) {
                    answer+="L";
                    left[0]=1;
                    left[1]=1;
                }else {
                    if(hand.equals("left")) {
                        answer+="L";
                        left[0]=1;
                        left[1]=1;
                    }else {
                        answer+="R";
                        right[0]=1;
                        right[1]=1;
                    }
                }
            }
            if(numbers[i]==8) {
                if((int)Math.abs(left[0]-1)+(int)Math.abs(left[1]-2) > (int)Math.abs(right[0]-1)+(int)Math.abs(right[1]-2)) {
                    answer+="R";
                    right[0]=1;
                    right[1]=2;
                }else if((int)Math.abs(left[0]-1)+(int)Math.abs(left[1]-2) < (int)Math.abs(right[0]-1)+(int)Math.abs(right[1]-2)) {
                    answer+="L";
                    left[0]=1;
                    left[1]=2;
                }else {
                    if(hand.equals("left")) {
                        answer+="L";
                        left[0]=1;
                        left[1]=2;
                    }else {
                        answer+="R";
                        right[0]=1;
                        right[1]=2;
                    }
                }
            }
            if(numbers[i]==0) {
                if((int)Math.abs(left[0]-1)+(int)Math.abs(left[1]-3) > (int)Math.abs(right[0]-1)+(int)Math.abs(right[1]-3)) {
                    answer+="R";
                    right[0]=1;
                    right[1]=3;
                }else if((int)Math.abs(left[0]-1)+(int)Math.abs(left[1]-3) < (int)Math.abs(right[0]-1)+(int)Math.abs(right[1]-3)) {
                    answer+="L";
                    left[0]=1;
                    left[1]=3;
                }else {
                    if(hand.equals("left")) {
                        answer+="L";
                        left[0]=1;
                        left[1]=3;
                    }else {
                        answer+="R";
                        right[0]=1;
                        right[1]=3;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        run_36 sol = new run_36();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.print(sol.solution(numbers,hand));
    }
}
