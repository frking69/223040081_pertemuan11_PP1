import java.util.Scanner;

public class PostFixApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a postfix expression:");
        String postfixExpression = scanner.nextLine();

        ParsePost parser = new ParsePost(postfixExpression);
        try {
            int result = parser.doParse();
            System.out.println("The result of the postfix expression is: " + result);
        } catch (InvalidExpressionException e) {
            System.out.println("Error evaluating the expression: " + e.getMessage());
        }
    }
}
