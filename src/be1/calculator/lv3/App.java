package be1.calculator.lv3;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CalculatorLv3<Number> calc3 = new CalculatorLv3<>();

        String input;

        System.out.println("📌 해당 계산기는 Lv3. Enum, 제네릭, 람다 & 스트림을 사용한 계산기입니다.");
        System.out.println("----------------------------------------------------------------");
        System.out.println("| 1️⃣ 정수 계산뿐만 아니라, 실수 계산도 가능합니다.                    |");
        System.out.println("| 2️⃣ 사용 가능한 사칙연산은 다음과 같습니다. (+, -, *, /)            |");
        System.out.println("----------------------------------------------------------------");
        System.out.println();

        do {
            System.out.println("================================================================================");
            System.out.println("                                Menu                                            ");
            System.out.println("계산: [calc] | 결과출력: [show] | 결과삭제: [delete] | 필터링: [filter] | 종료: [exit]");
            System.out.print("                     😀 명령어를 입력해주세요 😀                      \n:");
            input = sc.nextLine();

            // 계산
            if (input.equals("calc")) {
                try {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    double num1 = sc.nextDouble();

                    System.out.print("두 번째 숫자를 입력하세요: ");
                    double num2 = sc.nextDouble();

                    sc.nextLine(); // 버퍼 비우기

                    System.out.print("사칙연산 기호를 입력하세요 [ +, -, *, / ]: ");
                    char op = sc.nextLine().charAt(0);

                    OperatorType operatorType = OperatorType.getByOp(op);

                    Double result = calc3.calc(num1, num2, operatorType);
                    System.out.printf("😊 결과 : %.3f\n", result);

                } catch (Exception e) {
                    System.out.println("오류: " + e.getMessage());
                    continue;
                }
            }
            // 결과 출력
            else if (input.equals("show")) {
                List<Double> list =calc3.getList();
                if (list.isEmpty()) {
                    System.out.println("❗ 저장된 값이 존재하지 않습니다.");
                }
                else {
                    System.out.println("🧾 저장된 결과 목록입니다.");
                    for (int i = 0; i < list.size(); ++i) {
                        System.out.printf("%d: %.3f%n", i + 1, list.get(i));
                    }
                }
            }
            // 결과 삭제
            else if (input.equals("delete")) {
                calc3.removeResult();
            }
            else if (input.equals("filter")) {
                System.out.println("입력된 수보다 큰 값만을 출력합니다.");
                System.out.println("숫자를 입력해주세요: ");
                double input2 = sc.nextDouble();

                sc.nextLine();

                calc3.showGreater(input2);
            }
            else if (!input.equals("exit")) {
                System.out.println("❌" + input + "은 올바르지 않은 명령어입니다. 다시 입력해주세요 ❌");
            }

            System.out.println();

        } while (!input.equals("exit"));

        System.out.println("===============================================================");
        System.out.println("계산기 종료");
        sc.close();
    }
}
