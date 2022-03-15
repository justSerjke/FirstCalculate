import java.util.Scanner;

public class Examination {

    static int firstNumber;
    static int secondNumber;
    static int result;
    static String expression;
    static boolean firstRomanOrArab;
    static boolean secondRomanOrArab;

    public static void doCalculations() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        if (strings.length != 3) {
            throw new IndexOutOfBoundsException("Проверьте правильность ввода выражения согласно условия");
        }

        Roman.addRomanNumber();
        firstRomanOrArab = Roman.romanNumbers.containsKey(strings[0]);
        secondRomanOrArab = Roman.romanNumbers.containsKey(strings[2]);

        if (firstRomanOrArab && secondRomanOrArab) {
            firstNumber = Roman.romanNumbers.get(strings[0]);
            secondNumber = Roman.romanNumbers.get(strings[2]);
            expression = strings[1];
            switch (expression) {
                case "+" -> {
                    result = firstNumber + secondNumber;
                }
                case "-" -> {
                    result = firstNumber - secondNumber;
                }
                case "*" -> {
                    result = firstNumber * secondNumber;
                }
                case "/" -> {
                    result = firstNumber / secondNumber;
                }
                default -> throw new IllegalStateException("Не является математической операцией: " + expression);
            }
            System.out.println("Результат: " + RomanToArab.roman(result));
        } else {
            try {
                firstNumber = Integer.parseInt(strings[0]);
                secondNumber = Integer.parseInt(strings[2]);
            } catch (NumberFormatException exception) {
                System.out.println("Проверьте правильность ввода значений");
                throw exception;
            }
                expression = strings[1];
                switch (expression) {
                    case "+" -> {
                        result = firstNumber + secondNumber;
                    }
                    case "-" -> {
                        result = firstNumber - secondNumber;
                    }
                    case "*" -> {
                        result = firstNumber * secondNumber;
                    }
                    case "/" -> {
                        result = firstNumber / secondNumber;
                    }
                    default -> throw new IllegalStateException("Не является математической операцией: " + expression);
                }
            System.out.println("Результат: " + result);
        }
    }
}