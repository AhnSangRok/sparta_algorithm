import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class ch02_spring_homework_taxi {
    public String taxi(String taxi_number,int fuel,int speed,int dist,int cost,int cost_dist,String condition) {
        Random random = new Random();
        Scanner scn = new Scanner(System.in);
        int abb_move = 0; //추가된 거리
        int count = 0;
        int now_cost = 0; //현재 요금
        String dest = ""; //목적지
        int dest_dist = 0; //목적지 거리
        String str = "운행을 종료합니다.";

        System.out.println("현재 정보");
        System.out.printf("택시번호 : %s | 주유량 : %d | 현재속도 : %d | 목적지 : %s | 기본거리 : %d | 목적지까지 거리 : %d | 기본 요금 : %d | 거리당 요금 : %d | 상태 : %s\n",taxi_number,fuel,speed,dest, dist,dest_dist,cost,cost_dist, condition);

        while(true){
            int use_fuel = random.nextInt(10)+1;
            int now_move = 0;

            //사용한 연료
            if (fuel - use_fuel<=0){
                System.out.printf("%d만큼 연료를 사용했다.",fuel);
                fuel = 0;
            }else{
                fuel -= use_fuel;
                System.out.printf("%d만큼 연료를 사용했다.\n",use_fuel);
            }

            //출발하기전 연료 체크
            if (fuel < 10 && fuel >= 0){
                System.out.printf("현재 연료가 %d 남았습니다. 주유하는 것을 권장합니다.\n",fuel);
                System.out.println("주유하시겠습니까? y|n");
                String check = scn.next();
                if (check.equals("y")){
                    System.out.println("주유할 양을 정해주세요.");
                    int refuel = scn.nextInt();
                    fuel += refuel;
                    System.out.printf("주유한 양 : %d | 현재 주유량 : %d | 운행을 계속합니다.",refuel,fuel);
                }else {
                    System.out.println("운행을 계속합니다.");
                }
            }else if (fuel < 0) {
                System.out.println("현재 연료가 없습니다. 운행을 종료하고 차고지로 이동합니다.");
                fuel = 0;
                condition = "차고지행";
                break;
            }

            //손님 이벤트
           if (condition.equals("일반")){
               System.out.println("손님이 보인다 태울까? y|n");
               String yn = scn.next();
               if (yn.equals("y")) {
                   count++; //운행 횟수
                   System.out.printf("%d번째 운행\n", count);
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
                       now_cost += cost*10;
                       dest_dist -= dist;
                   }

               }else {
                   System.out.println("차가 빠져나기 힘들다. 아쉽지만 다음 손님을 기다리자");
                   System.out.println("=================================================================================================");
                   continue;
               }
           }

            //출발! 속도 변경
            System.out.printf("이제 출발 합니다. 변속할 속도를 말씀해주세요.(현재 속도 %dkm)\n",speed);
            int shift = scn.nextInt();
            if ((speed + shift) <= 0){
                System.out.println("이런 기어를 넣지 않았습니다. 변속할 속도를 말씀해주세요.");
                shift = scn.nextInt();
                speed += shift;
                if ((speed + shift) <= 0){
                    System.out.println("현재 택시에 문제가 생겼습니다. 운행을 종료하고 차고지로 이동합니다.");
                    condition = "차고지행";
                    speed = 0;
                    break;
                }
            }else{
                speed += shift;
                System.out.printf("목적지로 출발합니다. 현재 속도는 %d km 입니다.\n",speed);
            }
            now_move = random.nextInt(10)+1;
            if (dest_dist-now_move > 0){
                dest_dist -= now_move;
                now_cost += cost_dist*now_move;
                System.out.printf("현재 %dkm만큼 이동했습니다. 남은 이동 거리 %d입니다. 현재 요금 %d\n",now_move,dest_dist,now_cost);
            }else{
                now_cost += cost_dist*dest_dist;
                System.out.printf("목적지에 도착했습니다. 최종금액은 %d원 입니다.\n",now_cost);
                condition = "일반";
                dest_dist = 0;
            }

            System.out.printf("%d 번째 운행 정보\r",count);
            System.out.printf("택시번호 : %s | 주유량 : %d | 현재속도 : %d | 목적지 : %s | 기본거리 : %d | 목적지까지 거리 : %d | 기본 요금 : %d | 거리당 요금 : %d | 상태 : %s \n",taxi_number,fuel, speed,dest, dist,dest_dist,cost,cost_dist, condition);

            System.out.println("계속 운행하시겠습니까? y|n");
            String yorn = scn.next();
            if (yorn.equals("n")){
                System.out.println("==========================================================================================================================================");
                break;
            }
            System.out.println("==========================================================================================================================================");
        }
        System.out.printf("택시번호 : %s | 주유량 : %d | 현재속도 : %d | 마지막 목적지 : %s | 기본거리 : %d | 목적지까지 거리 : %d | 기본 요금 : %d | 거리당 요금 : %d | 상태 : %s | 운행 횟수 : %d\n",taxi_number,fuel, speed,dest, dist,dest_dist,cost,cost_dist, condition, count);

        return str;
    }

    public static void main(String[] args) {
        ch02_spring_homework_taxi sol = new ch02_spring_homework_taxi();
        Scanner scn = new Scanner(System.in);


        String taxi_number = UUID.randomUUID().toString(); // UUID로 고유한 번호 생성
        taxi_number = taxi_number.replace("[-_.]","");
        taxi_number = taxi_number.substring(0,8);
        System.out.printf("택시 번호 : %s \n", taxi_number);

        System.out.print("현재 연료 : ");
        int fuel = scn.nextInt();
        System.out.print("\r");

        System.out.print("현재 속도 : ");
        int speed = scn.nextInt();
        System.out.print("\r");

        System.out.print("기본거리 : "); //1km 단위
        int dist = scn.nextInt();
        System.out.print("\r");

        System.out.print("기본 요금 : ");
        int cost = scn.nextInt();
        System.out.print("\r");

        System.out.print("거리당 요금 : "); //100m 단위
        int cost_dist = scn.nextInt();
        System.out.print("\r");

        String condition = "일반";
        System.out.printf("현재 상태 : %s",condition);
        System.out.print("\r");

        System.out.println("========================================================================================");
        System.out.println(sol.taxi(taxi_number, fuel,speed,dist,cost, cost_dist, condition));
    }
}
