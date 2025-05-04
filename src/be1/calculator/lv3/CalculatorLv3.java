package be1.calculator.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorLv3<T extends Number> {
    // 필드
    private List<Double> list = new ArrayList<>();

    // 메서드
    public Double calc(T num1, T num2, OperatorType op) {
        double a = num1.doubleValue();
        double b = num2.doubleValue();
        double result = 0;

        switch (op) {
            case ADD:
                result = a + b;
                break;
            case SUBTRACT:
                result = a - b;
                break;
            case MULTIPLY:
                result = a * b;
                break;
            case DIVIDE:
                if (b == 0) {
                    throw new ArithmeticException("❌ 분모에 0이 올 수 없습니다!! ❌");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("❌ 올바르지 않은 연산기호입니다. ❌");
        }
        list.add(result);
        return result;
    }

    // getter, setter 구현
    public List<Double> getList() {
        return list;
    }

    public void setList(List<Double> list) {
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

    public void showGreater(double input) {
        List<Double> filteredList = list.stream()
                .filter(num -> num > input)
                .collect(Collectors.toList());

        if (filteredList.isEmpty()) {
            System.out.println("❗ 해당 값보다 큰 값이 존재하지 않습니다.");
        }
        else {
            System.out.println("🔎 입력값보다 큰 값 목록 🔍");
            filteredList.forEach(num -> System.out.printf("%.2f%n", num));
        }
    }
}
