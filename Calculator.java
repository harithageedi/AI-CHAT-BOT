public class Calculator {

    public static String calculate(String input) {

        input = input.replace("calculate", "").trim();

        char operator = ' ';

        if (input.contains("+"))
            operator = '+';
        else if (input.contains("-"))
            operator = '-';
        else if (input.contains("*"))
            operator = '*';
        else if (input.contains("/"))
            operator = '/';
        else
            return "Invalid calculation.";

        String[] parts = input.split("\\" + operator);

        if (parts.length != 2)
            return "Invalid calculation.";

        try {

            double num1 = Double.parseDouble(parts[0].trim());
            double num2 = Double.parseDouble(parts[1].trim());

            switch (operator) {

                case '+':
                    return "Answer = " + (num1 + num2);

                case '-':
                    return "Answer = " + (num1 - num2);

                case '*':
                    return "Answer = " + (num1 * num2);

                case '/':
                    if (num2 == 0)
                        return "Cannot divide by zero.";

                    return "Answer = " + (num1 / num2);
            }

        } catch (Exception e) {
            return "Please enter a valid calculation.";
        }

        return "Something went wrong.";
    }
}
