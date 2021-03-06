package day06;
// 정적 할당의 경우, 만약 배열의 크기보다 많은 학생을 입력하고자 할때

// 1. 더이상 입력할 수 없습니다.
// 2. 가장 앞에 있던 값을 지우고 그 다음 인덱스부터는 하나씩 당겨서 가장 뒷칸에 넣는 방법

import java.util.Scanner;
import util.ScannerUtil;

// "1. 더이상 입력할 수 없습니다" 방법을 코드로 구현한 프로그램
public class Ex07StaticArray01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] studentArray = new Student[4];

        while (true) {
            System.out.println("비트 학생관리 프로그램");
            System.out.println("(1)입력 (2)출력 (3)종료");
            int userChoice = ScannerUtil.nextInt(scanner, " > ", 1, 3);

            if (userChoice == 1) {
                // 새로운 학생을 입력할 때에는 빈 인덱스를 찾고
                // 빈 인덱스가 존재하면 입력
                // 빈 인덱스가 존재하지 않으면 "더이상 입력할 수 없습니다." 라고 출력

                // 빈 인덱스를 저장할 int index
                int index = -1;
                // for문을 이용해서 빈칸을 찾아보자.
                // 빈칸이라 함은 아직 아무런 정보가 입력이 안되어 있다.
                // 즉 해당칸이 초기화가 안되어 있다 라는 의미이다.
                // 즉, index는 해당 칸이 null인 index를 찾아 저장하면 된다!

                // null인 index를 찾는 for문
                for (int i = 0; i < studentArray.length; i++) {
                    if (studentArray[i] == null) {
                        // i번째 칸이 null이므로, 입력할 위치는 i번째 칸이 되며,
                        // 더이상 확인할 필요 없으므로 break 실행
                        index = i;
                        break;
                    }
                }
                // 만약 index가 -1이라는 것은 모든 칸이 null이 아니다.
                // 즉, 모든 칸에 학생의 정보가 존재하므로 메시지만 출력하고
                // 그 외 일때만 studentArray[index]에 정보를 입력하면 된다!
                if (index == -1) {
                    // 배열의 모든 칸에 정보가 들어있는 것이므로 메시지만 출력
                    System.out.println("더이상 입력할 수 없습니다.");
                } else {
                    // index번의 칸이 비었으므로 해당 칸에 학생 정보 입력
                    // 초기화
                    studentArray[index] = new Student();

                    System.out.print("번호: ");
                    studentArray[index].setId(scanner.nextInt());

                    System.out.print("이름: ");
                    studentArray[index].setName(ScannerUtil.nextLine(scanner));

                    studentArray[index].setKorean(ScannerUtil.nextInt(scanner, "국어: ", 0, 100));

                    studentArray[index].setEnglish(ScannerUtil.nextInt(scanner, "영어: ", 0, 100));

                    studentArray[index].setMath(ScannerUtil.nextInt(scanner, "수학: ", 0, 100));
                }
            } else if (userChoice == 2) {
                // for문을 사용해서 해당칸이 null이 아니면 출력
                for (int i = 0; i < studentArray.length; i++) {
                    if (studentArray[i] != null) {
                        System.out.printf("번호: %d, 이름: %s\n", studentArray[i].getId(), studentArray[i].getName());
                        System.out.printf("국어: %03d점, 영어: %03d점, 수학: %03d점\n", studentArray[i].getKorean(),
                                studentArray[i].getEnglish(), studentArray[i].getMath());

                        int sum = studentArray[i].getKorean() + studentArray[i].getEnglish() + studentArray[i].getMath();
                        double ave = sum / 3.0;
                        System.out.printf("총점: %d점, 평균: %.2f점\n", sum, ave);
                        System.out.println();
                    }
                }
            } else if (userChoice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }

        scanner.close();
    }
}
