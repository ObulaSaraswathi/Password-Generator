import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[{]};:'\",<.>/?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();

        System.out.println("Include the following in your password:");
        System.out.print("Uppercase letters (Y/N): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("Y");
        System.out.print("Lowercase letters (Y/N): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("Y");
        System.out.print("Numbers (Y/N): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("Y");
        System.out.print("Special characters (Y/N): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("Y");

        String generatedPassword = generatePassword(length, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars);
        System.out.println("Generated Password: " + generatedPassword);

        scanner.close();
    }

    private static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialChars) {
        StringBuilder validChars = new StringBuilder();
        if (includeUppercase) {
            validChars.append(UPPERCASE_CHARACTERS);
        }
        if (includeLowercase) {
            validChars.append(LOWERCASE_CHARACTERS);
        }
        if (includeNumbers) {
            validChars.append(NUMBERS);
        }
        if (includeSpecialChars) {
            validChars.append(SPECIAL_CHARACTERS);
        }

        if (validChars.length() == 0) {
            throw new IllegalArgumentException("At least one character type should be selected.");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }
        return password.toString();
    }
}
