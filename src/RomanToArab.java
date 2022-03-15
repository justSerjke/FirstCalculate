public class RomanToArab {
    public static String roman(int result) {

        if (result <= 0) {
            throw new IllegalArgumentException("В римской системе нет отрицательных чисел");
        }

        StringBuilder stringBuilder = new StringBuilder();

        RomanNumbers[] values = RomanNumbers.values();
        for (int i = values.length - 1; i >= 0; i--) {
            while (result >= values[i].value) {
                stringBuilder.append(values[i]);
                result -= values[i].value;
            }
        }
        return stringBuilder.toString();
    }
}