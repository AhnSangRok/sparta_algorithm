class run_01 {
    public String solution(int a, int b) {
        String answer = "";
        String[][] m = {{"FRI","SAT","SUN","MON","TUE","WED","THU"}
                ,{"MON","TUE","WED","THU","FRI","SAT","SUN"}
                ,{"TUE","WED","THU","FRI","SAT","SUN","MON"}
                ,{"FRI","SAT","SUN","MON","TUE","WED","THU"}
                ,{"SUN","MON","TUE","WED","THU","FRI","SAT"}
                ,{"WED","THU","FRI","SAT","SUN","MON","TUE"}
                ,{"FRI","SAT","SUN","MON","TUE","WED","THU"}
                ,{"WED","THU","FRI","SAT","SUN","MON","TUE"}
                ,{"THU","FRI","SAT","SUN","MON","TUE","WED"}
                ,{"SAT","SUN","MON","TUE","WED","THU","FRI"}
                ,{"TUE","WED","THU","FRI","SAT","SUN","MON"}
                ,{"THU","FRI","SAT","SUN","MON","TUE","WED"}};
        //무식하지만 간단하게 2016년도 요일을 1월부터 12월까지 1일부터 차례대로 2차원 배열에 넣었다.
        if(b%7 == 0){
            answer += m[a-1][6];
        }else{
            answer += m[a-1][b%7 - 1];
        }
        //배열을 토대로 a,b값을 넣어 월 일을 찾을 수 있도록 했다.
        return answer;
    }

    public static void main(String[] args) {
        run_01 sol = new run_01();
        System.out.print(sol.solution(5, 24));
    }
}
