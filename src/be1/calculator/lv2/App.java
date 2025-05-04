package be1.calculator.lv2;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // CaculatorLv2 인스턴스 생성
        CalculatorLv2 calc2 = new CalculatorLv2();

        String input;

        System.out.println("📌 해당 계산기는 Lv2. 클래스를 사용한 사칙연산을 수행하는 계산기입니다.");
        System.out.println("-------------------------------------------------------------");
        System.out.println("| 1️⃣ 0을 포함한 양의 정수를 입력받을 수 있습니다.                 |");
        System.out.println("| 2️⃣ 사용 가능한 사칙연산은 다음과 같습니다. (+, -, *, /)         |");
        System.out.println("-------------------------------------------------------------");
        System.out.println();

        do {
            System.out.println("===============================================================");
            System.out.println("                            Menu                               ");
            System.out.println("계산: [calc] | 결과출력: [show] | 결과삭제: [delete] | 종료: [exit]");
            System.out.print("                 😀 명령어를 입력해주세요 😀                      \n:");
            input = sc.nextLine();

            // 계산
            if (input.equals("calc")) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = sc.nextInt();

                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt();

                sc.nextLine(); // 버퍼 비우기

                System.out.print("사칙연산 기호를 입력하세요 [ +, -, *, / ]: ");
                char op = sc.nextLine().charAt(0);

                try {
                    int result = calc2.calc(num1, num2, op);
                    System.out.println("😊 결과 : " + result);

                } catch (Exception e) {
                    System.out.println("오류: " + e.getMessage());
                }
            }
            // 결과 출력
            else if (input.equals("show")) {
                List<Integer> list = calc2.getList();

                if (list.isEmpty()) System.out.println("❗ 저장된 값이 존재하지 않습니다.");
                else {
                    System.out.println("🧾 저장된 결과 목록입니다.");
                    for (int i = 0; i < list.size(); ++i) {
                        System.out.println((i+1) + ": " + list.get(i));
                    }
                }
            }
            // 결과 삭제
            else if (input.equals("delete")) {
                calc2.removeResult();
            }
            else if (!input.equals("exit")) {
                System.out.println("❌ 올바르지 않은 명령어입니다. 다시 입력해주세요 ❌");
            }

            System.out.println();

        } while (!input.equals("exit"));

        System.out.println("===============================================================");
        System.out.println("계산기 종료");
        sc.close();
    }
}
