import java.util.*;

class DivideByZeroException extends Exception {
    public DivideByZeroException(String s) {
        super(s);
    }
}

class Practical8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean success = false;
        double result;

        while (!success) {
            try {
                System.out.print("Enter first number: ");
                double num = Double.parseDouble(sc.next());

                System.out.print("Enter second number: ");
                double num1 = Double.parseDouble(sc.next());

                System.out.print("Enter operator (+, -, *, /): ");
                char op = sc.next().charAt(0);

                if (op == '+') {
                    result = num + num1;
                } else if (op == '-') {
                    result = num - num1;
                } else if (op == '*') {
                    result = num * num1;
                } else if (op == '/') {
                    if (num1 == 0) {
                        throw new DivideByZeroException(
                                "Cannot divide by zero.");
                    }

                    result = num / num1;
                } else {
                    throw new IllegalArgumentException(
                            "Invalid operator.");
                }

                System.out.println("Result = " + result);
                success = true;
            }

            catch (DivideByZeroException e) {
                System.out.println(e.getMessage());
            }

            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            finally {
                System.out.println("Attempt logged.");
            }
        }
        System.out.println("25CE057");
        sc.close();
    }
}