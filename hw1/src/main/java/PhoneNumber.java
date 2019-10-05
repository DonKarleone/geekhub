import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputNumber;
        boolean validNumber;
        long totalResult;
        Pattern numberPattern = Pattern.compile("^(\\+38|0038|8)?0(50|63|66|67|68|93|95|96|97|98)[0-9]{7}$");

        do {
            System.out.println("Please enter the phone number:");
            inputNumber = in.next();
            validNumber = numberPattern.matcher(inputNumber).matches();
            if (validNumber) {
                System.out.println("Phone number is correct.");
            } else {
                System.out.println("Phone number is incorrect.");
            }
        } while (!validNumber);

        totalResult = Long.parseLong(inputNumber.replaceAll("[^0-9]", ""));
        for (int i = 1; totalResult > 9; i++) {
            long sumDigits = 0;
            while (totalResult > 0) {
                sumDigits += totalResult % 10;
                totalResult /= 10;
            }
            totalResult = sumDigits;
            System.out.println(i + " round of calculation, sum is: " + totalResult);
        }

        System.out.print("Final result is: ");
        if (totalResult == 1) {
            System.out.println("One");
        } else if (totalResult == 2) {
            System.out.println("Two");
        } else if (totalResult == 3) {
            System.out.println("Three");
        } else if (totalResult == 4) {
            System.out.println("Four");
        } else {
            System.out.println(totalResult);
        }
    }
}
