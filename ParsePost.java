public class ParsePost {
    private MyStack stack;
    private String input;

    public ParsePost(String input) {
        this.input = input;
        this.stack = new MyStack(100); // stack dengan kapasitas yang cukup untuk penyimpanan
    }

    public int doParse() {
        String[] tokens = input.split(" "); // Memisahkan ekspresi berdasarkan spasi

        for (String token : tokens) {
            if (isNumeric(token)) { // Jika token adalah angka
                int num = Integer.parseInt(token);
                stack.push(num);
            } else { // Jika token adalah operator
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new InvalidExpressionException("Invalid operator: " + token);
                }
            }
        }

        // Setelah seluruh token diproses, stack harus memiliki tepat satu elemen
        if (stack.peek() == stack.pop()) {
            return stack.pop();
        } else {
            throw new InvalidExpressionException("Invalid postfix expression");
        }
    }

    // Metode untuk memeriksa apakah token adalah angka
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String expression = "2 3 4 * + 5 6 -"; // Ekspresi postfix
        ParsePost parser = new ParsePost(expression);

        int result = parser.doParse(); // Memproses ekspresi
        System.out.println("Hasil: " + result); // Hasil perhitungan
    }
}

class InvalidExpressionException extends RuntimeException {
    public InvalidExpressionException(String message) {
        super(message);
    }
}
