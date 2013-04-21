import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberConverter {

    enum NumbersIntervals {
        I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);
        int arabicNumber;

        NumbersIntervals(int arabicNumber) {
            this.arabicNumber = arabicNumber;
        }
    }

    public static void main(String[] args) {
        boolean state = true;
        int number = 0;
        number = inputNumber(state, number);
        System.out.println("Roman number:");
        System.out.print(convertArabicToRoman(number));
    }

    public static int inputNumber(boolean state, int number) {
        while (state) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.println("Enter arabic number: ");
                number = in.nextInt();
                state = false;
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input. Press number please!");
                state = true;
            }
        }
        return number;
    }

    static String convertArabicToRoman(int number) {
        String result = "";
        NumbersIntervals allIntervals[] = NumbersIntervals.values();
        result = generateRomanNumber(number, result, allIntervals);
        return result;
    }

    private static String generateRomanNumber(int number, String result, NumbersIntervals[] allIntervals) {
        for (int iterator = allIntervals.length - 1; iterator >= 0; iterator--) {
            while (number >= allIntervals[iterator].arabicNumber) {
                result = result + allIntervals[iterator].name();
                number = number - allIntervals[iterator].arabicNumber;
            }
        }
        return result;
    }
}
