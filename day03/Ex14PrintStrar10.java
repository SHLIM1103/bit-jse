package day03;

import java.util.Scanner;
public class Ex14PrintStrar10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("별찍기 10번");
        System.out.println("---------------------");

        System.out.print("숫자: ");
        int userNumber = scanner.nextInt();

        for(int i = 1 ; i <= 2 * userNumber - 1 ; i ++) {
            String star = new String();

            if(i == 1 || i == 2 * userNumber -1 ) {
                // 맨 처음이나 마지막줄

                // 별을 담당하는 j for문
                for(int j = 1 ; j <= 2 * userNumber - 1 ; j++) {
                    star += "*" ;
                }
            }else if(i < userNumber) {
                // 맨 첫줄을 제외한 윗부분
                // userNumber가 5이면, i가 2,3,4일때 여기로 들어온다.

                // 왼쪽 별을 담당하는 j for문
                for(int j = i ; j <= userNumber ; j++) {
                    star += "*" ;
                }

                int upperI = i - 1 ;        // i의 바로 앞수
                // 가운데 공백을 담당하는 j for문
                for(int j = 1 ; j <= (2* upperI -1) ; j++) {
                    star += " " ;
                }

                // 오른쪽 별을 담당하는 j for문
                for(int j = i ; j <= userNumber ; j++) {
                    star += "*" ;
                }

            }else {
                // 맨 마지막줄을 제외한 아랫부분
                // userNumber가 5이면, i가 5,6,7,8일때 여기로 들어온다.

                int lowerI = i - userNumber + 1 ;

                // 왼쪽 별을 담당하는 j for문
                for(int j = 1 ; j <= lowerI ; j++) {
                    star += "*" ;
                }

                // 전체폭을 계산하여 저장하는 maxWidth 변수
                int maxWidth = (2 * userNumber) - 1 ;
                // 공백폭을 계산하여 저장하는 spaceWidth 변수
                int spaceWidth = maxWidth - (2 * lowerI) ;

                // 가운데 공백을 담당하는 j for문
                for(int j = 1 ; j <= spaceWidth ; j++) {
                    star += " " ;
                }
                
                // 오른쪽 별을 담당하는 j for문
                for(int j = 1 ; j <= lowerI ; j++) {
                    star += "*" ;
                }
            }

            System.out.println(star);
        }  

        scanner.close();
    }
}