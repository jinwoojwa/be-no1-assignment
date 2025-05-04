package be1.calculator.lv1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("📌 해당 계산기는 Lv1. 클래스 없이 사칙연산을 수행하는 계산기입니다.");
        System.out.println("----------------------------------------------------------");
        System.out.println("| 1️⃣ 0을 포함한 양의 정수를 입력받을 수 있습니다.              |");
        System.out.println("| 2️⃣ 사용 가능한 사칙연산은 다음과 같습니다. (+, -, *, /)      |");
        System.out.println("| 3️⃣ 종료하려면 'exit'을, 계속하시려면 아무거나 입력해주세요.    |");
        System.out.println("----------------------------------------------------------");
        System.out.println();

        String input;

        do {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            sc.nextLine(); // 버퍼 비우기

            System.out.print("사칙연산 기호를 입력하세요 [ +, -, *, / ]: ");
            char op = sc.nextLine().charAt(0);

            int result = 0;
            boolean check = true;

            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("❌ 분모에 0이 올 수 없습니다!! ❌");
                        check = false;
                    }
                    else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("❌ 올바르지 않은 연산기호입니다. ❌");
                    check = false;
            }

            if (check) {
                System.out.println("😊 결과 : " + result);
            }

            System.out.print("종료하려면 'exit'을 입력해주세요!!: ");
            input = sc.nextLine();

            System.out.println(); // 한 줄 띄우기

        } while (!input.equals("exit"));

        System.out.println("계산기 종료");
        sc.close();
    }
}
