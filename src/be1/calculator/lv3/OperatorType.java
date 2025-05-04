package be1.calculator.lv3;

public enum OperatorType {
    ADD('+'), SUBTRACT('-'), MULTIPLY('*'), DIVIDE('/');

    private final char op;

    OperatorType(char op) {
        this.op = op;
    }

    public char getOp() {
        return op;
    }

    public static OperatorType getByOp(char c) {
        for (OperatorType t : values()) {
            if (t.op == c) return t;
        }
        throw new IllegalArgumentException("❌ " + c +"는 유효하지 않은 연산자입니다");
    }
}
