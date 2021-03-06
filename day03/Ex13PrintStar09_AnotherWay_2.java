package day03;
// 별찍기 예제 9번_하나의 for문으로 짜기

import java.util.Scanner;
public class Ex13PrintStar09_AnotherWay_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("별찍기 9번");
        System.out.println("---------------------");

        System.out.print("숫자: ");
        int userNumber = scanner.nextInt();

        for(int i = 1 ; i <= 2 * userNumber -1 ; i++) {
            String star = new String();
            int controlI = 0 ;

            if(i < userNumber) {
                controlI = i ;

            }else {
                controlI = 2 * userNumber - i ;
            }
            // 공백을 담당하는 j for문
            for(int j = 1 ; j <= userNumber - controlI ; j++) {            // i 자리에 lowerI를 넣었음
                star += " ";
            }

            // 별을 담당하는 j for문
            for(int j = 1 ; j <= 2 * controlI - 1 ; j++) {
                star += "*" ;

            }

            System.out.println(star);
        }

        scanner.close();
    }
}