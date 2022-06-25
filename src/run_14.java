public class run_14 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_x = sizes[0][0];
        int max_y = sizes[0][1];

        if (sizes.length > 1) {
            for (int i = 0; i < sizes.length; i++) {
                if (sizes[i][0] < sizes[i][1]) {
                    int temp = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = temp;
                    //2차 배열에 있는 수를 비교해 큰수를 앞으로 오도록 했다.
                }
                if (max_x < sizes[i][0]) {
                    max_x = sizes[i][0];
                    //가로축에서 가장 긴 수를 찾는다.
                }
                if (max_y < sizes[i][1]) {
                    max_y = sizes[i][1];
                    //세로축에서 가장 긴 수를 찾는다.
                }
            }
            answer = max_x * max_y;
        } else {
            answer = sizes[0][1] * sizes[0][0];
            //sizes에 값이 1개만 있는 경우
        }

        return answer;
    }


    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        run_14 sol = new run_14();
        System.out.print(sol.solution(sizes));
    }
}
