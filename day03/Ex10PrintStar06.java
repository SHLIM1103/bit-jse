package day03;
// 별찍기 예제 6번

import java.util.Scanner;
public class Ex10PrintStar06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("별찍기 6번");
        System.out.println("---------------------");

        System.out.print("숫자: ");
        int userNumber = scanner.nextInt();

        for(int i = userNumber ; i >= 1  ; i--) {
            String star = new String();

            // 공백 j
            for(int j = 1 ; j <= userNumber-i ; j++) {
                star += " ";
            }

            // 별 j
            for(int j = 1 ; j <= 2*i-1 ; j++) {
                star += "*" ;
            }
            System.out.println(star);
        }
        
        scanner.close();
    }
}
