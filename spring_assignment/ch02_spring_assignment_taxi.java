import java.util.Random;
import java.util.Scanner;

public class ch02_spring_assignment_taxi {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        taxi_info taxi200 = new taxi_info();
        taxi200.taxi_num(200);
        taxi200.taxi_info();

        while (true){
            taxi200.fuel();
            taxi200.passenger();
            taxi200.speed();
            taxi200.now_move();
            taxi200.showInfo();
            System.out.println("계속 운행하시겠습니까? y|n");
            String yorn = scn.next();
            if (yorn.equals("n")){
                taxi200.condition(yorn);
                System.out.println("==========================================================================================================================================");
                break;
            }
            System.out.println("==========================================================================================================================================");
        }
        taxi200.showInfo();
    }


    public static class taxi_info {
        Random random = new Random();
        Scanner scn = new Scanner(System.in);
        private int taxi_num;
        int fuel;
        int speed;
        int dist;
        int cost;
        int cost_dist;
        int now_cost = 0; //현재 요금
        String dest = ""; //목적지
        int dest_dist = 0; //목적지 거리
        String condition;
        int now_move = 0;
        public void taxi_num(int taxi_num) {
            this.taxi_num = taxi_num;
        }
        public void taxi_info(){
            System.out.print("현재 연료 : ");
            fuel = scn.nextInt();
            System.out.print("\r");

            System.out.print("현재 속도 : ");
            speed = scn.nextInt();
            System.out.print("\r");

            System.out.print("기본거리 : "); //1km 단위
            dist = scn.nextInt();
            System.out.print("\r");

            System.out.print("기본 요금 : ");
            cost = scn.nextInt();
            System.out.print("\r");

            System.out.print("거리당 요금 : "); //100m 단위
            cost_dist = scn.nextInt();
            System.out.print("\r");

            condition = "일반";
            System.out.printf("현재 상태 : %s",condition);
            System.out.print("\r");
        }

        public void fuel(){
            int use_fuel = random.nextInt(10)+1;
            if (fuel - use_fuel<=0){
                System.out.printf("%d만큼 연료를 사용했다.",fuel);
                fuel = 0;
            }else{
                fuel -= use_fuel;
                System.out.printf("%d만큼 연료를 사용했다.\n",use_fuel);
            }
            if (fuel < 10 && fuel > 0){
                System.out.printf("현재 연료가 %d 남았습니다. 주유하는 것을 권장합니다.\n",fuel);
                System.out.println("주유하시겠습니까? y|n");
                String check = scn.next();
                if (check.equals("y")){
                    System.out.println("주유할 양을 정해주세요.");
                    int refuel = scn.nextInt();
                    fuel += refuel;
                    System.out.printf("주유한 양 : %d | 현재 주유량 : %d | 운행을 계속합니다.\n",refuel,fuel);
                }else {
                    System.out.println("운행을 계속합니다.");
                }
            }else if (fuel < 0) {
                System.out.println("현재 연료가 없습니다. 운행을 종료하고 차고지로 이동합니다.");
                fuel = 0;
                condition = "차고지행";
            }
        }
        public void passenger(){
            if (condition.equals("일반")){
                System.out.println("손님이 보인다 태울까? y|n");
                String yn = scn.next();
                if (yn.equals("y")) {
                    condition = "운행중";
                    System.out.print("목적지는 어디입니까? : ");
                    dest = scn.next();
                    System.out.print("\r");

                    dest_dist = random.nextInt(30)+10;
                    System.out.printf("목적지까지 거리는 %dkm 정도입니다.\n", dest_dist);
                    System.out.print("\r");

                    if (dist < dest_dist) {
                        System.out.printf("기본거리보다 %dkm정도 멀어서 추가요금이 발생합니다.\n", dest_dist - dist);
                        now_move += dist;
                        now_cost += cost;
                        dest_dist -= dist;
                    }else{
                        System.out.printf("기본거리 안에 있으므로 기본 요금만 발생합니다. \n", cost);
                        now_move += dist;
                        now_cost += cost;
                        if (dest_dist - dist < 0){
                            dest_dist = 0;
                        }else {
                            dest_dist -= dist;
                        }

                    }

                }else {
                    System.out.println("차가 빠져나기 힘들다. 아쉽지만 다음 손님을 기다리자");
                    System.out.println("=================================================================================================");
                }
            }
        }
        public void speed(){
            if (condition.equals("일반")) {
                System.out.printf("이제 출발 합니다. 변속할 속도를 말씀해주세요.\n",speed);
                int shift = scn.nextInt();
                if ((speed + shift) <= 0){
                    System.out.println("이런 기어를 넣지 않았습니다. 변속할 속도를 말씀해주세요.");
                    shift = scn.nextInt();
                    speed += shift;
                    if ((speed + shift) <= 0){
                        System.out.println("현재 택시에 문제가 생겼습니다. 운행을 종료하고 차고지로 이동합니다.");
                        condition = "차고지행";
                        speed = 0;
                    }
                }else{
                    speed += shift;
                    System.out.printf("목적지로 출발합니다. 현재 속도는 %d km 입니다.\n",speed);
                }
            }else {
                System.out.printf("계속해서 이동합니다. 변속할 속도를 말씀해주세요.\n",speed);
                int shift = scn.nextInt();
                if ((speed + shift) <= 0){
                    System.out.println("이런 기어를 넣지 않았습니다. 변속할 속도를 말씀해주세요.");
                    shift = scn.nextInt();
                    speed += shift;
                    if ((speed + shift) <= 0){
                        System.out.println("현재 택시에 문제가 생겼습니다. 운행을 종료하고 차고지로 이동합니다.");
                        condition = "차고지행";
                        speed = 0;
                    }
                }else{
                    speed += shift;
                    System.out.printf("목적지로 향합니다. 현재 속도는 %d km 입니다.\n",speed);
                }
            }{

            }
        }
        public void now_move(){
            now_move = random.nextInt(10)+1;
            if (dest_dist-now_move > 0){
                dest_dist -= now_move;
                now_cost += cost_dist*now_move;
                System.out.printf("현재 %dkm만큼 이동했습니다. 남은 이동 거리는 %dkm입니다. 현재 요금 %d\n",now_move,dest_dist,now_cost);
            }else{
                now_cost += cost_dist*dest_dist;
                System.out.printf("목적지에 도착했습니다. 최종금액은 %d원 입니다.\n",now_cost);
                condition = "일반";
                dest_dist = 0;
            }
        }
        public void condition(String check){
            if (check.equals("n")){
                condition = "일반";
            }
        }
        public void showInfo(){
            System.out.printf("택시번호 : %s | 주유량 : %d | 현재속도 : %d | 목적지 : %s | 기본거리 : %d | 목적지까지 거리 : %d | 기본 요금 : %d | 거리당 요금 : %d | 상태 : %s \n",taxi_num,fuel, speed,dest, dist,dest_dist,cost,cost_dist, condition);
        }
    }

}