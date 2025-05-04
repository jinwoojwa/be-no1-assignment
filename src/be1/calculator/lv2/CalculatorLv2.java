package be1.calculator.lv2;

import java.util.*;

public class CalculatorLv2 {

    // 필드
    private List<Integer> list = new ArrayList<>();

    // 메서드
    public int calc(int num1, int num2, char op) {
        int result = 0;

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
                    throw new ArithmeticException("❌ 분모에 0이 올 수 없습니다!! ❌");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("❌ 올바르지 않은 연산기호입니다. ❌");
        }
        list.add(result);
        return result;
    }

    // getter, setter 구현
    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    // 가장 먼저 저장된 데이터 삭제 메서드
    public void removeResult() {
        if (!list.isEmpty()) {
            list.remove(0);
            System.out.println("✅삭제가 완료되었습니다.");
        }
        else {
            System.out.println("❌ 삭제 가능한 값이 존재하지 않습니다.");
        }
    }
}
